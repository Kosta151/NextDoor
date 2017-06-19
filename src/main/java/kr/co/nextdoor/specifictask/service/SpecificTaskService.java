package kr.co.nextdoor.specifictask.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import kr.co.nextdoor.specifictask.dao.SpecificTaskDAO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskDTO;

@Service
public class SpecificTaskService {
	
	@Autowired
	SqlSession sqlsession;
	
	
	
	public List<SpecificTaskDTO> listSpecificTask(String task_no){
		SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
		List<SpecificTaskDTO> specifictasklist = specifictaskdao.listSpecifictask(task_no);	
		return specifictasklist;
	}
}
