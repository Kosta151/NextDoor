package kr.co.nextdoor.mail.service;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.ibatis.session.SqlSession;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.mail.dao.MailDao;
import kr.co.nextdoor.mail.dto.MailDto;
import kr.co.nextdoor.member.dto.MemberDTO;

@Service
public class MailSenderService {
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private VelocityEngine velocityEngin;

	@Autowired
	private SqlSession sqlsession;
	
	
	
	public void sendMail(MailDto maildto) throws Exception{
		
		//값확인
		System.out.println(maildto.getMember_id());
		System.out.println(maildto.getSubject());
		System.out.println(maildto.getTemplate());
		
		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper message = new MimeMessageHelper(msg, true, "utf-8");
		System.out.println("sendMail");
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
	
	public void senddeadline(){
		SimpleDateFormat simpledateformat = new SimpleDateFormat ("yyyy-MM-dd"); 
		Date currentTime = new Date(); 
		simpledateformat.format ( currentTime ); 
		System.out.println ( "현재날자 : " + simpledateformat.format ( currentTime ) );		
		
		MailDao maildao = sqlsession.getMapper(MailDao.class);
		ArrayList<MailDto> maildtolist = maildao.selectTaskdeadline();
		
		for(int i =0; i<maildtolist.size() ; i++){
			if(!maildtolist.get(i).getTaskdate().toString().equals(simpledateformat.format ( currentTime )) ){
				
				
				MimeMessage msg = mailSender.createMimeMessage();
				MimeMessageHelper message;
				try {
					message = new MimeMessageHelper(msg, true, "utf-8");
					System.out.println("sendMail");
					message.setFrom("anscr@naver.com");
					message.setTo(new InternetAddress(maildtolist.get(i).getMember_id()));
					message.setSubject("schedule 메일 발송");
					

					Template template = velocityEngin.getTemplate("/mailvelocity/deadline.vm");
					
					VelocityContext velocityContext = new VelocityContext();
					velocityContext.put("content", maildtolist.get(i).getContent());
					velocityContext.put("user", maildtolist.get(i).getMember_id());
					
					StringWriter stringwriter = new StringWriter();
					template.merge(velocityContext, stringwriter);
					
					
					message.setText(stringwriter.toString(),true);
					
					mailSender.send(msg);
				
				
				
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
				
				
			}
			
			
		}
	
	}
	
	/*public boolean searchMemberId(String member_id){
		boolean result = false;
		System.out.println(member_id);
		MailDao maildao = sqlsession.getMapper(MailDao.class);
		System.out.println(id+"id");
		MailDto maildto = maildao.searchMember(member_id);
		if(maildto !=null){
			result = true;
		}
		
		return result;
	}*/
	
	public boolean updatePassword(MailDto maildto){
		boolean result = false;
		
		MailDao maildao = sqlsession.getMapper(MailDao.class);
		MailDto dtoresult = maildao.searchMember(maildto.getMember_id());
		
		if(dtoresult !=null){
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("password", maildto.getContent());
			map.put("member_id", maildto.getMember_id());
			int update = maildao.updatePassword(map);
			if(update>0){
				result = true;
			}
					
		}
		
		return result;
	}
}













