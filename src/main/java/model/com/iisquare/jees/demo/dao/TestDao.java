package com.iisquare.jees.demo.dao;

import org.springframework.stereotype.Repository;

import com.iisquare.jees.demo.domain.Test;
import com.iisquare.jees.framework.model.DaoBase;

@Repository
public class TestDao extends DaoBase<Test> {
	
	public TestDao() {
		super(Test.class);
	}
}
