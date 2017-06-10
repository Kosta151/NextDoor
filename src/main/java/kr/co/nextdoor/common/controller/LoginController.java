package kr.co.nextdoor.common.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.nextdoor.member.dao.MemberDao;
import kr.co.nextdoor.member.dto.MemberDTO;

@Controller
public class LoginController {

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public String login() {

		return "login.login";
	}

	@RequestMapping(value = "join.htm", method = RequestMethod.GET)
	public String join() {

		return "login.join";
	}

	@RequestMapping(value = "join.htm", method = RequestMethod.POST)
	public String join(MemberDTO memberdto) {
		MemberDao memberdao = sqlSession.getMapper(MemberDao.class);
		memberdto.setPassword(this.bCryptPasswordEncoder.encode(memberdto.getPassword()));

		int result = memberdao.insertMember(memberdto);
		if (result > 0) {
			memberdao.insertRole(memberdto.getMember_id());
		} else {
			return "login.join";
		}

		return "login.login";
	}

	@RequestMapping(value = "workspace.htm", method = RequestMethod.GET)
	public String workspace() {
		
		return "login.workspace";
	}

	@RequestMapping(value = "main.htm", method = RequestMethod.GET)
	public String main() {

		return "main.main";
	}
}