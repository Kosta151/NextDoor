package kr.co.nextdoor.alarm.dto;

import java.sql.Date;
/*
* @Class : AlarmDTO
* @Date : 2017. 06. 13 
* @Author : 박찬섭
* @Desc : Alarm
*/
public class AlarmDTO {
		
		private String specifictask_no;
		private String alarm_sender;
		private String alarm_receiver;
		private String alarm_cont;
		private String alarm_date;
		private String alarm_read;
		
		public String getSpecifictask_no() {
			return specifictask_no;
		}
		public void setSpecifictask_no(String specifictask_no) {
			this.specifictask_no = specifictask_no;
		}
		public String getAlarm_sender() {
			return alarm_sender;
		}
		public void setAlarm_sender(String alarm_sender) {
			this.alarm_sender = alarm_sender;
		}
		public String getAlarm_receiver() {
			return alarm_receiver;
		}
		public void setAlarm_receiver(String alarm_receiver) {
			this.alarm_receiver = alarm_receiver;
		}
		public String getAlarm_cont() {
			return alarm_cont;
		}
		public void setAlarm_cont(String alarm_cont) {
			this.alarm_cont = alarm_cont;
		}
		public String getAlarm_date() {
			return alarm_date;
		}
		public void setAlarm_date(String alarm_date) {
			this.alarm_date = alarm_date;
		}
		public String getAlarm_read() {
			return alarm_read;
		}
		public void setAlarm_read(String alarm_read) {
			this.alarm_read = alarm_read;
		}
		@Override
		public String toString() {
			return "AlarmDTO [specifictask_no=" + specifictask_no + ", alarm_sender=" + alarm_sender
					+ ", alarm_receiver=" + alarm_receiver + ", alarm_cont=" + alarm_cont + ", alarm_date=" + alarm_date
					+ ", alarm_read=" + alarm_read + "]";
		}
		
		
	
		
	}
