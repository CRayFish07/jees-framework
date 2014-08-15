package com.iisquare.jees.framework.model;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
	@Override
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
	
	/**
	 * 添加记录，返回自增长ID
	 */
	public int insert(Map<String, Object> values) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int result = npJdbcTemplate().update(SqlUtil.buildInsert(tableName(), values)
				, new MapSqlParameterSource(values), keyHolder);
		return result > 0 ? keyHolder.getKey().intValue() : result;
	}
	
	/**
	 * 添加记录，返回自增长ID
	 */
	public int insert(T object) {
		Map<String, Object> values = DPUtil.convertEntityToMap(object, true);
		if(null == values) return 0;
		return insert(values);
	}
	
	/**
	 * 更新记录，返回影响行数
	 */
	public int update(T object) {
		if(null == object) return 0;
		Map<String, Object> values = DPUtil.convertEntityToMap(object, true);
		return updateByIds(values, values.get(primaryKey));
	}
	
	/**
	 * 更新记录，返回影响行数
	 */
	public int update(Map<String, Object> values, String where) {
		String sql = SqlUtil.buildUpdate(tableName(), values, where);
		return npJdbcTemplate().update(sql, values);
	}
	
	/**
	 * 更新记录，返回影响行数
	 */
	public int update(Map<String, Object> values, Map<String, Object> where, Map<String, String> operators) {
		String sql = SqlUtil.buildUpdate(tableName(), values, SqlUtil.buildWhere(where, operators));
		return npJdbcTemplate().update(sql, values);
	}
	
	/**
	 * 根据ID更新记录，返回影响行数
	 */
	public int updateByIds(Map<String, Object> values, Object... ids) {
		if(DPUtil.empty(ids)) return 0;
		StringBuilder where = new StringBuilder();
		where.append(primaryKey).append(" in (").append(DPUtil.makeIds(ids)).append(")");
		String sql = SqlUtil.buildUpdate(tableName(), values, where.toString());
		return npJdbcTemplate().update(sql, values);
	}
	
	/**
	 * 删除记录，返回影响行数
	 */
	public int delete(T object) {
		if(null == object) return 0;
		Map<String, Object> values = DPUtil.convertEntityToMap(object, true);
		return deleteByIds(values.get(primaryKey));
	}
	
	/**
	 * 删除记录，返回影响行数
	 */
	public int delete(String where) {
		String sql = SqlUtil.buildDelete(tableName(), where);
		return npJdbcTemplate().update(sql, new HashMap<String, Object>());
	}
	
	/**
	 * 删除记录，返回影响行数
	 */
	public int delete(Map<String, Object> where, Map<String, String> operators) {
		String sql = SqlUtil.buildDelete(tableName(), SqlUtil.buildWhere(where, operators));
		return npJdbcTemplate().update(sql, where);
	}
	
	/**
	 * 根据ID删除记录，返回影响行数
	 */
	public int deleteByIds(Object... ids) {
		if(DPUtil.empty(ids)) return 0;
		StringBuilder where = new StringBuilder();
		where.append(primaryKey).append(" in (").append(DPUtil.makeIds(ids)).append(")");
		String sql = SqlUtil.buildDelete(tableName(), where.toString());
		return npJdbcTemplate().update(sql, new HashMap<String, Object>());
	}
	
	/**
	 * 更具ID获取对象
	 */
	public T getById(int id) {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from ").append(tableName()).append(" where ")
				.append(primaryKey).append(" = ? limit 1");
		return queryForObject(sb.toString(), new Object[]{id}, entityClass);
	}
}
