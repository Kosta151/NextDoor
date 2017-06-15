package kr.co.nextdoor.chat.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class ChatHandlerInterceptor extends HttpSessionHandshakeInterceptor {

	// 소켓이 연결되기전 interceptor, 소켓이 연결 될 때 웹소켓 세션에 있는 값을 attributes로 넣어줌
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {

		System.out.println("Before handshake");
		System.out.println("URI:" + request.getURI());
		ServletServerHttpRequest sshr = (ServletServerHttpRequest) request;
		HttpServletRequest req = sshr.getServletRequest(); // 스프링스큐리티에서는 안씀
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // 스프링시큐리티에서
																									// 아이디값
																									// 받아옴
		attributes.put("user_id", user.getUsername());
		return super.beforeHandshake(request, response, wsHandler, attributes);
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {

		super.afterHandshake(request, response, wsHandler, ex);
	}

}
