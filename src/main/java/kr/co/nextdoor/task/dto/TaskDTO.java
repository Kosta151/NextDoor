package kr.co.nextdoor.task.dto;

/*
* @Class : TaskDTO
* @Date : 2017. 06. 16
* @Author : 장진환
* @Desc : fileDTO
*/
public class TaskDTO {
	
	private String task_no;
	private String project_no;
	private String task_cont;
	private String idx;
	private String specifictask_cont;
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getTask_no() {
		return task_no;
	}
	public void setTask_no(String task_no) {
		this.task_no = task_no;
	}
	public String getProject_no() {
		return project_no;
	}
	public void setProject_no(String project_no) {
		this.project_no = project_no;
	}
	public String getTask_cont() {
		return task_cont;
	}
	public void setTask_cont(String task_cont) {
		this.task_cont = task_cont;
	}
	public String getSpecifictask_cont() {
		return specifictask_cont;
	}
	public void setSpecifictask_cont(String specifictask_cont) {
		this.specifictask_cont = specifictask_cont;
	}
	
	
}
