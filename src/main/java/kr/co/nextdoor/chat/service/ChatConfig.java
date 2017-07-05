package kr.co.nextdoor.chat.service;

/*
* @Class : ChatConfig
* @Date : 2017. 06. 20 
* @Author : 박찬섭
* @Desc : Chat
*/
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
	
	/*
	    * @method Name : registerWebSocketHandlers
	    * @date : 2017. 06. 20
	    * @author : 박찬섭
	    * @description : 뷰단 엔드 포인트 매칭해 핸들러와 인터 셉터를 연결  
	    */
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