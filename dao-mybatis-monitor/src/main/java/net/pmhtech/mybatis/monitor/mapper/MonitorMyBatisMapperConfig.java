package net.pmhtech.mybatis.monitor.mapper;

import net.pmhtech.mybatis.mapper.MyBatisMapperConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = {
		"com.farota.log.dao.mybatis"
}, annotationClass = MonitorMapper.class, sqlSessionFactoryRef = "monitorSqlSessionFactory")
public class MonitorMyBatisMapperConfig extends MyBatisMapperConfig {
	
	
	@Bean
	public SqlSessionFactory logSqlSessionFactory(@Qualifier("monitorMyBatisDataSource") DataSource logMyBatisDataSource) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		this.configureSqlSessionFactory(sessionFactoryBean, logMyBatisDataSource);
		return sessionFactoryBean.getObject();
	}
}
