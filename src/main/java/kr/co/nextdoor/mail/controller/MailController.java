package kr.co.nextdoor.mail.controller;


import java.security.Principal;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.nextdoor.mail.dto.MailDto;
import kr.co.nextdoor.mail.service.MailSenderService;
import kr.co.nextdoor.project.service.ProjectService;


@Controller
public class MailController {

	@Autowired
	private MailSenderService mailsenderservice;
	
	
	//�ʴ� ����
	@RequestMapping(value="/mail.htm", method=RequestMethod.GET)
	public String mailFrom(){
		System.out.println("���� ������ �̵�");
		return "mail.mailForm";
	}
	//�ʴ� ���� 
	@RequestMapping(value="/mail.htm", method=RequestMethod.POST)
	public String mailSender(MailDto maildto) throws Exception{
		
		mailsenderservice.sendMail(maildto);
		
		return "index.index";
	}
	
	//프로젝트 멤버 초대
	@RequestMapping(value="inviteMail.htm", method=RequestMethod.POST)
	public String invitemailSender(MailDto maildto, Principal principal, HttpSession session) throws Exception{
		/*String member_id = (String) session.getAttribute("member_id");*/
		/*String project_no = (String) session.getAttribute("project_no");*/
		System.out.println(maildto.getMember_id());
		System.out.println("프로젝트아이디" + session.getAttribute("project_no"));
		maildto.setMember_id(maildto.getMember_id());
		maildto.setProject_no((String)session.getAttribute("project_no"));
		mailsenderservice.inviteSendMail(maildto);
		mailsenderservice.insertProjectMember(maildto);
		return "project.projectUpdate";
	}
	
	
	//�����층 ����
	@Scheduled(cron="0 09 0 * * ?")
	public void senddeadline(){
		System.out.println("schedul �߼�");
		mailsenderservice.senddeadline();
	}
	
	//��й�ȣ ã�����
		/*@RequestMapping(value="/password.htm", method=RequestMethod.POST)
		public String searchPassword(MailDto maildto) throws Exception{
			System.out.println(maildto.getMember_id());        
	        System.out.println(maildto.getTemplate());    

	        boolean result = mailsenderservice.searchMemberId(maildto.getMember_id());
	        if(result==true){
	        	Random randompassword =new Random();
	        	StringBuffer newpassword =new StringBuffer();
	        	for(int i=0;i<8;i++){
	        	    if(randompassword.nextBoolean()){
	        	    	newpassword.append((char)((int)(randompassword.nextInt(26))+97));
	        	    }else{
	        	    	newpassword.append((randompassword.nextInt(10))); 
	        	    }
	        	}
	        	System.out.println("newpassword : " + newpassword);
	        	
	        	maildto.setContent(newpassword);
	        	System.out.println(newpassword);
	        	mailsenderservice.sendMail(maildto);
	    		    	
	        } 	
	        return "index.index";  
	        }*/
	
	@RequestMapping(value="/password.htm", method=RequestMethod.POST)
	public String searchPassword(MailDto maildto) throws Exception{
		Random randompassword =new Random();
    	StringBuffer newpassword =new StringBuffer();
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
	
	
