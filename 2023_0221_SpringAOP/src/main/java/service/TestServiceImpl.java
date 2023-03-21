package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.Test2Dao;
import dao.TestDao;

public class TestServiceImpl implements TestService {
	
	TestDao test_dao;
	Test2Dao test2_dao;
	
	
	
	

	public TestServiceImpl(TestDao test_dao, Test2Dao test2_dao) {
		super();
		this.test_dao = test_dao;
		this.test2_dao = test2_dao;
	}


	/*
	 * public void setTest_dao(TestDao test_dao) { this.test_dao = test_dao; }
	 */



	@Override
	public Map selectTotalList() {
		// TODO Auto-generated method stub
		
		
		
		
		Map map = new HashMap();
		
		List<String> sido_list = test_dao.selectList();
		List<String> frult_list= test2_dao.selectList();
		
		map.put("sido_list", sido_list);
		map.put("frult_list", frult_list);
		
		try {
			Thread.sleep(1234);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return map;
	}

}
