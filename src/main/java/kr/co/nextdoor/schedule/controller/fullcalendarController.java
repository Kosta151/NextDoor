package kr.co.nextdoor.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.nextdoor.project.dto.ProjectDTO;
import kr.co.nextdoor.schedule.service.FullcalendarService;

@Controller
public class fullcalendarController {
	
	@Autowired
	private FullcalendarService service;
	//Veiw 페이지
	@RequestMapping(value="calendar.htm" , method=RequestMethod.GET)
	public String calendar(){
		return "fullcalendar.fullcalendarTask";
	}
	
	//캘린더 프로젝트 목록 보기
	//캘린더 프로젝트 생성
	@RequestMapping(value="insertFullcalendarProject.htm", method=RequestMethod.POST)
	public String fullcalendarProjectInsert(ProjectDTO projectdto) throws Exception{
		System.out.println("캘린더에 프로젝트 삽입");
		service.fullcalendarProjectInsert(projectdto);
		return "fullcalendar.fullcalendarTask";
			
	}
	
}
