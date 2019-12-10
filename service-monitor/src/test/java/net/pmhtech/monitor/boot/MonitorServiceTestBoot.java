package net.pmhtech.monitor.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@SpringBootApplication(
	scanBasePackages = {
		"com.afreeca.*",
		"net.pmhtech.*"
	}
)
public class MonitorServiceTestBoot{

	public static void main(String[] args) {
		SpringApplication.run(MonitorServiceTestBoot.class, args);
	}
}

