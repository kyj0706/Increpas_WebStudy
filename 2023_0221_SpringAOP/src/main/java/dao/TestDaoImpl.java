package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class TestDaoImpl implements TestDao {
	
	//�ڵ�����(����)
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<String> selectList() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		
		list.add("����");
		list.add("���");
		list.add("��õ");
		list.add("����");
		list.add("�뱸");
		
		return list;
	}

}
