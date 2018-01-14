package com.xc.base.infrastructure.persistence;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.xc.base.infrastructure.persistence.properties.DataSourceProperties;

@EnableTransactionManagement
@Configuration
public class Conf {
	private final Logger logger = LoggerFactory.getLogger(Conf.class);
	
	private DataSourceProperties dataSourceProperties;

	@Bean
	@ConfigurationProperties(prefix = DataSourceProperties.PREFIX, ignoreUnknownFields = false)
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary // 默认数据源
	@Bean(name = "dataSource", destroyMethod = "close", initMethod = "init")
	public DataSource Construction() throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();

		// 不这么配置 读取不到配置类 一直为null
		this.dataSourceProperties = dataSourceProperties();
		System.out.println(dataSourceProperties);
		dataSource.setUrl(dataSourceProperties.getUrl());
		dataSource.setUsername(dataSourceProperties.getUsername());
		dataSource.setPassword(dataSourceProperties.getPassword());
		dataSource.setDriverClassName(dataSourceProperties.getDriver());
		// 配置最大连接
		dataSource.setMaxActive(dataSourceProperties.getMaxActive());
		// 配置初始连接
		dataSource.setInitialSize(dataSourceProperties.getInitialSize());
		// 配置最小连接
		dataSource.setMinIdle(dataSourceProperties.getMinIdle());
		// 连接等待超时时间
		dataSource.setMaxWait(dataSourceProperties.getMaxWait());
		// 间隔多久进行检测,关闭空闲连接
		dataSource.setTimeBetweenEvictionRunsMillis(dataSourceProperties.getTimeBetweenEvictionRunsMillis());
		// 一个连接最小生存时间
		dataSource.setMinEvictableIdleTimeMillis(dataSourceProperties.getMinEvictableIdleTimeMillis());
		// 用来检测是否有效的sql
		dataSource.setValidationQuery(dataSourceProperties.getValidationQuery());
		dataSource.setTestWhileIdle(dataSourceProperties.getTestWhileIdle());
		dataSource.setTestOnBorrow(dataSourceProperties.getTestOnBorrow());
		dataSource.setTestOnReturn(dataSourceProperties.getTestOnReturn());
		// 是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。
		dataSource.setPoolPreparedStatements(dataSourceProperties.getPoolPreparedStatements());
		dataSource.setMaxOpenPreparedStatements(dataSourceProperties.getMaxPoolPreparedStatementPerConnectionSize());
		// 配置sql监控的filter
		dataSource.setFilters(dataSourceProperties.getFilters());
		dataSource.setConnectionProperties(dataSourceProperties.getConnectionProperties());
		try {
			dataSource.init();
			logger.debug("DataSource init success!");
		} catch (SQLException e) {
			logger.error("druid datasource init fail", e);
			throw e;
		}
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/*.mapper.xml"));
		sqlSessionFactoryBean.setTypeAliasesPackage("com.xc.base.infrastructure.persistence.model");
		return sqlSessionFactoryBean.getObject();
	}

}
