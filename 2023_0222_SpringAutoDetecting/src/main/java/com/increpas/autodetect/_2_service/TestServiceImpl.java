package com.increpas.autodetect._2_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.autodetect._1_dao.TestDao;

@Service("test_service")
public class TestServiceImpl implements TestService {

	@Autowired
	TestDao test_dao; 
		
	public TestServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("--2.TestServiceImpl()--");
	}
	
	
	@Override
	public List selectTotalList() {
		// TODO Auto-generated method stub
		return test_dao.selectList();
	}

}
