package kr.co.nextdoor.project.service;

import java.security.Principal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.project.dao.ProjectDAO;
import kr.co.nextdoor.project.dto.ProjectDTO;

@Service
public class ProjectService {

	@Autowired
	private SqlSession sqlsession;
	
	/*public int projectList(ProjectDTO projectdto) throws Exception{
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		projectdto.setMEMBER_ID(user.getUsername());
		ProjectDAO projectdao = sqlsession.getMapper(ProjectDAO.class);
		return projectdao.insertProject(projectdto, WORKSPACE_NO);
	}*/
	
	public List<ProjectDTO> projectList() throws Exception{
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ProjectDAO projectdao = sqlsession.getMapper(ProjectDAO.class);
		return projectdao.projectList(user.getUsername());
	}
	
	public int projectInsert(ProjectDTO projectdto) throws Exception{
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		projectdto.setMember_id(user.getUsername());
		ProjectDAO projectdao = sqlsession.getMapper(ProjectDAO.class);
		return projectdao.insertProject(projectdto);
	}
	
}
