package com.iisquare.jees.framework.model;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iisquare.jees.framework.Configuration;
import com.iisquare.jees.framework.util.DPUtil;
import com.iisquare.jees.framework.util.SqlUtil;

@Repository
@Scope("prototype")
public abstract class DaoBase<T> extends JdbcTemplate {
	private Class<T> entityClass;
	@Autowired
	protected Configuration configuration;
	protected String primaryKey = "id";
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
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
	
	/**
	 * 获取对应的数据库表名称
	 */
	public String tableName() {
		return configuration.getTablePrefix() + DPUtil.addUnderscores(entityClass.getSimpleName());
	}
	
	/**
	 * 获取NamedParameterJdbcTemplate操作对象
	 */
	public NamedParameterJdbcTemplate npJdbcTemplate() {
		if(null == namedParameterJdbcTemplate) {
			namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this);
		}
		return namedParameterJdbcTemplate;
	}
	
	public int insert(Map<String, Object> values) {
		return npJdbcTemplate().update(SqlUtil.buildInsert(tableName(), values), values);
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
