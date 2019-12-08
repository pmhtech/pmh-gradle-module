package net.pmhtech.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.SpringServletContainerInitializer;

@SpringBootApplication(
	scanBasePackages = {
		"com.afreeca.*",
		"net.pmhtech.*"
	}
)
@EnableScheduling
public class MonitorServerBoot {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MonitorServerBoot.class, args);
	}

	@Bean
	public TaskScheduler poolScheduler() {
		final ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setThreadNamePrefix("poolScheduler");
		scheduler.setPoolSize(10);
		scheduler.initialize();
		return scheduler;
	}
}

