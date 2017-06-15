package kr.co.nextdoor.workspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.nextdoor.workspace.dto.WorkspaceDTO;
import kr.co.nextdoor.workspace.service.WorkspaceService;

@Controller
public class WorkspaceController {

	@Autowired
	private WorkspaceService service;

	// 로그인후 워크스페이스 선택화면으로 이동
	@RequestMapping(value = "workspace.htm")
	public String workspaceList(Model model) {
		model.addAttribute("workspacelist", service.WorkspaceList());
		return "login.workspace";
	}

	// 워크스페이스 추가화면으로 이동
	@RequestMapping(value = "workspaceInsert.htm", method = RequestMethod.GET)
	public String workspaceInsert() {
		return "login.workspaceInsert";
	}

	// 워크스페이스 추가후 워크스페이스 선택화면으로 이동
	@RequestMapping(value = "workspaceInsert.htm", method = RequestMethod.POST)
	public String workspaceInsert(WorkspaceDTO workspacedto) {
		System.out.println(workspacedto.toString());
		service.WorkspaceInsert(workspacedto);
		return "redirect:workspace.htm";
	}
}
