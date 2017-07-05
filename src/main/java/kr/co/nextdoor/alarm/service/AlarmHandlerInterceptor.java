package kr.co.nextdoor.alarm.service;

import java.util.Map;



import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/*
* @Class : AlarmHandlerInterceptor
* @Date : 2017. 06. 20 
* @Author : 박찬섭
* @Desc : Alarm
*/


@Configuration
@EnableWebSocket
public class AlarmHandlerInterceptor extends HttpSessionHandshakeInterceptor {

	/*
	    * @method Name : beforeHandshake
	    * @date : 2017. 06. 20
	    * @author : 박찬섭
	    * @description : Alarmhandler 가지전에  user_id값 저장하여 넘기는 함수
	    */
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		attributes.put("user_id", user.getUsername());
		return super.beforeHandshake(request, response, wsHandler, attributes);
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {

		super.afterHandshake(request, response, wsHandler, ex);
	}

}
