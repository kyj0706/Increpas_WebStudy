package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class Test2DaoImpl implements Test2Dao {
	
	//�ڵ�����(����)
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<String> selectList() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		
		list.add("���");
		list.add("����");
		list.add("����");
		list.add("����");
		list.add("����");
		
		return list;
	}

}
