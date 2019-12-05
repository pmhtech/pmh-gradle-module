package net.pmhtech.connector;

import net.pmhtech.monitor.domain.LogMaster;

import java.util.List;

public interface AbstractConnector {

    List<LogMaster> getData(String key);
}
