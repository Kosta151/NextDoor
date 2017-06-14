package kr.co.nextdoor.schedule.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.project.dao.ProjectDAO;
import kr.co.nextdoor.project.dto.ProjectDTO;

@Service
public class FullcalendarService {
	
	@Autowired
	private SqlSession sqlsession;
	
	public int fullcalendarProjectInsert(ProjectDTO projectDTO) throws Exception{
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		projectDTO.setMember_id(user.getUsername());
		ProjectDAO projectdao = sqlsession.getMapper(ProjectDAO.class);
		return projectdao.insertFullcalendarProject(projectDTO);
	}

}
