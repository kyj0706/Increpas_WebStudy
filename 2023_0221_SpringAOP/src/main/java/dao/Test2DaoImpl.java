package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class Test2DaoImpl implements Test2Dao {
	
	//자동연결(엮기)
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<String> selectList() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		
		list.add("사과");
		list.add("참외");
		list.add("수박");
		list.add("딸기");
		list.add("포도");
		
		return list;
	}

}
