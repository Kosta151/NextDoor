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
/*
* @Class : FullcalendarService
* @Date : 2017. 06. 30
* @Author : 최성용
* @Desc : fullcalendar controller에 대한 service
*/
@Service
@SessionAttributes({"workspace_no", "project_no", "task_no", "specifictask_no"})
public class FullcalendarService {
	
	@Autowired
	private SqlSession sqlsession;

	/*
    * @method Name : SpecificTaskInsert
    * @date : 2017. 06 . 27
    * @author : 최성용
    * @description : 달력에서 업무 추가
    * @param : specifictaskdto
    */
	public void SpecificTaskInsert(SpecificTaskDTO specifictaskdto, HttpSession session) throws Exception{
	
		FullcalendarDAO fullcalendardao = sqlsession.getMapper(FullcalendarDAO.class);
		fullcalendardao.insertFullcalendarSpecificTask(specifictaskdto);
		session.setAttribute("specifictask_no", specifictaskdto.getSpecifictask_no());
		return;
	}
	
/*
    * @method Name : SpecificModiTaskInsert
    * @date : 2017. 06 . 27
    * @author : 최성용
    * @description : 달력에서 세부 업무 추가
    * @param : specifictaskmodidto,task_no,specifictask_cont
    */
	public void SpecificModiTaskInsert(SpecificTaskModiDTO specifictaskmodidto, String task_no, String specifictask_cont){
	
		FullcalendarDAO fullcalendardao = sqlsession.getMapper(FullcalendarDAO.class);
		HashMap<String, String> map = new HashMap();
		map.put("task_no", task_no);
		map.put("member_id", specifictaskmodidto.getMember_id());
		map.put("specifictask_end", specifictaskmodidto.getSpecifictask_end());
		map.put("specifictask_start", specifictaskmodidto.getSpecifictask_start());
		map.put("specifictask_cont", specifictask_cont);
	
		fullcalendardao.insertFullcalendarSpecificModiTask(map);
		return;
	}

}
