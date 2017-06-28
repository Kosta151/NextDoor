package kr.co.nextdoor.alarm.dao;
/*
* @Class : AlarmDAO
* @Date : 2017. 06. 13
* @Author : 박찬섭
* @Desc : AlarmDAO
*/
import java.util.List;

import kr.co.nextdoor.alarm.dto.AlarmDTO;

/*
* @Class : AlarmDAO
* @Date : 2017. 06. 13
* @Author : 박찬섭
* @Desc : AlarmDAO
*/
public interface AlarmDAO {
	
	/*
	    * @method Name : insertAlarm
	    * @date : 2017. 06. 13
	    * @author : 박찬섭
	    * @description : 알람 추가
	    * @return : int
	    */
	public int insertAlarm(AlarmDTO alarmdto);
	
	/*
	    * @method Name : updateAlarm
	    * @date : 2017. 06. 13
	    * @author : 박찬섭
	    * @description : 알람 1개 읽음 표시
	    * @return : int
	    */
	public int updateAlarm(String userid);
	
	/*
	    * @method Name : updateAlarm
	    * @date : 2017. 06. 13
	    * @author : 박찬섭
	    * @description : 알람 모두 읽음 표시
	    * @return : int
	    */
	public int updateAlarm(int alarm_no);
	
	/*
	    * @method Name : AlarmList
	    * @date : 2017. 06. 13
	    * @author : 박찬섭
	    * @description : 유저에 해당되는 알람 리스트 
	    * @return : List
	    */
	public List<AlarmDTO> AlarmList(String userid);
	
	/*
	    * @method Name : AlarmList
	    * @date : 2017. 06. 13
	    * @author : 박찬섭
	    * @description : 유저에 해당되는 알람 갯수(읽지 않음) 
	    * @return : int
	    */
	public int CountAlarmList(String user_id);
}
