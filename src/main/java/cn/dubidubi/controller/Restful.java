package cn.dubidubi.controller;

import cn.dubidubi.model.User;
import org.apache.commons.lang3.CharSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import cn.dubidubi.dao.chanMapper;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @author lzj
 * @Description:
 * @date 18-6-11下午3:28
 */
@Controller
@RequestMapping("friend")
public class Restful {
    @Autowired
    chanMapper chanMapper;

    @ModelAttribute("prepare")
    public String prepare() {
        return "你好";
    }

    @RequestMapping(value = "/show", method = RequestMethod.PUT)
    @CrossOrigin(value = "*", methods = {RequestMethod.PUT})
    public void cors(String message) {
        System.out.println(message);
    }


    @RequestMapping("/v1/{sb}")
    @ResponseBody
    //我是一串utf8的字符串
    public String show(@PathVariable String sb, String demo, @ModelAttribute("prepare") String s2) throws UnsupportedEncodingException {
        System.out.println("sb" + sb);
        System.out.println("prepare2" + s2);
        String str = "林子捷";
        User User = new User();
        System.out.println("数据库:" + chanMapper.getTitle(2));
        System.out.println(new String(str.getBytes("utf-8"), "utf-8"));
        User.setUsername(new String(str.getBytes("utf-8"), "utf-8"));
        System.out.println("demo" + demo);
        User.setDemo(demo);
        return str;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "字符集";
        //System.out.println(new String(str.getBytes("gbk"), "utf-8"));
        System.out.println(new String(str.getBytes("utf-8"), "utf-8"));
        System.out.println(str);
        System.out.println(Charset.defaultCharset());
    }
}
