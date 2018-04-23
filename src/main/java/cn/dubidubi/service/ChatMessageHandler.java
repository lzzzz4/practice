package cn.dubidubi.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * 
* @ClassName: ChatMessageHandler  
* @Description: 执行执行websocket各种操作的类
* @author 16224  
* @date 2018年4月23日  
*
 */
@Component
public class ChatMessageHandler extends TextWebSocketHandler {
	static Map<String, WebSocketSession> map = new ConcurrentHashMap<>();

	/**
	 * 建立连接后执行的方法
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String username = (String) session.getAttributes().get("PcUser");
		System.out.println("建立连接" + session.getAttributes().get("PcUser"));
		// 往map中增加已经建立的连接
		map.put(username, session);
		super.afterConnectionEstablished(session);
	}

	// 后台接受message
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("前端推送了消息" + message);
		super.handleTextMessage(session, message);
	}

	// 连接关闭
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("关闭了连接");
		super.afterConnectionClosed(session, status);
	}
	  
	// 出现异常时的操作
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		super.handleTransportError(session, exception);
	}

}