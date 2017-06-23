package kr.co.nextdoor.task.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.member.dto.MemberDTO;
import kr.co.nextdoor.task.dao.TaskDAO;
import kr.co.nextdoor.task.dto.TaskDTO;
import kr.co.nextdoor.workspace.dao.WorkspaceDAO;
/*
* @Class : TaskService
* @Date : 2017. 06. 13
* @Author : 장진환
* @Desc : task controller에 대한 service
*/

@Service
public class TaskService {
	
	@Autowired
	private SqlSession sqlsession;
	
	/*
    * @method Name : listTask
    * @date : 2017. 06. 16
    * @author : 장진환
    * @description : 업무 리스트 출력
    * @param : project_no
    * @return : List<TaskDTO>
    */
	public List<TaskDTO> listTasks(String project_no){
		
		TaskDAO taskdao = sqlsession.getMapper(TaskDAO.class);
		List<TaskDTO> list  = taskdao.listTasks(project_no);
		return list;	
	}
	
	/*
    * @method Name : insertTask
    * @date : 2017. 06. 16
    * @author : 장진환
    * @description : 업무 생성
    * @param : taskdto
    * @return : int
    */
	public int insertTask(TaskDTO taskdto){
		
		TaskDAO taskdao = sqlsession.getMapper(TaskDAO.class);
		int result = taskdao.insertTask(taskdto);
		
		return result;
		
	}
	
	/*
    * @method Name : listMember
    * @date : 2017. 06. 16
    * @author : 장진환
    * @description : 프로젝트멤버 출력
    * @param : project_no
    * @return : List<MemberDTO>
    */
	public List<MemberDTO> listMember(String project_no){
		TaskDAO taskdao = sqlsession.getMapper(TaskDAO.class);
		List<MemberDTO> mlist  =taskdao.memberList(project_no);
		System.out.println(mlist);
		return mlist;	
	}

	/*
    * @method Name : deleteTask
    * @date : 2017. 06. 16
    * @author : 장진환
    * @description : 업무삭제
    * @param : taskdto
    * @return : int
    */
	public int deleteTask(TaskDTO taskdto){
		TaskDAO taskdao = sqlsession.getMapper(TaskDAO.class);
		int resutl = taskdao.deleteTask(taskdto);
		return resutl;
	}
}
