package kr.co.nextdoor.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* @Class : IndexController
* @Date : 2017. 06. 16
* @Author : 이재민
* @Desc : 처음 인덱스 화면으로 이동
*/
@Controller

public class IndexController {

	@RequestMapping("index.htm")
	public String index() {

		return "index.index";
	}
	
	@RequestMapping("lockscreen.htm")
	public String lockscreen() {
		
		return "login.lockscreen";
	}
}
