package com.wyhw.pmp.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wanyanhw
 * @date 2022/6/20 20:11
 */
@Configuration
public class DataSourceConfig {

    private final static String MAPPER_LOCATION = "classpath*:mapping/*.xml";

    @Bean("pmpDataSource")
    @ConfigurationProperties("spring.datasource.dynamic.datasource.pmp")
    public DataSource pmpDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("lcdDataSource")
    @ConfigurationProperties("spring.datasource.dynamic.datasource.lcd")
    public DataSource lcdDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "dataSource")
    public DynamicDataSource dataSource(@Qualifier("pmpDataSource") DataSource pmpDataSource,
                                        @Qualifier("lcdDataSource") DataSource lcdDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("pmp", pmpDataSource);
        targetDataSources.put("lcd", lcdDataSource);
        return new DynamicDataSource(pmpDataSource, targetDataSources);
    }

    @Bean(name = "mysqlSqlSessionFactory")
    public SqlSessionFactory mysqlSqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource(pmpDataSource(), lcdDataSource()));
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    @Bean("mysqlSqlSessionTemplate")
    public SqlSessionTemplate mysqlSqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory mysqlSqlSessionFactory) {
        return new SqlSessionTemplate(mysqlSqlSessionFactory);
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
