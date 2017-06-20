package kr.co.nextdoor.alarm.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.nextdoor.alarm.dao.AlarmDAO;
import kr.co.nextdoor.alarm.dto.AlarmDTO;
import kr.co.nextdoor.task.dao.TaskDAO;
import kr.co.nextdoor.task.dto.TaskDTO;

public class AlarmService {
	
	@Autowired
	private SqlSession sqlsession;
	
	
	public List<AlarmDTO> AlarmList(String userid){
		
		AlarmDAO Alarmdao = sqlsession.getMapper(AlarmDAO.class);
		List<AlarmDTO> list  = Alarmdao.AlarmList(userid);
		return list;
	}
}
