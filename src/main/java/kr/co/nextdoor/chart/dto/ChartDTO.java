package kr.co.nextdoor.chart.dto;

public class ChartDTO {
	private String project_no;
	private String project_name;
	private String percent;
	private String owner;
	
	public String getProject_no() {
		return project_no;
	}
	public void setProject_no(String project_no) {
		this.project_no = project_no;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "ChartDTO [project_no=" + project_no + ", project_name=" + project_name + ", percent=" + percent
				+ ", owner=" + owner + "]";
	}
	
	
	
	
	
	
}
