package kr.co.nextdoor.chat.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.PerConnectionWebSocketHandler;

@Configuration
@EnableWebMvc
@EnableWebSocket
@ComponentScan(basePackages = { "kr.co.nextdoor.chat" })
public class ChatConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
	
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		registry.addHandler(chatWebSocketHandler(), "/chat-ws").addInterceptors(new ChatHandlerInterceptor())
				.withSockJS();
	}

	@Bean
	public WebSocketHandler chatWebSocketHandler() {
		return new PerConnectionWebSocketHandler(ChatHandler.class);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}