package cn.dubidubi.service.quartz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Quartz {
	// private static SchedulerFactory schedulerFactory = new
	// StdSchedulerFactory();
	@Autowired
	private Scheduler sched;

	/**
	 * @Description: 带参数的增加任务与触发器
	 * @data :@param jobName
	 * @data :@param jobGroupName
	 * @data :@param triggerName
	 * @data :@param triggerGroupName
	 * @data :@param jobClass
	 * @data :@param cron
	 * @data :@param jobDataKey
	 * @data :@param jobDataValue
	 * @date :2018年3月13日下午2:58:16
	 */
	public void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class jobClass,
			String cron, String jobDataKey, String jobDataValue) {
		try {
			// Scheduler sched = schedulerFactory.getScheduler();
			// 任务名，任务组，任务执行类
			JobDetail jobDetail;
			if (StringUtils.isNotBlank(jobDataKey) && StringUtils.isNotBlank(jobDataValue)) {
				jobDetail = JobBuilder.newJob(jobClass).usingJobData(jobDataKey, jobDataValue)
						.withIdentity(jobName, jobGroupName).build();
			} else {
				jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
			}

			// 触发器
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
			// 触发器名,触发器组
			triggerBuilder.withIdentity(triggerName, triggerGroupName);
			triggerBuilder.startNow();
			// 触发器时间设定
			triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
			// 创建Trigger对象
			CronTrigger trigger = (CronTrigger) triggerBuilder.build();

			// 调度容器设置JobDetail和Trigger
			sched.scheduleJob(jobDetail, trigger);

			// 启动
			if (!sched.isShutdown()) {
				sched.start();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class jobClass,
			String cron) {
		try {

			// 任务名，任务组，任务执行类
			JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
			// 触发器
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
			// 触发器名,触发器组
			triggerBuilder.withIdentity(triggerName, triggerGroupName);
			triggerBuilder.startNow();
			// 触发器时间设定
			triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
			// 创建Trigger对象
			CronTrigger trigger = (CronTrigger) triggerBuilder.build();

			// 调度容器设置JobDetail和Trigger
			sched.scheduleJob(jobDetail, trigger);

			// 启动
			if (!sched.isShutdown()) {
				sched.start();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void updateJobTime(String jobName, String jobGroupName, String triggerName, String triggerGroupName,
			String cron) {
		try {

			TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
			CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);
			if (trigger == null) {
				return;
			}

			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(cron)) {
				/** 方式一 ：调用 rescheduleJob 开始 */
				// 触发器
				TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
				// 触发器名,触发器组
				triggerBuilder.withIdentity(triggerName, triggerGroupName);
				triggerBuilder.startNow();
				// 触发器时间设定
				triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
				// 创建Trigger对象
				trigger = (CronTrigger) triggerBuilder.build();
				// 方式一 ：修改一个任务的触发时间
				sched.rescheduleJob(triggerKey, trigger);
				/** 方式一 ：调用 rescheduleJob 结束 */
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);

			sched.pauseTrigger(triggerKey);// 停止触发器
			sched.unscheduleJob(triggerKey);// 移除触发器
			sched.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void startJobs() {
		try {
			sched.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description:关闭所有定时任务
	 */
	public void shutdownJobs() {
		try {
			if (!sched.isShutdown()) {
				sched.shutdown();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取所有计划中的任务列表
	 * @return
	 */
	public List<Map<String, Object>> queryAllJob() {
		List<Map<String, Object>> jobList = null;
		try {
			GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
			Set<JobKey> jobKeys = sched.getJobKeys(matcher);
			jobList = new ArrayList<Map<String, Object>>();
			for (JobKey jobKey : jobKeys) {
				List<? extends Trigger> triggers = sched.getTriggersOfJob(jobKey);
				for (Trigger trigger : triggers) {
					Map<String, Object> map = new HashMap<>();
					map.put("jobName", jobKey.getName());
					map.put("jobGroupName", jobKey.getGroup());
					map.put("description", "触发器:" + trigger.getKey());
					Trigger.TriggerState triggerState = sched.getTriggerState(trigger.getKey());
					map.put("jobStatus", triggerState.name());
					if (trigger instanceof CronTrigger) {
						CronTrigger cronTrigger = (CronTrigger) trigger;
						String cronExpression = cronTrigger.getCronExpression();
						map.put("jobTime", cronExpression);
					}
					jobList.add(map);
				}
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return jobList;
	}
}
