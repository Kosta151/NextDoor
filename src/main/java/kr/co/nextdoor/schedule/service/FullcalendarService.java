package kr.co.nextdoor.schedule.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.schedule.dao.FullcalendarDAO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskDTO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskModiDTO;

@Service
public class FullcalendarService {
	
	@Autowired
	private SqlSession sqlsession;
	
		//업무명 보여주기
	/*	public List<TaskDTO> TaskList(String project_no){
		TaskDAO taskdao = sqlsession.getMapper(TaskDAO.class);
		List<TaskDTO> list = taskdao.listTasks(project_no);
		return list;
		
	}*/
		
	//세부업무 추가
		public int SpecificTaskInsert(SpecificTaskDTO specifictaskdto) throws Exception{
		FullcalendarDAO fullcalendardao = sqlsession.getMapper(FullcalendarDAO.class);
		int result = fullcalendardao.insertFullcalendarSpecificTask(specifictaskdto);
		return result;
		
	}
		
	//세부업무 수정추가
		public int SpecificModiTaskInsert(SpecificTaskModiDTO specificmoditaskdto){
			FullcalendarDAO fullcalendardao = sqlsession.getMapper(FullcalendarDAO.class);
			int result = fullcalendardao.insertFullcalendarSpecificModiTask(specificmoditaskdto);
			return result;
		}
		
		

}
