package kr.co.nextdoor.member.dao;

import kr.co.nextdoor.member.dto.MemberDTO;

/*
* @Class : MemberDAO
* @Date : 2017. 06. 16
* @Author : 이재민
* @Desc : 회원가입에 대한 DAO
*/
public interface MemberDAO {

	/*
	* @method Name : insertMember
	* @date : 2017. 06. 16
	* @author : 이재민
	* @description : 회원가입
	* @return : void
	*/
	public void insertMember(MemberDTO memberdto);
	
	/*
	* @method Name : insertRole
	* @date : 2017. 06. 16
	* @author : 이재민
	* @description : 권한 부여
	* @return : void
	*/
	public void insertRole(String member_id);
	
	/*
	* @method Name : checkId
	* @date : 2017. 06. 16
	* @author : 김선화
	* @description : 아이디 중복체크
	* @return : int
	*/
	public int checkId(String member_id);

}
