package com.dber.demo.config;

import com.dber.platform.mybatis.plugin.pagination.PaginationInterceptor;
import com.dber.platform.util.DBUtil;
import com.dber.tool.config.SystemConfig;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan("com.dber.demo")
@EnableConfigurationProperties({SystemConfig.class})
@MapperScan(basePackages = {"com.dber.demo.mapper"})
public class DemoServiceConfig {

  @Autowired
  private SystemConfig systemConfig;

  @Bean
  public DataSource platDataSource() {
    DataSource platDataSource = DBUtil.dataSource(systemConfig.getDatabase());
    return platDataSource;
  }

  @Bean
  public DataSourceTransactionManager platTransactionManager() {
    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(platDataSource());
    return transactionManager;
  }

  @Bean
  public org.apache.ibatis.session.Configuration platMybatisConfiguration() {
    org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
    configuration.setMapUnderscoreToCamelCase(true);
    configuration.getTypeAliasRegistry().registerAliases("com.dber.demo.entity");
    return configuration;
  }

  @Bean
  public SqlSessionFactoryBean platSqlSessionFactoryBean() throws IOException {
    SqlSessionFactoryBean platSqlSessionFactoryBean = new SqlSessionFactoryBean();

    platSqlSessionFactoryBean.setDataSource(platDataSource());

    platSqlSessionFactoryBean.setConfiguration(platMybatisConfiguration());

    PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
    platSqlSessionFactoryBean
            .setMapperLocations(resourceResolver.getResources("classpath*:/mapper/*_mapper.xml"));

    Interceptor[] interceptors = {PaginationInterceptor.getInstance()};
    platSqlSessionFactoryBean.setPlugins(interceptors);

    return platSqlSessionFactoryBean;
  }
}
