package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.PhotoVo;

public class PhotoDao {

	SqlSessionFactory factory;
	//single-ton pattern
	static PhotoDao single = null;

	public static PhotoDao getInstance() {
		//�������� �ʾ����� �����ض�
		if (single == null)
			single = new PhotoDao();

		return single;
	}

	//��? : �ܺο��� new PhotoDao()�������� ���ϵ���
	private PhotoDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public List<PhotoVo> selectList() {

		List<PhotoVo> list = new ArrayList<PhotoVo>();

		//1.Mybatis�۾���ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2.�۾�����                  namespace.mapper_id
		list = sqlSession.selectList("photo.photo_list");
		
		//3.�۾��� �����۾�(�ݱ�):��������� conn.close() �����Ѵ�
		sqlSession.close();
		return list;
	}
	
	public PhotoVo selectOne(int p_idx) {

		PhotoVo vo = null;
		//1.Mybatis�۾���ü ������
		SqlSession  sqlSession = factory.openSession();
		//2.�۾�����                 mapper_id        parameter  
		vo = sqlSession.selectOne("photo.photo_one" , p_idx);		
		//3.�ݱ�
		sqlSession.close();
		
		return vo;
	}
	
	public int insert(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		//1.Mybatis�۾���ü ������
				SqlSession sqlSession = factory.openSession(true);
				
				//2.�۾�����                   mapper_id      ,parameter
				res = sqlSession.insert("photo.photo_insert",vo);
				
				//3.�۾��� �����۾�(�ݱ�):��������� conn.close() �����Ѵ�
				sqlSession.close();
				return res;
	}

	public int update(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		//1.Mybatis�۾���ü ������
		SqlSession sqlSession = factory.openSession(true);
		
		//2.�۾�����                   mapper_id      ,parameter
		res = sqlSession.update("photo.photo_content_update",vo);
		
		//3.�۾��� �����۾�(�ݱ�):��������� conn.close() �����Ѵ�
		sqlSession.close();
		return res;
	}

	public int delete(int p_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		SqlSession sqlSession = factory.openSession(true);
		
		//2.�۾�����                   mapper_id      ,parameter
		res = sqlSession.delete("photo.photo_delete",p_idx);
		
		//3.�۾��� �����۾�(�ݱ�):��������� conn.close() �����Ѵ�
		sqlSession.close();
		return res;
	}

	public int update_filename(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		//1.Mybatis�۾���ü ������
		SqlSession sqlSession = factory.openSession(true);
		
		//2.�۾�����                   mapper_id      ,parameter
		res = sqlSession.update("photo.photo_update",vo);
		
		//3.�۾��� �����۾�(�ݱ�):��������� conn.close() �����Ѵ�
		sqlSession.close();
		return res;
	}

}
