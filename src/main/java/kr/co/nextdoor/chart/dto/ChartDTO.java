package kr.co.nextdoor.chart.dto;

public class ChartDTO {

	private String project_no;
	private String task_cont;
	
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
	@Override
	public String toString() {
		return "ChartDTO [project_no=" + project_no + ", task_cont=" + task_cont + "]";
	}
	
	
	
	
	
	
	
}
