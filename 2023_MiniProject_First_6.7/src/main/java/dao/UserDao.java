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
		//�������� �ʾ����� �����ض�
		if (single == null)
			single = new UserDao();

		return single;
	}

	//��? : �ܺο��� new UserDao()�������� ���ϵ���
	private UserDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//��ü��ȸ
	public List<UserVo> selectList() {

		List<UserVo> list = null;
		System.out.println("user_list_dao");
		
		//1.SqlSession���
		SqlSession sqlSession = factory.openSession();
		
		System.out.println(sqlSession);
		//2.�۾�����
		list = sqlSession.selectList("user.user_list");
		
		System.out.println("�����̰�"+sqlSession.selectList("user.user_list"));
		
		
		//3.�ݱ�
		sqlSession.close();
		
		return list;
	}
	
	//user_idx 1��(��)�� ����
	public UserVo selectOne(int user_idx) {

		UserVo vo = null;
		
		//1.SqlSession���
		SqlSession sqlSession = factory.openSession();
		//2.�۾�����
		vo = sqlSession.selectOne("user.user_one_idx", user_idx);
		
		//3.�ݱ�
		sqlSession.close();
		return vo;
	}
	
	//user_id�� �ش�Ǵ� 1��(��)�� ����
	public UserVo selectOne(String user_id) {
		
		UserVo vo = null;
		//1.SqlSession���
		SqlSession sqlSession = factory.openSession();
		//2.�۾�����
		vo = sqlSession.selectOne("user.user_one_id", user_id);
		
		//3.�ݱ�
		sqlSession.close();
		return vo;
	}
	
	public int insert(UserVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		//1.SqlSession���
		SqlSession sqlSession = factory.openSession(true);
		System.out.println("insertDao"+sqlSession);
		//2.�۾�����
		res = sqlSession.insert("user.user_insert", vo);
		//3.�ݱ�
		System.out.println("insertDao"+res);
		sqlSession.close();
		
		return res;
	}
	
	public int update(UserVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		//1.SqlSession���
		SqlSession sqlSession = factory.openSession(true);
		//2.�۾�����
		res = sqlSession.update("user.user_update", vo);
		//3.�ݱ�
		sqlSession.close();
		
		return res;
	}
	
	public int delete(int user_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		//1.SqlSession���
		SqlSession sqlSession = factory.openSession(true);
		//2.�۾�����
		res = sqlSession.delete("user.user_delete", user_idx);
		//3.�ݱ�
		sqlSession.close();
				
		return res;
	}

}
