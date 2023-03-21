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
	
	
	//왜? : 외부에서 new MemberDao()생성하지 못하도록
	private MemberDao() {
		super();
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	
	public static MemberDao getInstance() {
		//생성되지 않았으면 생성해라
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
