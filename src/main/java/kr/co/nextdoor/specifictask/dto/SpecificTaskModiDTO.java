package kr.co.nextdoor.specifictask.dto;

/*
* @Class : SpecificTaskModiDTO
* @Date : 2017. 06. 16
* @Author : 문창균
* @Desc : SpecificTaskModiDTO 세부업무 수정값
*/
public class SpecificTaskModiDTO {
	
	private String specifictaskmodi_no;
	private String specifictask_no;
	private String member_id;
	private String specifictask_start;
	private String specifictask_end;
	private String specifictask_comp;
	
	public String getSpecifictaskmodi_no() {
		return specifictaskmodi_no;
	}
	public void setSpecifictaskmodi_no(String specifictaskmodi_no) {
		this.specifictaskmodi_no = specifictaskmodi_no;
	}
	public String getSpecifictask_no() {
		return specifictask_no;
	}
	public void setSpecifictask_no(String specifictask_no) {
		this.specifictask_no = specifictask_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getSpecifictask_start() {
		return specifictask_start;
	}
	public void setSpecifictask_start(String specifictask_start) {
		this.specifictask_start = specifictask_start;
	}
	public String getSpecifictask_end() {
		return specifictask_end;
	}
	public void setSpecifictask_end(String specifictask_end) {
		this.specifictask_end = specifictask_end;
	}
	public String getSpecifictask_comp() {
		return specifictask_comp;
	}
	public void setSpecifictask_comp(String specifictask_comp) {
		this.specifictask_comp = specifictask_comp;
	}
}
