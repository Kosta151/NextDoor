package kr.co.nextdoor.project.controller;

import java.security.Principal;

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

	// 워크스페이스 선택시 프로젝트 선택화면으로 이동
	@RequestMapping("projectList.htm")
	public ModelAndView projectList(ProjectDTO projectdto, Principal principal) throws Exception {
		ModelAndView mav = new ModelAndView();
		projectdto.setMember_id(principal.getName());
		mav.addObject("projectlist", service.projectList(projectdto));
		mav.addObject("workspace_no", projectdto.getWorkspace_no());
		mav.setViewName("project.projectList");
		return mav;
	}
	// 프로젝트 추가
	@RequestMapping(value = "insertProject.htm", method = RequestMethod.POST)
	public ModelAndView projectInsert(ProjectDTO projectdto, Principal principal) throws Exception {
		ModelAndView mav = new ModelAndView();
		projectdto.setMember_id(principal.getName());
		service.projectInsert(projectdto);
		service.insertProjectMember(projectdto);
		mav.addObject("projectlist", service.projectList(projectdto));
		mav.addObject("workspace_no", projectdto.getWorkspace_no());
		mav.setViewName("project.projectList");
		return mav;
	}

	@RequestMapping(value = "projectUpdate.htm", method = RequestMethod.GET)
	public String projectUpdate() {

		return "project.projectUpdate";
	}
	/*
	// 프로젝트 삭제
	@RequestMapping("projectDelete.htm")
	public String deleteProject(int project_no) throws Exception{
		service.deleteProject(project_no);
		return "redirect:projectList.htm";
	}*/
}
