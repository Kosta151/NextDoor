package kr.co.nextdoor.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 인덱스로 이동
 */
@Controller

public class IndexController {

	@RequestMapping("index.htm")
	public String index() {
		
		return "index.index";
	}
}
