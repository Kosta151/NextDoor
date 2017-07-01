package kr.co.nextdoor.chat.controller;
/*
* @Class : ChatController
* @Date : 2017. 06. 20 
* @Author : 박찬섭
* @Desc : ChatController
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController {
	
	/*
	 * @method Name : chat
	 * @date : 2017. 06. 20
	 * @author : 박찬섭
	 * @description : 채팅창 이동
	 */
	@RequestMapping(value="chat.htm", method=RequestMethod.GET)
	public String chat() {

		return "main.chat";
	}
}
