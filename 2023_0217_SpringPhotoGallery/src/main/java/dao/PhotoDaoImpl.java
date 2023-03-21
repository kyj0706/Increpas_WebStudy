package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.PhotoVo;

public class PhotoDaoImpl implements PhotoDao{

	
	SqlSession sqlSession;//SqlSessionTemplate(1.openSession 2.fetch 3.close)
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	public List<PhotoVo> selectList() {
		
		return sqlSession.selectList("photo.photo_list");
	}
	
	public PhotoVo selectOne(int p_idx) {
				
		return sqlSession.selectOne("photo.photo_one", p_idx);
	}
	
	public int insert(PhotoVo vo) {
		// TODO Auto-generated method stub
				
		return sqlSession.insert("photo.photo_insert", vo);
	}

	public int update(PhotoVo vo) {
		// TODO Auto-generated method stub
				
		return sqlSession.update("photo.photo_update", vo);
	}

	public int delete(int p_idx) {
		// TODO Auto-generated method stub
					
		return sqlSession.delete("photo.photo_delete", p_idx);
	}

	public int update_filename(PhotoVo vo) {
		// TODO Auto-generated method stub
		
		return sqlSession.update("photo.photo_update_filename", vo);
	}

}
