package cn.dubidubi.controller.websocket;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.dubidubi.model.User;
import cn.dubidubi.service.quartz.Job;
import cn.dubidubi.service.quartz.Quartz;

@Controller
@RequestMapping("/test")
/**
 * 
* @ClassName: IndexController  
* @Description: websocket首页
* @author 16224  
* @date 2018年4月25日  
*
 */
public class IndexController {
	@Autowired
	Quartz quartz;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/doTest")
	public String test(HttpServletRequest request) {
		String random = RandomStringUtils.randomAlphanumeric(7);
		User user = new User();
		user.setUsername(random);
		user.setDateTime(LocalDateTime.now());
		request.getSession().setAttribute("PcUser", random);
		logger.info("生成了session->pcUser:{}", user);
		return "redirect:/index.html";
	}
}
