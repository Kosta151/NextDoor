package kr.co.nextdoor.schedule.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.nextdoor.schedule.dao.FullcalendarDAO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskDTO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskModiDTO;

@Service
@SessionAttributes({"workspace_no", "project_no", "task_no", "specifictask_no"})
public class FullcalendarService {
	
	@Autowired
	private SqlSession sqlsession;

	//세부업무 추가
	public void SpecificTaskInsert(SpecificTaskDTO specificetaskdto, HttpSession session) throws Exception{
	FullcalendarDAO fullcalendardao = sqlsession.getMapper(FullcalendarDAO.class);
	fullcalendardao.insertFullcalendarSpecificTask(specificetaskdto);
	session.setAttribute("specifictask_no", specificetaskdto.getSpecifictask_no());
	return;
	}
   //세부업무 수정추가
	public void SpecificModiTaskInsert(SpecificTaskModiDTO specifictaskmodidto, String task_no, String specifictask_cont){
	FullcalendarDAO fullcalendardao = sqlsession.getMapper(FullcalendarDAO.class);
	HashMap<String, String> map = new HashMap<>();
	map.put("task_no", task_no);
	map.put("member_id", specifictaskmodidto.getMember_id());
	map.put("specifictask_end", specifictaskmodidto.getSpecifictask_end());
	map.put("specifictask_start", specifictaskmodidto.getSpecifictask_start());
	map.put("specifictask_cont", specifictask_cont);
	
	fullcalendardao.insertFullcalendarSpecificModiTask(map);
	return;
	}

}
