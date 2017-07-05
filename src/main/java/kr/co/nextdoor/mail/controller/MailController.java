package kr.co.nextdoor.mail.controller;
 
 
import java.security.Principal;
import java.util.Random;
 
import javax.servlet.http.HttpSession;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import kr.co.nextdoor.mail.dto.MailDto;
import kr.co.nextdoor.mail.service.MailSenderService;
 
/*
* @Class : MailController
* @Date : 2017. 06. 21 
* @Author : 문창균, 송지은
* @Desc : MailController
*/
 
@Controller
public class MailController { 
   @Autowired
   private MailSenderService mailsenderservice;  
   /*
    * @method Name : invitemailSender
    * @date : 2017. 06. 24
    * @author : 송지은
    * @description : 프로젝트 멤버초대 메일 전송, projectmember테이블에 초대된 멤버 추가
    */
   @RequestMapping(value="inviteMail.htm", method=RequestMethod.POST)
   public String invitemailSender(MailDto maildto, Principal principal, HttpSession session) throws Exception{
      String projectno = (String) session.getAttribute("project_no");    
      maildto.setMember_id(maildto.getMember_id());
      maildto.setProject_no((String)session.getAttribute("project_no"));      
      mailsenderservice.inviteSendMail(maildto);
      mailsenderservice.insertProjectMember(maildto);
      return "redirect:projectUpdate.htm?project_no="+projectno;
   }
   /*
    * @method Name : senddeadline
    * @date : 2017. 06. 25
    * @author : 문창균
    * @description : 
    */
   @Scheduled(cron="0 20 11 * * *")
   public void senddeadline() throws Exception{
      mailsenderservice.senddeadline();
   }
   /*
    * @method Name : searchPassword
    * @date : 2017. 06. 25
    * @author : 문창균, 송지은
    * @description : 비밀번호 찾기, 암호화 해서 비밀번호 변경
    */
   @RequestMapping(value="password.htm", method=RequestMethod.POST)
   public String searchPassword(MailDto maildto) throws Exception{
      Random randompassword = new Random();
      StringBuffer newpassword = new StringBuffer();
      for(int i=0;i<8;i++){
          if(randompassword.nextBoolean()){
             newpassword.append((char)((int)(randompassword.nextInt(26))+97));
          }else{
             newpassword.append((randompassword.nextInt(10))); 
          }
      }
      String password = newpassword.toString();
      maildto.setContent(password);
       boolean result = mailsenderservice.updatePassword(maildto);
       if(result==true){
          mailsenderservice.sendMail(maildto);          
       }    
       return "index.index";  
    }  
   }