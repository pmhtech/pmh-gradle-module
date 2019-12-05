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
		"net.pmhtech.monitor.dao.mybatis"
}, annotationClass = MonitorMapper.class, sqlSessionFactoryRef = "monitorSqlSessionFactory")
public class MonitorMyBatisMapperConfig extends MyBatisMapperConfig {
	
	
	@Bean
	public SqlSessionFactory monitorSqlSessionFactory(@Qualifier("monitorMyBatisDataSource") DataSource monitorMyBatisDataSource) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		this.configureSqlSessionFactory(sessionFactoryBean, monitorMyBatisDataSource);
		return sessionFactoryBean.getObject();
	}
}
