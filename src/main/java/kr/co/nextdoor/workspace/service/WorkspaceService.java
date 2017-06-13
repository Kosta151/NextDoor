package kr.co.nextdoor.workspace.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.member.dao.MemberDAO;
import kr.co.nextdoor.workspace.dao.WorkspaceDAO;
import kr.co.nextdoor.workspace.dto.WorkspaceDTO;

@Service
public class WorkspaceService {
	
	@Autowired
	private SqlSession sqlsession;
	
	public List<WorkspaceDTO> WorkspaceList(){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user.getUsername();
		WorkspaceDAO workspacedao = sqlsession.getMapper(WorkspaceDAO.class);
		System.out.println("워크스페이스 로드 : "+user.getUsername());
		return workspacedao.workspacelist(user.getUsername());
	}
}