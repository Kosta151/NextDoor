package kr.co.nextdoor.alarm.dao;

import java.util.List;

import kr.co.nextdoor.alarm.dto.AlarmDTO;

public interface AlarmDAO {
	
	//?���? 추�? ?��?��
	public int insertAlarm(AlarmDTO alarmdto);
	
	//?���? ?��?�� 1�?
	public int updateAlarm(String userid);
	
	//?���? ?���? ?��?��
	public int updateAlarm(AlarmDTO alarmdto);
	
	//?���? 리스?��
	public List<AlarmDTO> AlarmList(String userid);
	
	//?���? �??�� ?��?��
	public int CountAlarmList(String userid);
}
