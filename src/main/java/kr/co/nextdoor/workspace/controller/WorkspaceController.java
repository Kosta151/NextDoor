package kr.co.nextdoor.workspace.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.nextdoor.workspace.dto.WorkspaceDTO;
import kr.co.nextdoor.workspace.service.WorkspaceService;

/*
* @Class : WorkspaceController
* @Date : 2017. 06. 13
* @Author : 이재민
* @Desc : workspace
*/

@Controller
public class WorkspaceController {

	@Autowired
	private WorkspaceService service;
	
	/*
    * @method Name : workspaceList
    * @date : 2017. 06. 13
    * @author : 이재민
    * @description : 로그인 후 워크스페이스 선택화면으로 이동
    */
	@RequestMapping(value = "workspace.htm")
	public String workspaceList(Model model, HttpSession session) {
		session.removeAttribute("workspace_no");
		model.addAttribute("workspacelist", service.listWorkspace());
		return "login.workspace";
	}

	/*
    * @method Name : workspaceInsert
    * @date : 2017. 06. 13
    * @author : 이재민
    * @description : 워크스페이스 추가화면으로 이동
    */
	@RequestMapping(value = "workspaceInsert.htm", method = RequestMethod.GET)
	public String workspaceInsert() {
		
		return "login.workspaceInsert";
	}
	
	/*
    * @method Name : workspaceInsert
    * @date : 2017. 06. 13
    * @author : 이재민
    * @description : 워크스페이스 추가 후 워크스페이스 선택화면으로 이동
    */ 
	@RequestMapping(value = "workspaceInsert.htm", method = RequestMethod.POST)
	public String workspaceInsert(WorkspaceDTO workspacedto) {
		service.insertWorkspace(workspacedto);
		return "redirect:workspace.htm";
	}
	
	/*
    * @method Name : workspaceDelete
    * @date : 2017. 06. 15
    * @author : 송지은
    * @description : 워크스페이스 삭제 후 워크스페이스 선택화면으로 이동
    */
	@RequestMapping("workspaceDelete.htm")
	public String workspaceDelete(int workspace_no) throws Exception{
		service.deleteWorkspace(workspace_no);
		return "redirect:workspace.htm";
	}
}
