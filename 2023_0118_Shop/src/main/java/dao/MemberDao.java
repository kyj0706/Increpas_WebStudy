package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVo;

public class MemberDao {
	
	SqlSessionFactory factory;
	
	
	//single-ton pattern
	static MemberDao single = null;

	public static MemberDao getInstance() {
		//생성되지 않았으면 생성해라
		if (single == null)
			single = new MemberDao();

		return single;
	}

	//왜? : 외부에서 new MemberDao()생성하지 못하도록
	private MemberDao() {
		// TODO Auto-generated constructor stub
		factory =MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	
	
	//list 
	public List<MemberVo> selectList() {

		List<MemberVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("member.member_list");
		
		sqlSession.close();
		
		return list;
	}
	
	
	//update mem_idx 정보 넘기기
	//member_로그인번호(hide:mem_idx값)
	public MemberVo selectOne(int mem_idx) {

		MemberVo vo = null;
		
		SqlSession sqlSession =factory.openSession(true);
		vo = sqlSession.selectOne("member.member_login_update",mem_idx);
		
		return vo;
	}
	
	//로그인 하기 위한 
	//member에서 해당되는 1명의 정보  
	public MemberVo selectOne(String mem_id) {
		
		MemberVo vo = null;
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("member.member_login",mem_id);
		
		sqlSession.close();
		
		return vo;
	}
	
	
	//insert
	public int insert(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("member.member_insert",vo);
		
		
		return res;
	}
	
	
	//update
	public int update(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.update("member.member_update",vo);
		
		return res;
	}
	
	//delete
	public int delete(int mem_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.delete("member.member_delete",mem_idx);
		
		
		return res;
	}
	
	
}
