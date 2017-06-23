package kr.co.nextdoor.mail.dto;

import java.util.Date;

public class MailDto {
	private String member_id;
	private String name;
	private String project_no;
	private String subject;
	private String template;
	private Date taskdate;
	private String content;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProject_no() {
		return project_no;
	}
	public void setProject_no(String project_no) {
		this.project_no = project_no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public Date getTaskdate() {
		return taskdate;
	}
	public void setTaskdate(Date taskdate) {
		this.taskdate = taskdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "MailDto [member_id=" + member_id + ", name=" + name + ", project_no=" + project_no + ", subject="
				+ subject + ", template=" + template + ", taskdate=" + taskdate + ", content=" + content + "]";
	}
	
	
	
	
}
