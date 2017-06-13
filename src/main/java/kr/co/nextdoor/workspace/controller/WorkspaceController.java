package kr.co.nextdoor.workspace.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.nextdoor.workspace.dto.WorkspaceDTO;
import kr.co.nextdoor.workspace.service.WorkspaceService;

@Controller
public class WorkspaceController {
	
	@Autowired
	private WorkspaceService service;

	//로그인 후 워크스페이스 선택 화면
	@RequestMapping(value = "workspace.htm")
	public String workspaceList(Model model) {
		List<WorkspaceDTO> workspacelist = service.WorkspaceList();
		
		/*mav.addObject("workspacelist",workspacelist);
		mav.setViewName("login.workspace");*/
		
		model.addAttribute("workspacelist",workspacelist);
		System.out.println("workspace(controller) : " +workspacelist);
		System.out.println("workspace(controller) : " +workspacelist.toString());
		return "login.workspace";
	}

	//워크스페이스 만들기 화면으로 이동
	@RequestMapping(value = "workspaceInsert.htm", method = RequestMethod.GET)
	public String workspaceInsert() {
		
		return "login.workspaceInsert";
	}
	
/*	@RequestMapping(value = "workspaceInsert.htm", method = RequestMethod.POST)
	public String workspaceInsert(Model model) {
		model.addAllAttributes("result","워크스페이스 등록 성공");
		return "redirect:login.workspace.htm";
	}
*/
	@RequestMapping(value = "main.htm", method = RequestMethod.GET)
	public String main() {

		return "main.main";
	}
}
