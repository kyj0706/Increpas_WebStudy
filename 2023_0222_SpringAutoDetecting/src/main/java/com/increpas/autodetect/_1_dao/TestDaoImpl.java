package com.increpas.autodetect._1_dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 <bean id="test_dao" class="dao.TestDaoImpl">
*/

@Repository("test_dao")
public class TestDaoImpl implements TestDao {

	@Autowired
	SqlSession sqlSession;
	
	public TestDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("--1.TestDaoImpl()--");
	}
		
	
	@Override
	public List selectList() {
		// TODO Auto-generated method stub
		if(sqlSession!=null) {
			System.out.println("-- sqlSession is Autowired!!! --");
		}
		
		List list = new ArrayList();
		list.add("Java");
		list.add("Html");
		list.add("CSS");
		list.add("Javascript");
		list.add("Oracle");
		list.add("Spring");
		
		return list;
	}

}
