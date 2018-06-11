package cn.dubidubi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lzj
 * @Description:
 * @date 18-6-11下午3:48
 */
@Controller
@RequestMapping("/no/v1")
public class Restful2 {
    @RequestMapping("/show")
    public void show() {
        System.out.println("show2");
    }
}
