package net.pmhtech.mybatis.mapper;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Slf4j
public class MyBatisMapperConfig  {
    
    
    public static final String TYPE_ALIASES_PACKAGE = "com.farota";
    public static final String CONFIG_LOCATION_PATH = "classpath:mybatis-config.xml";
    public static final String MAPPER_LOCATIONS_PATH = "classpath*:sqlmap/**/*.xml";
     
    protected void configureSqlSessionFactory(SqlSessionFactoryBean sessionFactoryBean, DataSource dataSource) throws IOException {
        PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);

        sessionFactoryBean.setConfigLocation(pathResolver.getResource(CONFIG_LOCATION_PATH));
        sessionFactoryBean.setMapperLocations(pathResolver.getResources(MAPPER_LOCATIONS_PATH));
    }
}