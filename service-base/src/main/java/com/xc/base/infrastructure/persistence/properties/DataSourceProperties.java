package com.xc.base.infrastructure.persistence.properties;

public class DataSourceProperties {

	public DataSourceProperties() {
		super();
	}

	// 对应配置文件里的配置键

	

	public final static String PREFIX = "datasource";

	@Override
	public String toString() {
		return "DataSourceProperties [driver=" + driver + ", url=" + url + ", username=" + username + ", password="
				+ password + ", maxActive=" + maxActive + ", initialSize=" + initialSize + ", minIdle=" + minIdle
				+ ", maxWait=" + maxWait + ", timeBetweenEvictionRunsMillis=" + timeBetweenEvictionRunsMillis
				+ ", minEvictableIdleTimeMillis=" + minEvictableIdleTimeMillis + ", validationQuery=" + validationQuery
				+ ", testWhileIdle=" + testWhileIdle + ", testOnBorrow=" + testOnBorrow + ", testOnReturn="
				+ testOnReturn + ", poolPreparedStatements=" + poolPreparedStatements
				+ ", maxPoolPreparedStatementPerConnectionSize=" + maxPoolPreparedStatementPerConnectionSize
				+ ", filters=" + filters + ", connectionProperties=" + connectionProperties + "]";
	}

	private String driver;
	private String url;
	private String username;
	private String password;
	private Integer maxActive = 20;
	private Integer initialSize = 1;
	private Integer minIdle = 1;
	private Integer maxWait = 30000;
	private Integer timeBetweenEvictionRunsMillis = 60000;
	private Integer minEvictableIdleTimeMillis = 300000;
	private String validationQuery = "select 'x'";
	private Boolean testWhileIdle = true;
	private Boolean testOnBorrow = false;
	private Boolean testOnReturn = false;
	private Boolean poolPreparedStatements = true;
	private Integer maxPoolPreparedStatementPerConnectionSize = 100;
	private String filters = "slf4j";
	private String connectionProperties;
	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

	public Boolean getTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(Boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public Boolean getTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(Boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public Boolean getTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(Boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public Boolean getPoolPreparedStatements() {
		return poolPreparedStatements;
	}

	public void setPoolPreparedStatements(Boolean poolPreparedStatements) {
		this.poolPreparedStatements = poolPreparedStatements;
	}

	public Integer getMaxPoolPreparedStatementPerConnectionSize() {
		return maxPoolPreparedStatementPerConnectionSize;
	}

	public void setMaxPoolPreparedStatementPerConnectionSize(Integer maxPoolPreparedStatementPerConnectionSize) {
		this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public Integer getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(Integer maxActive) {
		this.maxActive = maxActive;
	}

	public Integer getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(Integer initialSize) {
		this.initialSize = initialSize;
	}

	public Integer getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(Integer minIdle) {
		this.minIdle = minIdle;
	}

	public Integer getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(Integer maxWait) {
		this.maxWait = maxWait;
	}

	public Integer getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(Integer timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public Integer getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(Integer minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConnectionProperties() {
		return connectionProperties;
	}

	public void setConnectionProperties(String connectionProperties) {
		this.connectionProperties = connectionProperties;
	}

}