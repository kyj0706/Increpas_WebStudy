package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class TestDaoImpl implements TestDao {
	
	//자동연결(엮기)
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<String> selectList() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		
		list.add("서울");
		list.add("경기");
		list.add("인천");
		list.add("대전");
		list.add("대구");
		
		return list;
	}

}
