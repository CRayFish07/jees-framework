package com.iisquare.jees.demo.dao;

import com.iisquare.jees.demo.domain.Test;
import com.iisquare.jees.framework.model.DaoBase;

public class TestDao extends DaoBase<Test> {
	
	public TestDao() {
		super(Test.class);
	}
}
