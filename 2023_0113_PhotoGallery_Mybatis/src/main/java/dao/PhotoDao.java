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
		//생성되지 않았으면 생성해라
		if (single == null)
			single = new PhotoDao();

		return single;
	}

	//왜? : 외부에서 new PhotoDao()생성하지 못하도록
	private PhotoDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public List<PhotoVo> selectList() {

		List<PhotoVo> list = new ArrayList<PhotoVo>();

		//1.Mybatis작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행                  namespace.mapper_id
		list = sqlSession.selectList("photo.photo_list");
		
		//3.작업후 종료작업(닫기):결과적으로 conn.close() 동일한다
		sqlSession.close();
		return list;
	}
	
	public PhotoVo selectOne(int p_idx) {

		PhotoVo vo = null;
		//1.Mybatis작업객체 얻어오기
		SqlSession  sqlSession = factory.openSession();
		//2.작업수행                 mapper_id        parameter  
		vo = sqlSession.selectOne("photo.photo_one" , p_idx);		
		//3.닫기
		sqlSession.close();
		
		return vo;
	}
	
	public int insert(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		//1.Mybatis작업객체 얻어오기
				SqlSession sqlSession = factory.openSession(true);
				
				//2.작업수행                   mapper_id      ,parameter
				res = sqlSession.insert("photo.photo_insert",vo);
				
				//3.작업후 종료작업(닫기):결과적으로 conn.close() 동일한다
				sqlSession.close();
				return res;
	}

	public int update(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		//1.Mybatis작업객체 얻어오기
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행                   mapper_id      ,parameter
		res = sqlSession.update("photo.photo_content_update",vo);
		
		//3.작업후 종료작업(닫기):결과적으로 conn.close() 동일한다
		sqlSession.close();
		return res;
	}

	public int delete(int p_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행                   mapper_id      ,parameter
		res = sqlSession.delete("photo.photo_delete",p_idx);
		
		//3.작업후 종료작업(닫기):결과적으로 conn.close() 동일한다
		sqlSession.close();
		return res;
	}

	public int update_filename(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		//1.Mybatis작업객체 얻어오기
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행                   mapper_id      ,parameter
		res = sqlSession.update("photo.photo_update",vo);
		
		//3.작업후 종료작업(닫기):결과적으로 conn.close() 동일한다
		sqlSession.close();
		return res;
	}

}
