package kr.co.nextdoor.member.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.member.dao.MemberDAO;
import kr.co.nextdoor.member.dto.MemberDTO;

/*
* @Class : MemberService
* @Date : 2017. 06. 16
* @Author : 이재민
* @Desc : MemberContoller에 대한 service
*/

@Service
public class MemberService {
	
	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/*
	* @method Name : insertMember
	* @date : 2017. 06. 16
	* @author : 이재민
	* @description : 회원가입시 회원가입과 권한부여
	* @param : memberdto
	* @return : void
	*/	
	public void insertMember(MemberDTO memberdto) {
		MemberDAO memberdao = sqlSession.getMapper(MemberDAO.class);
		memberdto.setPassword(this.bCryptPasswordEncoder.encode(memberdto.getPassword()));
		memberdao.insertMember(memberdto);
		memberdao.insertRole(memberdto.getMember_id());
		return;
	}
	
	/*
	* @method Name : checkId
	* @date : 2017. 06. 18
	* @author : 김선화
	* @description : id중복체크
	* @param : String
	* @return : String
	*/
	public String checkId(String member_id) throws Exception {
		String result;
		MemberDAO memberdao = sqlSession.getMapper(MemberDAO.class);
		if (memberdao.checkId(member_id) > 0) {
			result = "false";
			System.out.println(result);
		} else {
			result = "true";
			System.out.println(result);
		}
		return result;
	}
}