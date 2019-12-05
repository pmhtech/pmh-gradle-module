package net.pmhtech.monitor.service;

import net.pmhtech.connector.AbstractConnector;
import net.pmhtech.monitor.dao.mybatis.MyBatisLogMasterDao;
import net.pmhtech.monitor.domain.LogMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MonitorService {

    @Resource(name="afreecaConnector")
    private AbstractConnector afreecaConnector;

    @Autowired
    private MyBatisLogMasterDao myBatisLogMasterDao;

    public void doLogging(){

        String[] keywords = {"종족","종최","종족","최강전","KCM"};

        for(String key : keywords){
            List<LogMaster> listLogMaster = afreecaConnector.getData(key);

            for(LogMaster logMaster : listLogMaster){
                myBatisLogMasterDao.insert(logMaster);
            }
        }
    }

}
