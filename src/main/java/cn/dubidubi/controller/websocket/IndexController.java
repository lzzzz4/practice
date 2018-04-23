package cn.dubidubi.controller.websocket;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.dubidubi.service.quartz.Job;
import cn.dubidubi.service.quartz.Quartz;

@Controller
@RequestMapping("/test")
public class IndexController {
	@Autowired
	Quartz quartz;

	@RequestMapping("/doTest")
	public void test(HttpServletRequest request) {
		quartz.addJob("job", "GroupName", "triggerName", "triggerGroupName", Job.class, "20 50 7 * * ?");
		quartz.addJob("job1", "GroupName2", "triggerName5", "triggerGroupName8", Job.class, "20 50 7 * * ?");
		quartz.addJob("job2", "GroupName3", "triggerName6", "triggerGroupName9", Job.class, "20 50 7 * * ?");
		quartz.addJob("job3", "GroupName4", "triggerName7", "triggerGroupName0", Job.class, "20 50 7 * * ?");
	}
}
