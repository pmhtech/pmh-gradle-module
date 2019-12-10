package net.pmhtech.mybatis.monitor.datasource;

import net.pmhtech.mybatis.datasource.MyBatisDataSourceConfig;
import net.pmhtech.mybatis.mapper.MonitorMapper;
import net.pmhtech.mybatis.monitor.prop.MonitorDatabaseProperties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = {
		"net.pmhtech.monitor.dao.mybatis"
}, annotationClass = MonitorMapper.class, sqlSessionFactoryRef = "monitorSqlSessionFactory")
@EnableConfigurationProperties(MonitorDatabaseProperties.class)
public class MonitorMyBatisDataSourceConfig extends MyBatisDataSourceConfig {

	
	@Autowired
	private MonitorDatabaseProperties dbProperties;
	
	@Override
	@Bean(name = "monitorMyBatisDataSource", destroyMethod = "close")
	public DataSource dataSource() {

		BasicDataSource basicDataSource = new BasicDataSource();
		this.configureDataSource(basicDataSource, dbProperties);
		return basicDataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(@Qualifier("monitorMyBatisDataSource") DataSource monitorMyBatisDataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(monitorMyBatisDataSource);
		transactionManager.setGlobalRollbackOnParticipationFailure(false);
		return transactionManager;
	}

}
