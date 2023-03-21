package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.UserVo;

public class UserDao {
	
	SqlSessionFactory factory;
	
	//single-ton pattern
	static UserDao single = null;

	public static UserDao getInstance() {
		//생성되지 않았으면 생성해라
		if (single == null)
			single = new UserDao();

		return single;
	}

	//왜? : 외부에서 new UserDao()생성하지 못하도록
	private UserDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//전체조회
	public List<UserVo> selectList() {

		List<UserVo> list = null;
		System.out.println("user_list_dao");
		
		//1.SqlSession얻기
		SqlSession sqlSession = factory.openSession();
		
		System.out.println(sqlSession);
		//2.작업수행
		list = sqlSession.selectList("user.user_list");
		
		System.out.println("뭐야이거"+sqlSession.selectList("user.user_list"));
		
		
		//3.닫기
		sqlSession.close();
		
		return list;
	}
	
	//user_idx 1명(건)의 정보
	public UserVo selectOne(int user_idx) {

		UserVo vo = null;
		
		//1.SqlSession얻기
		SqlSession sqlSession = factory.openSession();
		//2.작업수행
		vo = sqlSession.selectOne("user.user_one_idx", user_idx);
		
		//3.닫기
		sqlSession.close();
		return vo;
	}
	
	//user_id에 해당되는 1명(건)의 정보
	public UserVo selectOne(String user_id) {
		
		UserVo vo = null;
		//1.SqlSession얻기
		SqlSession sqlSession = factory.openSession();
		//2.작업수행
		vo = sqlSession.selectOne("user.user_one_id", user_id);
		
		//3.닫기
		sqlSession.close();
		return vo;
	}
	
	public int insert(UserVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		//1.SqlSession얻기
		SqlSession sqlSession = factory.openSession(true);
		System.out.println("insertDao"+sqlSession);
		//2.작업수행
		res = sqlSession.insert("user.user_insert", vo);
		//3.닫기
		System.out.println("insertDao"+res);
		sqlSession.close();
		
		return res;
	}
	
	public int update(UserVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		//1.SqlSession얻기
		SqlSession sqlSession = factory.openSession(true);
		//2.작업수행
		res = sqlSession.update("user.user_update", vo);
		//3.닫기
		sqlSession.close();
		
		return res;
	}
	
	public int delete(int user_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		//1.SqlSession얻기
		SqlSession sqlSession = factory.openSession(true);
		//2.작업수행
		res = sqlSession.delete("user.user_delete", user_idx);
		//3.닫기
		sqlSession.close();
				
		return res;
	}

}
