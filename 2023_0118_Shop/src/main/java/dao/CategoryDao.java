package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CategoryVo;

public class CategoryDao {
	
	SqlSessionFactory factory;
	
	//single-ton pattern
	static CategoryDao single = null;

	public static CategoryDao getInstance() {
		//�������� �ʾ����� �����ض�
		if (single == null)
			single = new CategoryDao();

		return single;
	}

	//��? : �ܺο��� new CategoryDao()�������� ���ϵ���
	private CategoryDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		
	}
	
	public List<CategoryVo> selectList(){
		
		List<CategoryVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("category.category_list");
		
		
		sqlSession.close();
		
		
		
		return list;
	}
	
}
