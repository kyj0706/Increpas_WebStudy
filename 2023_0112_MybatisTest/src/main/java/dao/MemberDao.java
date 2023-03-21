package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVo;

public class MemberDao {
	
	//single-ton pattern
	static MemberDao single = null;

	SqlSessionFactory factory;
	
	
	//��? : �ܺο��� new MemberDao()�������� ���ϵ���
	private MemberDao() {
		super();
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	
	public static MemberDao getInstance() {
		//�������� �ʾ����� �����ض�
		if (single == null)
			single = new MemberDao();

		return single;
	}
	
	public List<MemberVo> selectList(){
		
		List<MemberVo> list = null;
		
		SqlSession sqlSession  = factory.openSession();
		
		list =sqlSession.selectList("member.member_list");
		
		sqlSession.close();
		
		return list;
		
	}
	
	public List<MemberVo> selectOne(String mem_id) {
		List<MemberVo>list = null;
		
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectOne("member_login",mem_id);
		
		sqlSession.close();
		
		return list;
	}
	
	
	
	
}
