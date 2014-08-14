package com.iisquare.jees.framework.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iisquare.jees.framework.Configuration;
import com.iisquare.jees.framework.util.DPUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
@Scope("prototype")
public abstract class DaoBase<T> extends JdbcTemplate {
	private Class<T> entityClass;
	@Autowired
	protected Configuration configuration;
	protected String primaryKey = "id";

	@Autowired
	public void setDataSource(ComboPooledDataSource dataSource) {
		super.setDataSource(dataSource);
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
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
	
	public String tableName() {
		return configuration.getTablePrefix() + DPUtil.addUnderscores(entityClass.getSimpleName());
	}
	
	public int insert(Map<String, Object> values) {
		
		return 0;
	}
	
	public void bantchInsert() {
		
	}
	
	public int update(Map<String, Object> values, String where) {
		return 0;
	}
	
	public void batchUpdate() {
		
	}
	
	public int delete(String where) {
		return 0;
	}
	
	public Map<String, Object> getById(int id) {
		return null;
	}
}
