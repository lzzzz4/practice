package cn.dubidubi.controller;

import cn.dubidubi.model.biliCos;
import cn.dubidubi.service.TransService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: 16224
 * @Date: 2018/5/22 0022 09:33
 * @Description: jsonp的controller
 */
@Controller
@RequestMapping("/jsonp")
public class JsonpController {
    @Autowired
    TransService TransService;

    @RequestMapping("/todo")
    public void todo(String callback, HttpServletResponse response) throws IOException {
        biliCos biliCos = new biliCos();
        biliCos.setName("lzj");
        response.getWriter().write(callback + "(" + JSON.toJSONString(biliCos) + ")");
    }

    @RequestMapping("/title")
    public void ddooo(String title) {
        TransService.all(title);
    }
}
