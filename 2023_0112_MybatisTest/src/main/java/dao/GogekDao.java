package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.GogekVo;

public class GogekDao {
	//single-ton pattern
	static GogekDao single = null;
	
	//SessionFactory생성하는 객체
	SqlSessionFactory factory;
	
	public GogekDao() {
		super();
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public static GogekDao getInstance() {
		//생성되지 않았으면 생성해라
		if (single == null)
			single = new GogekDao();

		return single;
	}

	public List<GogekVo> selectList(){
		List<GogekVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("gogek.gogek_list");
		
		sqlSession.close();
		
		return list;
	}
}
