package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;

public class SawonDao {
	//single-ton : ��ü1���� ���� ����
	static SawonDao single = null;

	//SessionFactory�����ϴ� ��ü
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
	
	//��ü��ȸ
	public List<SawonVo> selectList(){
		
		List<SawonVo> list = null;
		
		//1,Mybatis�۾���ü ���´�.
		SqlSession sqlSession = factory.openSession();
		
		//2.�۾�����				namespace, mapper id
		list = sqlSession.selectList("sawon.sawon_list");
		
		
		//3.�۾��� �����۾�(�ݱ�)[�ʼ�]
		//conn.close()�� �����ϴ� 
		//-> ���ϸ� conn���� 20�� �Ǵ� �����ߴµ� �����ٰ� �˼��� ����. ��������� �ν��Ѵ�.
		sqlSession.close();
		
		return list;
	}
	
}
