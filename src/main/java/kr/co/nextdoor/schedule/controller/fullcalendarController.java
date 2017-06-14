	package kr.co.nextdoor.schedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class fullcalendarController {
	
	@RequestMapping(value="calendar.htm" , method=RequestMethod.GET)
	public String calendar(){
		System.out.println("캘린더 View 페이지");
		return "fullcalendar.fullcalendarTask";
	}
	
}
