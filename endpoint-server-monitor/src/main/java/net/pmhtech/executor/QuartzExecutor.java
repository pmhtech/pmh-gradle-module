package net.pmhtech.executor;

import net.pmhtech.monitor.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create By muhyung@smarf.kr .
 */

@Service
public class QuartzExecutor {

    @Autowired
    private MonitorService monitorService;

    public void execute(){
        monitorService.doLogging();

    }
}
