package net.pmhtech.exec;

import net.pmhtech.boot.MonitorServerBoot;
import net.pmhtech.monitor.service.MonitorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={MonitorServerBoot.class})
public class MonitorSchedulerTest {

    @Autowired
    private MonitorService monitorService;

    @Test
    public void test(){
        monitorService.doLogging();

    }


}
