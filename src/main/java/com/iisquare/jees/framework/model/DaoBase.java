package com.iisquare.jees.framework.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iisquare.jees.framework.Configuration;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
@Scope("prototype")
public abstract class DaoBase<T> extends JdbcTemplate {
	private Class<T> entityClass;
	@Autowired
	protected Configuration configuration;
	protected String tableName = "";
	protected String primaryKey = "id";
	
	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Autowired
	public void setDataSource(ComboPooledDataSource dataSource) {
		super.setDataSource(dataSource);
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public DaoBase(Class<T> clazz) {
		this.entityClass = clazz;
	}
	
	public T getById(int value) {
		String sql = "select * from jees_test where id = ?";
		return queryForObject(sql, new Object[]{value}, entityClass);
	}
}
