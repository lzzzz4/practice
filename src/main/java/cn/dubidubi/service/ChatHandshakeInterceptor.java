package cn.dubidubi.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * @author 16224
 * @ClassName: ChatHandshakeInterceptor
 * @Description: websocket的拦截器
 * @date 2018年4月23日
 */
@Component
public class ChatHandshakeInterceptor extends HttpSessionHandshakeInterceptor {
    /**
     * 建立连接前执行的代码,用http的session来标识websocket的一个连接用户
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) throws Exception {
        // 从session中拿取当前的用户信息
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                String username = (String) session.getAttribute("PcUser");
                if (username == null) {
                    username = "default";
                }
                // 放入websocket中
                attributes.put("PcUser", username);
            }
        }
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }
}
