package cn.dubidubi.controller.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import cn.dubidubi.service.ChatHandshakeInterceptor;
import cn.dubidubi.service.ChatMessageHandler;

@Component
// @EnableWebMvc
@EnableWebSocket
/**
* @ClassName: WebSocketConfig  
* @Description: springmvc整合websocket的配置类,在其中配置支持websocket浏览器与不支持的url
* @author 16224  
* @date 2018年4月23日  
 */
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
	@Autowired
	ChatMessageHandler chatMessageHandler;
	@Autowired
	ChatHandshakeInterceptor chatHandshakeInterceptor;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// 支持websocket
		registry.addHandler(chatMessageHandler, "/ws.do").addInterceptors(chatHandshakeInterceptor);
		// 不支持websocket
		registry.addHandler(chatMessageHandler, "/sockjs/webSocketServer").addInterceptors(chatHandshakeInterceptor)
				.withSockJS();
	}

}
