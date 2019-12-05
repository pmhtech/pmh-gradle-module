package net.pmhtech.config.job;



import net.pmhtech.executor.QuartzExecutor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EveryRepeat00h01mJob implements Job  {


	@Autowired
	private QuartzExecutor quartzExecutor;


	@Override
	public void execute(JobExecutionContext context) {
		quartzExecutor.execute();
	}
}