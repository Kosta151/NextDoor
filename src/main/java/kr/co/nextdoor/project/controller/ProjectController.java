package kr.co.nextdoor.project.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.nextdoor.project.dto.ProjectDTO;
import kr.co.nextdoor.project.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService service;

	// 워크스페이스 선택시 프로젝트 선택화면으로 이동
	@RequestMapping("projectList.htm")
	public ModelAndView projectList(@RequestParam("workspace_name") String workspace_name, Principal principal,
			ProjectDTO projectdto) throws Exception {
		ModelAndView mav = new ModelAndView();
		projectdto.setMember_id(principal.getName());
		projectdto.setWorkspace_name(workspace_name);
		mav.addObject("projectlist", service.projectList(projectdto));
		mav.setViewName("project.projectList");
		return mav;
	}

	@RequestMapping(value = "insertProject.htm", method = RequestMethod.POST)
	public String projectInsert(ProjectDTO projectdto) throws Exception {

		service.projectInsert(projectdto);
		return "redirect:projectList.htm";
	}

	@RequestMapping(value = "projectUpdate.htm", method = RequestMethod.GET)
	public String projectUpdate() {

		return "project.projectUpdate";
	}
}
