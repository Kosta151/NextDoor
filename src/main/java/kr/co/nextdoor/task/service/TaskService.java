package kr.co.nextdoor.task.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.task.dao.TaskDAO;
import kr.co.nextdoor.task.dto.TaskDTO;
import kr.co.nextdoor.workspace.dao.WorkspaceDAO;

@Service
public class TaskService {
	
	@Autowired
	private SqlSession sqlsession;
	
	public List<TaskDTO> TaskList(String project_no){
		
		TaskDAO taskdao = sqlsession.getMapper(TaskDAO.class);
		List<TaskDTO> list  = taskdao.listTasks(project_no);
		return list;	
	}
	
	public int TaskInsert(TaskDTO taskdto){
		
		TaskDAO taskdao = sqlsession.getMapper(TaskDAO.class);
		int result = taskdao.insertTask(taskdto);
		
		return result;
		
	}

}
