package cn.dubidubi.controller;

import cn.dubidubi.model.User;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @Auther: 16224
 * @Date: 2018/5/18 0018 12:32
 * @Description: 前后端分离时的jessionid问题
 */
@RequestMapping("/tomcat")
@Controller
public class HighController {
    @RequestMapping("/get")
    @ResponseBody
    public User get(HttpServletRequest request, HttpSession Session, HttpServletResponse response) {
        System.out.println("no session");
        Session.setAttribute("lzj", "lzj1111111111111111111");
        User User = new User();
        User.setUsername("设置session");
        User.setDateTime(LocalDateTime.now());
        return User;
    }

    @RequestMapping("/todo")
    @ResponseBody
    public User todo(HttpServletRequest request, HttpSession Session, HttpServletResponse response) {
        //Cookie[] Cookie = request.getCookies();
        // for (int i = 0; i < Cookie.length; i++) {
        Cookie cookie = new Cookie("aaa", "bbb");
        //cookie.setValue("lzj");
        //cookie.setDomain("www.baidu.com");
        cookie.setPath("/");
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
        //}
        System.out.println("no session");
        String hello = (String) Session.getAttribute("lzj");
        User User = new User();
        User.setUsername(hello + "得到session中的信息");
        User.setDateTime(LocalDateTime.now());
        return User;
    }

}
