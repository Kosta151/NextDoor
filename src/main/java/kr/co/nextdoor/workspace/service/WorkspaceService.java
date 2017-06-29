package kr.co.nextdoor.workspace.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.workspace.dao.WorkspaceDAO;
import kr.co.nextdoor.workspace.dto.WorkspaceDTO;
/*
* @Class : WorkspaceService
* @Date : 2017. 06. 
* @Author : 이재민
* @Desc : workspace controller에 대한 service
*/
@Service
public class WorkspaceService {

	@Autowired
	private SqlSession sqlsession;

   /*
    * @method Name : listWorkspace
    * @date : 2017. 06. 
    * @author : 이재민
    * @description : workspace 목록
    * @return : List
    */
	public List<WorkspaceDTO> listWorkspace() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		WorkspaceDAO workspacedao = sqlsession.getMapper(WorkspaceDAO.class);
		return workspacedao.listWorkspace(user.getUsername());
	}

	/*
    * @method Name : insertWorkspace
    * @date : 2017. 06. 
    * @author : 이재민
    * @description : workspace 생성
    * @param : workspacedto
    * @return : int
    */
	public int insertWorkspace(WorkspaceDTO workspacedto) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		workspacedto.setMember_id(user.getUsername());
		WorkspaceDAO workspacedao = sqlsession.getMapper(WorkspaceDAO.class);
		return workspacedao.insertWorkspace(workspacedto);
	}
	
	/*
    * @method Name : deleteWorkspace
    * @date : 2017. 06. 
    * @author : 이재민
    * @description : workspace 삭제
    * @param : workspace_no
    * @return : int
    */
	public int deleteWorkspace(int workspace_no) throws Exception{
			WorkspaceDAO workspacedao = sqlsession.getMapper(WorkspaceDAO.class);
			return workspacedao.deleteWorkspace(workspace_no);
	}
	
	/*
	    * @method Name : 
	    * @date : 2017. 06. 
	    * @author : 이재민
	    * @description : 
	    * @param : workspace_no
	    * @return : String
	    */
	public String nameWorkspace(String workspace_no) throws Exception{
			WorkspaceDAO workspacedao = sqlsession.getMapper(WorkspaceDAO.class);
			return workspacedao.nameWorkspace(workspace_no);
	}
	public String ownerWorkspace(String workspace_no) throws Exception{
		WorkspaceDAO workspacedao = sqlsession.getMapper(WorkspaceDAO.class);
		return workspacedao.ownerWorkspace(workspace_no);
}
}