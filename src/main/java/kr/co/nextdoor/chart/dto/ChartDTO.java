package kr.co.nextdoor.chart.dto;

/*
* @Class : ChartDTO
* @Date : 2017. 06. 30
* @Author : 최성용
* @Desc : ChartDTO
*/
public class ChartDTO {

	private String project_no;
	private String task_cont;
	private int comp0;
	private int comp1;
	
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
	public int getComp0() {
		return comp0;
	}
	public void setComp0(int comp0) {
		this.comp0 = comp0;
	}
	public int getComp1() {
		return comp1;
	}
	public void setComp1(int comp1) {
		this.comp1 = comp1;
	}

}
