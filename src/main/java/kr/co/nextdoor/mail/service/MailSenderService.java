package kr.co.nextdoor.mail.service;
 
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
 
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
import org.apache.ibatis.session.SqlSession;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
 
import kr.co.nextdoor.mail.dao.MailDao;
import kr.co.nextdoor.mail.dto.MailDto;
import kr.co.nextdoor.member.dto.MemberDTO;
import kr.co.nextdoor.specifictask.dao.SpecificTaskDAO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskModiDTO;
/*
* @Class : MailSenderService
* @Date : 2017. 06. 23
* @Author : 문창균, 송지은
* @Desc : mail controller에 대한 service
*/
@Service
public class MailSenderService {
   private static final String String = null;
   @Autowired
   private JavaMailSender mailSender;
   @Autowired
   private VelocityEngine velocityEngin;
   @Autowired
   private SqlSession sqlsession;
   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;
   /*
    * @method Name : sendMail
    * @date : 2017. 06. 22
    * @author : 문창균
    * @description : 
    * @param : maildto
    * @return : void
    */
   public void sendMail(MailDto maildto) throws Exception{
      MimeMessage msg = mailSender.createMimeMessage();
      MimeMessageHelper message = new MimeMessageHelper(msg, true, "utf-8");
      message.setFrom("anscr@naver.com");
      message.setTo(new InternetAddress(maildto.getMember_id()));
      message.setSubject(maildto.getSubject());
      Template template = velocityEngin.getTemplate("/mailvelocity/" +maildto.getTemplate());   
      VelocityContext velocityContext = new VelocityContext();
      velocityContext.put("member_id", maildto.getMember_id());
      velocityContext.put("content", maildto.getContent());
      StringWriter stringwriter = new StringWriter();
      template.merge(velocityContext, stringwriter);
      message.setText(stringwriter.toString(),true); 
      mailSender.send(msg);
   }
   /*
    * @method Name : inviteSendMail
    * @date : 2017. 06. 22
    * @author : 송지은
    * @description : 프로젝트 멤버 초대
    * @param : maildto
    * @return : void
    */
   public void inviteSendMail(MailDto maildto) throws Exception{
      MimeMessage msg = mailSender.createMimeMessage();
      MimeMessageHelper message = new MimeMessageHelper(msg, true, "utf-8");
      message.setFrom("anscr@naver.com");
      message.setTo(new InternetAddress(maildto.getMember_id()));
      message.setSubject("멤버초대 on NextDoor");
      Template template = velocityEngin.getTemplate("/mailvelocity/" + "inviteMember.vm");
      VelocityContext velocityContext = new VelocityContext();
      velocityContext.put("member_id", maildto.getMember_id());
      velocityContext.put("name", maildto.getName());
      velocityContext.put("content", "멤버 초대가 도착하였습니다."); 
      StringWriter stringwriter = new StringWriter();
      template.merge(velocityContext, stringwriter);
      message.setText(stringwriter.toString(),true);
      mailSender.send(msg);
   }
   /*
    * @method Name : insertProjectMember
    * @date : 2017. 06. 22
    * @author : 송지은
    * @description : 프로젝트 멤버 초대 후에 프로젝트멤버 insert
    * @param : maildto
    * @return : void
    */
   public void insertProjectMember(MailDto maildto) throws Exception{
         MailDao maildao = sqlsession.getMapper(MailDao.class);
         maildao.insertProjectMember(maildto);
         return;
   }
   /*
    * @method Name : senddeadline
    * @date : 2017. 06. 26
    * @author : 문창균, 송지은
    * @description : 마감 하루전에 메일 전송
    * @return : void
    */
   public void senddeadline(){
      SimpleDateFormat simpledateformat = new SimpleDateFormat ("yyyy-MM-dd"); 
      Calendar calendar = new GregorianCalendar();
      calendar.add(Calendar.DATE, +1);
      String currentTime = simpledateformat.format(calendar.getTime());
      SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
      ArrayList<SpecificTaskModiDTO> maildtolist = specifictaskdao.selectTaskdeadline();
      for(int i =0; i<maildtolist.size() ; i++){
         if(maildtolist.get(i).getSpecifictask_end().equals(currentTime)){
            MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper message;
            try{
               message = new MimeMessageHelper(msg, true, "utf-8");
               message.setFrom("anscr@naver.com");
               message.setTo(new InternetAddress(maildtolist.get(i).getMember_id()));
               message.setSubject("schedule");    
               Template template = velocityEngin.getTemplate("/mailvelocity/deadline.vm");              
               VelocityContext velocityContext = new VelocityContext();
               velocityContext.put("content", maildtolist.get(i).getSpecifictask_cont());
               velocityContext.put("user", maildtolist.get(i).getMember_id());               
               StringWriter stringwriter = new StringWriter();
               template.merge(velocityContext, stringwriter);                            
               message.setText(stringwriter.toString(),true);            
               mailSender.send(msg);     
            }catch (Exception e){ 
               System.out.println(e.getMessage());
            }
         }
      }
   }
   /*
    * @method Name : updatePassword
    * @date : 2017. 06. 25
    * @author : 문창균, 송지은
    * @description : 비밀번호 찾기, 암호화 해서 비밀번호 변경
    * @param : maildto
    * @return : boolean
    */
   public boolean updatePassword(MailDto maildto){
      boolean result = false;
      MailDao maildao = sqlsession.getMapper(MailDao.class);
      MailDto dtoresult = maildao.searchMember(maildto.getMember_id());
      if(dtoresult !=null){
         maildto.setContent(maildto.getContent());         
         maildto.setPassword(this.bCryptPasswordEncoder.encode(maildto.getContent()));
         HashMap<String, String> map = new HashMap<String, String>();
         map.put("password", maildto.getPassword());
         map.put("member_id", maildto.getMember_id());    
         int update = maildao.updatePassword(map);
         if(update>0){
            result = true;
         }            
      }  
      return result;
   }
}