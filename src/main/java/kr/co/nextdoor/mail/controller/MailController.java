package kr.co.nextdoor.mail.controller;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.nextdoor.mail.dto.MailDto;
import kr.co.nextdoor.mail.service.MailSenderService;


@Controller
public class MailController {

	@Autowired
	private MailSenderService mailsenderservice;
	
	//초대 메일
	@RequestMapping(value="/mail.htm", method=RequestMethod.GET)
	public String mailFrom(){
		System.out.println("메일 폼으로 이동");
		return "mail.mailForm";
	}
	//초대 메일 
	@RequestMapping(value="/mail.htm", method=RequestMethod.POST)
	public String mailSender(MailDto maildto) throws Exception{
		
		mailsenderservice.sendMail(maildto);
		
	

		
		return "index.index";
	}
	//스케쥴링 메일
	@Scheduled(cron="0 09 0 * * ?")
	public void senddeadline(){
		System.out.println("schedul 발송");
		mailsenderservice.senddeadline();
	}
	
	//비밀번호 찾기메일
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
	
	
