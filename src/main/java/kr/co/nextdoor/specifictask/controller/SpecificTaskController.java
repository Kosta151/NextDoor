package kr.co.nextdoor.specifictask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import kr.co.nextdoor.specifictask.dto.SpecificTaskDTO;
import kr.co.nextdoor.specifictask.service.SpecificTaskService;

@Controller
public class SpecificTaskController {

	@Autowired
	SpecificTaskService specifictaskservice;
	
	@Autowired
	View jsonview;
	
	@RequestMapping(value="specifictask.htm", method=RequestMethod.POST)
	public View listSpecificTask(String task_no, Model model){
		List<SpecificTaskDTO> specifictasklist = specifictaskservice.listSpecificTask(task_no);
		model.addAttribute("data", specifictasklist);
		return jsonview;
		
	}
	
}
