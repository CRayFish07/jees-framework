package com.iisquare.jees.demo.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisquare.jees.demo.dao.BigTestDao;
import com.iisquare.jees.demo.domain.BigTest;
import com.iisquare.jees.framework.model.ServiceBase;
import com.iisquare.jees.framework.util.DPUtil;
import com.iisquare.jees.framework.util.ServiceUtil;

@Service
public class BigTestService extends ServiceBase {
	
	@Autowired
	public BigTestDao bigTestDao;
	
	public Map<String, String> getStatusMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("-1", "已删除");
		map.put("0", "禁用");
		map.put("1", "正常");
		return map;
	}
	
	public BigTestService() {}
	
	public long insert(BigTest bigTest) {
		return bigTestDao.insert(bigTest).longValue();
	}
	
	public int update(BigTest bigTest) {
		return bigTestDao.update(bigTest);
	}
	
	public int deleteByIds(Object... ids) {
		return bigTestDao.deleteByIds(ids);
	}
	
	public BigTest getById(Object id) {
		return bigTestDao.getById(id);
	}
	
	public long getCount() {
		return bigTestDao.getCount().longValue();
	}
	
	public List<Map<String, Object>> getPage(String columns, String orderBy, int page, int pageSize) {
		String append = null;
		if(!DPUtil.empty(orderBy)) append = DPUtil.stringConcat(" order by ", orderBy);
		List<Map<String, Object>> list = bigTestDao.getList(columns, null, new Object[]{}, append, page, pageSize);
		list = ServiceUtil.fillFields(list, new String[]{"status"}, new Map<?, ?>[]{getStatusMap()}, null);
		return list;
	}
}
