package kr.co.nextdoor.member.dto;

public class MemberDTO {
	private String email;
	private String password;
	private String name;
	
	public MemberDTO(){}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		return "MemberDTO [email=" + email + ", password=" + password + ", name=" + name + "]";
	}
	
	
}
