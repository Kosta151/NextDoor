package kr.co.nextdoor.member.dao;

import kr.co.nextdoor.member.dto.MemberDTO;

public interface MemberDao {
	/*회원가입*/
	public int insertMember(MemberDTO memberdto);
	
	/*권한등록*/
	public void insertRole(String email);
}
