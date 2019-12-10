package net.pmhtech.monitor.service;


import net.pmhtech.monitor.boot.MonitorServiceTestBoot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={
        MonitorServiceTestBoot.class
})
public class MonitorServiceTest {

    @Autowired
    private MonitorService monitorService;

    @Test
    public void doLogging() {
        monitorService.doLogging();
    }
}
