package net.pmhtech.config.scheduler;


import net.pmhtech.config.job.EveryRepeat00h01mJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component

public class EveryRepeat00h01mScheduler {

		@Autowired
		private SchedulerFactoryBean schedulerFactory;

		private Scheduler scheduler;
	    
	    @PostConstruct
	    public void start() throws SchedulerException{
	    
	        scheduler = schedulerFactory.getScheduler();
	        scheduler.start();
	        
	        //job 지정
	        JobDetail job = JobBuilder.newJob(EveryRepeat00h01mJob.class).withIdentity("everyRepeat00h01mJob").build();
	        
	        //trigger 생성
	        Trigger trigger = TriggerBuilder.newTrigger().
	                withSchedule(CronScheduleBuilder.cronSchedule("	0 0/1 * 1/1 * ? *")).build();

	        scheduler.scheduleJob(job, trigger);
	        
	    }
	}
