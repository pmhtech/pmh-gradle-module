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


	/**
	 * <p>
	 * Called by the <code>{@link Scheduler}</code> when a <code>{@link Trigger}</code>
	 * fires that is associated with the <code>Job</code>.
	 * </p>
	 *
	 * <p>
	 * The implementation may wish to set a
	 * {@link JobExecutionContext#setResult(Object) result} object on the
	 * {@link JobExecutionContext} before this method exits.  The result itself
	 * is meaningless to Quartz, but may be informative to
	 * <code>{@link JobListener}s</code> or
	 * <code>{@link TriggerListener}s</code> that are watching the job's
	 * execution.
	 * </p>
	 *
	 * @param context
	 * @throws JobExecutionException if there is an exception while executing the job.
	 */
	@Override
	public void execute(JobExecutionContext context) {
		quartzExecutor.execute();
	}
}