package kr.co.nextdoor.alarm.dto;

import java.sql.Date;

public class AlarmDTO {
	
		private int alarm_no;
		private int specifictask_no;
		private String alarm_sender;
		private String alarm_receiver;
		private String alarm_cont;
		private String alarm_date;
		private boolean alarm_read;
		
		public int getAlarm_no() {
			return alarm_no;
		}
		public void setAlarm_no(int alarm_no) {
			this.alarm_no = alarm_no;
		}
		public int getSpecifictask_no() {
			return specifictask_no;
		}
		public void setSpecifictask_no(int specifictask_no) {
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
		public boolean isAlarm_read() {
			return alarm_read;
		}
		public void setAlarm_read(boolean alarm_read) {
			this.alarm_read = alarm_read;
		}
		
	}
