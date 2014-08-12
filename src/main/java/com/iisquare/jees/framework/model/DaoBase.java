package com.iisquare.jees.framework.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iisquare.jees.framework.Configuration;

@Repository
public abstract class DaoBase<T> {
	private Class<T> entityClass;
	@Autowired
	protected JdbcTemplate jdbcTemplate;
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

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
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
		return null;
	}
}
