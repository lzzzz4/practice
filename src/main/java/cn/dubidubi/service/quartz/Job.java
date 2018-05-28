package cn.dubidubi.service.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.dubidubi.service.TestService;

@Component
public class Job implements org.quartz.Job {
    @Autowired
    @Qualifier("service2")
    TestService testService;

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("coming");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
