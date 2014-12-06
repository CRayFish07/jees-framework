package com.iisquare.jees.demo.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.iisquare.jees.demo.domain.BigTest;
import com.iisquare.jees.framework.model.DaoBase;

@Repository
@Scope("prototype")
public class BigTestDao extends DaoBase<BigTest> {
	
	public BigTestDao() {
		super(BigTest.class);
	}
}
