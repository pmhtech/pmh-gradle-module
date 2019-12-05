package net.pmhtech.monitor.dao.mybatis;

import net.pmhtech.monitor.domain.LogMaster;
import net.pmhtech.mybatis.monitor.mapper.MonitorMapper;

@MonitorMapper
public interface MyBatisLogMasterDao {

    void insert(LogMaster logMaster);
}
