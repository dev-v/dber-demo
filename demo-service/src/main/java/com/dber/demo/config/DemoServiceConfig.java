package com.dber.demo.config;

import com.dber.platform.config.PlatformWebServiceConfig;
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
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * <li>文件名称: DemoService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月21日
 * @author dev-v
 */

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableConfigurationProperties({SystemConfig.class})
@Import(PlatformWebServiceConfig.class)
@ComponentScan("com.dber.demo")
@MapperScan(basePackages = {"com.dber.demo.mapper"})
public class DemoServiceConfig {
	@Autowired
	private SystemConfig systemConfig;

	@Bean
	public DataSource demoDataSource() {
		DataSource demoDataSource = DBUtil.dataSource(systemConfig.getDatabase());
		return demoDataSource;
	}

	@Bean
	public DataSourceTransactionManager demoTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(demoDataSource());
		return transactionManager;
	}

	@Bean
	public org.apache.ibatis.session.Configuration demoMybatisConfiguration() {
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setMapUnderscoreToCamelCase(true);
		configuration.getTypeAliasRegistry().registerAliases("com.dber.demo.api.entity");
		return configuration;
	}

	@Bean
	public SqlSessionFactoryBean demoSqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean demoSqlSessionFactoryBean = new SqlSessionFactoryBean();

		demoSqlSessionFactoryBean.setDataSource(demoDataSource());

		demoSqlSessionFactoryBean.setConfiguration(demoMybatisConfiguration());

		PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
		demoSqlSessionFactoryBean
				.setMapperLocations(resourceResolver.getResources("classpath*:/mapper/*_mapper.xml"));

		Interceptor[] interceptors = { PaginationInterceptor.getInstance() };
		demoSqlSessionFactoryBean.setPlugins(interceptors);

		return demoSqlSessionFactoryBean;
	}
}
