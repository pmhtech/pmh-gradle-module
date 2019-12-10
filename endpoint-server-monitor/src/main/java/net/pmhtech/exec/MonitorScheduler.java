package net.pmhtech.exec;

import lombok.extern.slf4j.Slf4j;
import net.pmhtech.monitor.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MonitorScheduler {


    @Autowired
    private MonitorService monitorService;

    @Scheduled(fixedDelay = 1000*30)
    public void batchRefresh(){

            log.info("batchRefresh");
            monitorService.doLogging();

    }


}
