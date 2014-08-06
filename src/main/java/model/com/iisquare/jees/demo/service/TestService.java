package com.iisquare.jees.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisquare.jees.demo.dao.TestDao;

@Service
public class TestService {
	
	@Autowired
	public TestDao testDao;
	
	public TestService() {}
}
