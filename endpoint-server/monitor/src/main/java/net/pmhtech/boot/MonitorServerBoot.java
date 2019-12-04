package net.pmhtech.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(
        scanBasePackages = {
                "net.pmhtech.*",
        }
)
public class MonitorServerBoot extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(MonitorServerBoot.class,args);
    }
}
