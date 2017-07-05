package kr.co.nextdoor.alarm.service;

/*
* @Class : AlarmService
* @Date : 2017. 06. 24
* @Author : 박찬섭
* @Desc : alarm service
*/

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.alarm.dao.AlarmDAO;
import kr.co.nextdoor.alarm.dto.AlarmDTO;


@Service
public class AlarmService {
	
	@Autowired
	private SqlSession sqlsession;
	
	/*
	    * @method Name : AlarmList
	    * @date : 2017. 06. 24
	    * @author : 박찬섭
	    * @description : 알림 리스트
	    * @param : userid
	    * @return : List
	    */
	public List<AlarmDTO> AlarmList(String userid){
		
		AlarmDAO alarmdao = sqlsession.getMapper(AlarmDAO.class);
		List<AlarmDTO> list  = alarmdao.AlarmList(userid);
		return list;
	}
	
	/*
	    * @method Name : AlarmInsert
	    * @date : 2017. 06. 24
	    * @author : 박찬섭
	    * @description : 알림 생성
	    * @param : alarmdto
	    * @return : int
	    */
	public int insertAlarm(AlarmDTO alarmdto){
		AlarmDAO alarmdao = sqlsession.getMapper(AlarmDAO.class);
		int result = alarmdao.insertAlarm(alarmdto);
		return result;
	}
	
	/*
	    * @method Name : updateAlarm
	    * @date : 2017. 06. 24
	    * @author : 박찬섭
	    * @description : 알림 1개 읽음 표시
	    * @param : alarm_no
	    * @return : int
	    */
	public int updateAlarm(int alarm_no){
		AlarmDAO alarmdao = sqlsession.getMapper(AlarmDAO.class);
		int result = alarmdao.updateAlarm(alarm_no); 
		return result;
	}
	
	/*
	    * @method Name : updateAlarm
	    * @date : 2017. 06. 24
	    * @author : 박찬섭
	    * @description : 알림 모두 읽음 표시
	    * @param : userid
	    * @return : int
	    */
	public int updateAlarm(String userid){
		AlarmDAO alarmdao = sqlsession.getMapper(AlarmDAO.class);
		int result = alarmdao.updateAlarm(userid); 
		return result;
	}
	
	/*
	    * @method Name : CountAlarmList
	    * @date : 2017. 06. 24
	    * @author : 박찬섭
	    * @description : 알림 갯수 표시
	    * @param : userid
	    * @return : int
	    */
	public int CountAlarmList(String user_id){
		AlarmDAO alarmdao = sqlsession.getMapper(AlarmDAO.class);
		int result = alarmdao.CountAlarmList(user_id); 
		return result;
	}
}
