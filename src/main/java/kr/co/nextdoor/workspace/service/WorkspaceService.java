package kr.co.nextdoor.workspace.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.workspace.dao.WorkspaceDAO;
import kr.co.nextdoor.workspace.dto.WorkspaceDTO;

@Service
public class WorkspaceService {

	@Autowired
	private SqlSession sqlsession;

	// 로그인시 워크스페이스 목록
	public List<WorkspaceDTO> WorkspaceList() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		WorkspaceDAO workspacedao = sqlsession.getMapper(WorkspaceDAO.class);
		return workspacedao.workspacelist(user.getUsername());
	}

	// 워크스페이스 추가
	public int WorkspaceInsert(WorkspaceDTO workspacedto) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		workspacedto.setMember_id(user.getUsername());
		WorkspaceDAO workspacedao = sqlsession.getMapper(WorkspaceDAO.class);
		return workspacedao.workspaceinsert(workspacedto);
	}
}