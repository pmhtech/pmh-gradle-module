package net.pmhtech.connector;

import java.util.List;

public interface AbstractConnector {

    List<?> getData(String key);
}
