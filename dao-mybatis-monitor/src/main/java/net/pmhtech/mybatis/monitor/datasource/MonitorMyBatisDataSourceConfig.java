package net.pmhtech.mybatis.monitor.datasource;

import net.pmhtech.mybatis.datasource.MyBatisDataSourceConfig;
import net.pmhtech.mybatis.monitor.prop.MonitorDatabaseProperties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
@EnableConfigurationProperties(MonitorDatabaseProperties.class)
public class MonitorMyBatisDataSourceConfig extends MyBatisDataSourceConfig {

	
	@Autowired
	private MonitorDatabaseProperties dbProperties;
	
	@Override
	@Primary
    @Bean(name = "monitorMyBatisDataSource", destroyMethod = "close")
	public DataSource dataSource() {

		BasicDataSource basicDataSource = new BasicDataSource();
		this.configureDataSource(basicDataSource, dbProperties);
		return basicDataSource;
	}

}
