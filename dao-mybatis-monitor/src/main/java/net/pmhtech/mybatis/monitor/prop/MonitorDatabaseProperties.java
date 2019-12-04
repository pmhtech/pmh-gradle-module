package net.pmhtech.mybatis.monitor.prop;

import net.pmhtech.mybatis.prop.DatabaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix="spring.datasource.monitor")
public class MonitorDatabaseProperties extends DatabaseProperties {
	
}
