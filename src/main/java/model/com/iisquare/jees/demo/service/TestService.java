package com.iisquare.jees.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisquare.jees.demo.dao.TestDao;
import com.iisquare.jees.demo.domain.Test;
import com.iisquare.jees.framework.model.ServiceBase;

@Service
public class TestService extends ServiceBase {
	
	@Autowired
	public TestDao testDao;
	
	public TestService() {}
	
	public Test getById(int id) {
		return null;
	}
}
