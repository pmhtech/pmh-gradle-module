package net.pmhtech.scheduler;

import lombok.extern.slf4j.Slf4j;
import net.pmhtech.monitor.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
public class MonitorScheduler {


    @Autowired
    private MonitorService monitorService;

    @Scheduled(cron = "0/2 * * * * *")
    public void batchRefresh(){

        monitorService.doLogging();
    }


}
