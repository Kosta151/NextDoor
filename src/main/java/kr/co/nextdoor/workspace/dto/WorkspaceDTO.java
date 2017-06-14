package kr.co.nextdoor.workspace.dto;

public class WorkspaceDTO {
	private String workspace_no;
	private String workspace_name;
	private String member_id;

	public WorkspaceDTO() {
	}

	public String getWorkspace_no() {
		return workspace_no;
	}

	public void setWorkspace_no(String workspace_no) {
		this.workspace_no = workspace_no;
	}

	public String getWorkspace_name() {
		return workspace_name;
	}

	public void setWorkspace_name(String workspace_name) {
		this.workspace_name = workspace_name;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
}
