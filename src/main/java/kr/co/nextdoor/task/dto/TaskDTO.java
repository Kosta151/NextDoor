package kr.co.nextdoor.task.dto;

public class TaskDTO {
	
	private int task_no;
	private int project_no;
	private String task_cont;
	
	public int getTask_no() {
		return task_no;
	}
	public void setTask_no(int task_no) {
		this.task_no = task_no;
	}
	public int getProject_no() {
		return project_no;
	}
	public void setProject_no(int project_no) {
		this.project_no = project_no;
	}
	public String getTask_cont() {
		return task_cont;
	}
	public void setTask_cont(String task_cont) {
		this.task_cont = task_cont;
	}

}
