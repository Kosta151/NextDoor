package kr.co.nextdoor.member.dto;

public class MemberDTO {
	private String member_id;
	private String password;
	private String name;
	
	public MemberDTO(){}
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MemberDTO [member_id=" + member_id + ", password=" + password + ", name=" + name + "]";
	}
	
	
}