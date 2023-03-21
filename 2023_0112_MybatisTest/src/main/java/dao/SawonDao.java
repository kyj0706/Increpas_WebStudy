package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;

public class SawonDao {
	//single-ton : 객체1개만 생성 서비스
	static SawonDao single = null;

	//SessionFactory생성하는 객체
	SqlSessionFactory factory;
	
	public SawonDao() {
		super();
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static SawonDao getInstance() {

		if (single == null)
			single = new SawonDao();

		return single;
	}
	
	//전체조회
	public List<SawonVo> selectList(){
		
		List<SawonVo> list = null;
		
		//1,Mybatis작업객체 얻어온다.
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행				namespace, mapper id
		list = sqlSession.selectList("sawon.sawon_list");
		
		
		//3.작업후 종료작업(닫기)[필수]
		//conn.close()와 동일하다 
		//-> 안하면 conn수는 20개 또는 설정했는데 끝난다고 알수가 없다. 사용중으로 인식한다.
		sqlSession.close();
		
		return list;
	}
	
}
