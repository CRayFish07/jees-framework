package com.iisquare.jees.demo.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisquare.jees.demo.dao.TestDao;
import com.iisquare.jees.demo.domain.Test;
import com.iisquare.jees.framework.model.ServiceBase;
import com.iisquare.jees.framework.util.DPUtil;
import com.iisquare.jees.framework.util.ServiceUtil;

@Service
public class TestService extends ServiceBase {
	
	@Autowired
	public TestDao testDao;
	
	public Map<String, String> getStatusMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("-1", "已删除");
		map.put("0", "禁用");
		map.put("1", "正常");
		return map;
	}
	
	public TestService() {}
	
	public int insert(Test test) {
		return testDao.insert(test);
	}
	
	public int update(Test test) {
		return testDao.update(test);
	}
	
	public int deleteByIds(Object... ids) {
		return testDao.deleteByIds(ids);
	}
	
	public Test getById(Integer id) {
		return testDao.getById(id);
	}
	
	public int getCount() {
		return testDao.getCount();
	}
	
	public List<Map<String, Object>> getPage(String columns, String orderBy, int page, int pageSize) {
		String append = null;
		if(!DPUtil.empty(orderBy)) append = DPUtil.stringConcat(" order by ", orderBy);
		List<Map<String, Object>> list = testDao.getList(columns, null, new Object[]{}, append, page, pageSize);
		list = ServiceUtil.fillFields(list, new String[]{"status"}, new Map<?, ?>[]{getStatusMap()}, null);
		return list;
	}
}
