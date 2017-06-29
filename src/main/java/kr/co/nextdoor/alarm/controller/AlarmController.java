package kr.co.nextdoor.alarm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.nextdoor.alarm.service.AlarmService;

@Controller
public class AlarmController {

	@Autowired
	AlarmService alarmservice;
	
	@RequestMapping(value="alarmlist.htm")
	public String Alarmlist(String receiver_id, HttpSession session){
		
	session.setAttribute("alarmlist",alarmservice.AlarmList(receiver_id));	
	System.out.println("alarm1:"+alarmservice.AlarmList(receiver_id));
		return "header.jsp";
	}
	
	/*@RequestMapping()
	public String Alarmcount(String receiver_id, Model model){
		model.addAttribute("alarmcount", alarmservice.CountAlarmList(receiver_id));
		return "";
	}*/
	
}
