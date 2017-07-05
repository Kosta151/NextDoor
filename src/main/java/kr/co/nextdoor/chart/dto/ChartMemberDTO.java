package kr.co.nextdoor.chart.dto;

/*
* @Class : ChartMemberDTO
* @Date : 2017. 07 . 01
* @Author : 문창균
* @Desc : ChartMemberDTO
*/
public class ChartMemberDTO {
	private String task_no;
	private String member_id;
	private int taskcount;
	private int taskcompcount;
	
	public String getTask_no() {
		return task_no;
	}
	public void setTask_no(String task_no) {
		this.task_no = task_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getTaskcount() {
		return taskcount;
	}
	public void setTaskcount(int taskcount) {
		this.taskcount = taskcount;
	}
	public int getTaskcompcount() {
		return taskcompcount;
	}
	public void setTaskcompcount(int taskcompcount) {
		this.taskcompcount = taskcompcount;
	}
	@Override
	public String toString() {
		return "ChartMemberDTO [task_no=" + task_no + ", member_id=" + member_id + ", taskcount=" + taskcount
				+ ", taskcompcount=" + taskcompcount + "]";
	}
	
	
	
}
