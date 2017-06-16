package kr.co.nextdoor.member.dto;

/*
* @Class : MemberDTO
* @Date : 2017. 06. 16
* @Author : 이재민
* @Desc : memberdto
*/
public class MemberDTO {
	private String member_id;
	private String password;
	private String name;

	public MemberDTO() {}

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
}