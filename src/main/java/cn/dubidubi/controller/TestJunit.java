package cn.dubidubi.controller;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.dubidubi.model.User;
import cn.dubidubi.service.TestService;

@Controller
@RequestMapping("/lzj")
/**
* @ClassName: TestJunit  
* @Description: aop
* @author 16224  
* @date 2018年4月25日  
*
 */
public class TestJunit {

	@Autowired
	TestService TestService;

	@RequestMapping("/zz")
	public void a() {
		User user = new User();
		user.setUsername("1111");
		user.setDateTime(LocalDateTime.now());
		TestService.hello("lzj", user);
		TestService.save("lzj");
	}
}
