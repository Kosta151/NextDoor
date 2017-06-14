package kr.co.nextdoor.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.nextdoor.project.dto.ProjectDTO;
import kr.co.nextdoor.project.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService service;
	
	//프로젝트 목록보기
	@RequestMapping(value = "projectList.htm", method = RequestMethod.GET)
	public ModelAndView projectList(ModelAndView mav, String workspace_no) throws Exception {
		mav.addObject("projectlist", service.projectList());
		mav.setViewName("project.projectList"); //자동 forward
		return mav;
	}
	
	//프로젝트 생성
	@RequestMapping(value="insertProject.htm", method=RequestMethod.POST)
	public String projectInsert(ProjectDTO projectdto) throws Exception{
		System.out.println(projectdto.toString());
		service.projectInsert(projectdto);
		return "redirect:projectList.htm";
	}
	
	//프로젝트수정
	@RequestMapping(value = "projectUpdate.htm", method = RequestMethod.GET)
	public String projectUpdate() {

		return "project.projectUpdate";
	}
	
	
	
	
}
