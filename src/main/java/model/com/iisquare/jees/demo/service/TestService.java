package com.iisquare.jees.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.iisquare.jees.demo.dao.TestDao;
import com.iisquare.jees.framework.model.ServiceBase;

public class TestService extends ServiceBase {
	
	@Autowired
	public TestDao testDao;
	
	public TestService() {}
	
	public Map<String, Object> getById(int id) {
		return testDao.getById(id);
	}
}
