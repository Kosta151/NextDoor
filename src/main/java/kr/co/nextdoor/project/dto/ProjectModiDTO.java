package kr.co.nextdoor.project.dto;

import java.util.Date;
/*
* @Class : ProjectModiDTO
* @Date : 2017. 06. 14
* @Author : 송지은
* @Desc : projectModiDTO
*/
public class ProjectModiDTO {
	private String projectmodi_no;
	private String project_no;
	private Date project_start;
	private Date project_end;
	
	public String getProjectmodi_no() {
		return projectmodi_no;
	}
	public void setProjectmodi_no(String projectmodi_no) {
		this.projectmodi_no = projectmodi_no;
	}
	public String getProject_no() {
		return project_no;
	}
	public void setProject_no(String project_no) {
		this.project_no = project_no;
	}
	public Date getProject_start() {
		return project_start;
	}
	public void setProject_start(Date project_start) {
		this.project_start = project_start;
	}
	public Date getProject_end() {
		return project_end;
	}
	public void setProject_end(Date project_end) {
		this.project_end = project_end;
	}
}