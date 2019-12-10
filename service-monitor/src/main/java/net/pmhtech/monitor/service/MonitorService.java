package net.pmhtech.monitor.service;

import com.afreeca.connector.AfreecaConnector;
import lombok.extern.slf4j.Slf4j;
import net.pmhtech.monitor.dao.mybatis.MyBatisLogMasterDao;
import net.pmhtech.monitor.domain.LogMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MonitorService {

    @Autowired
    private AfreecaConnector afreecaConnector;

    @Autowired
    private MyBatisLogMasterDao myBatisLogMasterDao;

    public void doLogging(){

        String[] keywords = {"종최","종족","최강전","KCM"};

        for(String key : keywords){
            List<LogMaster> listLogMaster = afreecaConnector.getData(key);
            for(LogMaster logMaster : listLogMaster){
                myBatisLogMasterDao.insert(logMaster);
            }
        }
    }

}
