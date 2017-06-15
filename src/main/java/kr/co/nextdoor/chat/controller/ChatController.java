package kr.co.nextdoor.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 인덱스컨트롤러 : 인덱스 화면
 */
@Controller
public class ChatController {
	
	@RequestMapping(value="chat.htm", method=RequestMethod.GET)
	public String home() {
		return "main.chat";
	}
}
