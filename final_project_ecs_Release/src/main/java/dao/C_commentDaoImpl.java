package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.C_commentVo;

public class C_commentDaoImpl implements C_commentDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<C_commentVo> selectList(int c_b_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("c_comment.c_comment_list", c_b_idx);
	}

	@Override
	public List<C_commentVo> selectList(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(C_commentVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("c_comment.c_comment_insert", vo);
	}

	@Override
	public int delete(int c_cmt_idx) {
		// TODO Auto-generated method stub
		return sqlSession.delete("c_comment.c_comment_delete", c_cmt_idx);
	}


	
}
