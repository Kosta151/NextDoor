package kr.co.nextdoor.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.nextdoor.member.dto.MemberDTO;
import kr.co.nextdoor.member.service.MemberService;

/*
* @Class : MemberController
* @Date : 2017. 06. 16
* @Author : 이재민
* @Desc : login 및 join
*/
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberservice;

	/*
	* @method Name : login
	* @date : 2017. 06. 16
	* @author : 이재민
	* @description : login view 페이지로 이동
	*/
	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public String login() {

		return "login.login";
	}

	/*
	* @method Name : join
	* @date : 2017. 06. 16
	* @author : 이재민
	* @description : join view 페이지로 이동
	*/
	@RequestMapping(value = "join.htm", method = RequestMethod.GET)
	public String join() {

		return "login.join";
	}

	/*
	* @method Name : join
	* @date : 2017. 06. 16
	* @author : 이재민
	* @description : jQueryValidation으로 id, password 유효성 체크 후 password 암호화하여 회원가입
	* @param : memberdto
	* @return : String
	*/
	@RequestMapping(value = "join.htm", method = RequestMethod.POST)
	public String join(MemberDTO memberdto) {
		memberservice.insertMember(memberdto);
		return "login.login";
	}
	
	/*
	* @method Name : checkId
	* @date : 2017. 06. 18
	* @author : 김선화
	* @description : 아이디 중복체크
	* @param : String
	* @return : @ResponseBody
	*/
	@RequestMapping(value="checkId.htm", method = RequestMethod.POST)
	public @ResponseBody String checkId(String member_id) throws Exception {
		
		return memberservice.checkId(member_id);
	}
	
	
}