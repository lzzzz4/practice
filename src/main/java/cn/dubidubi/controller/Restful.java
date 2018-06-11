package cn.dubidubi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author lzj
 * @Description:
 * @date 18-6-11下午3:28
 */
@Controller
@RequestMapping("friend")
public class Restful {

    @ModelAttribute("prepare")
    public String prepare() {
        return "hello";
    }

    @RequestMapping("/v1/{sb}")
    @ResponseBody
    public String show(@PathVariable String sb, @ModelAttribute("prepare") String s2) {
        System.out.println("sb" + sb);
        System.out.println("prepare2" + s2);
        return "hello";
    }
}
