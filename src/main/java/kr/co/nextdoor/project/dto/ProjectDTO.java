package kr.co.nextdoor.project.dto;

/*
* @Class : ProjectDTO
* @Date : 2017. 06. 13
* @Author : 송지은
* @Desc : projectDTO
*/
public class ProjectDTO {
	private String project_no;
	private String project_name;
	private String workspace_no;
	private String member_id;
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

	public String getWorkspace_no() {
		return workspace_no;
	}

	public void setWorkspace_no(String workspace_no) {
		this.workspace_no = workspace_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
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
	
}
