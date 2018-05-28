package cn.dubidubi.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.dubidubi.model.MyMessage;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.xml.soap.Text;

/**
 * @author 16224
 * @ClassName: ChatMessageHandler
 * @Description: 执行执行websocket各种操作的类
 * @date 2018年4月23日
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
        //给推送的回送消息
        MyMessage MyMessage =new MyMessage();
        MyMessage.setName("lzj");
        MyMessage.setUsername("lzjjjj");
        TextMessage TextMessage =new TextMessage(JSON.toJSONString(MyMessage));
        session.sendMessage(TextMessage);
        super.handleTextMessage(session, message);
    }

    // 在连接关闭后执行的代码
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("关闭了连接");
        String username = (String) session.getAttributes().get("PcUser");
        // 删除了websocket
        map.remove(username);
        super.afterConnectionClosed(session, status);
    }

    // 出现异常时的操作
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // 出现异常后关闭连接,清除map
        if (session.isOpen()) {
            session.close();
            map.remove(session.getAttributes().get("PcUser"));
        }
        super.handleTransportError(session, exception);
    }

}
