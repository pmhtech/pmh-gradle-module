package net.pmhtech.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
	scanBasePackages = {
		"net.pmhtech.config",
		"net.pmhtech.*",
		"com.afreeca.*"
			
	}
)
public class MonitorServerBoot {

	public static void main(String[] args) {
		SpringApplication.run(MonitorServerBoot.class, args);
	}

}

