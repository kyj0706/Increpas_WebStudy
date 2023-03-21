package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.CommentVo;

public class CommentDaoImpl implements CommentDao {

	SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<CommentVo> selectList(int b_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("comment.comment_list",b_idx);
	}

	@Override
	public List<CommentVo> selectList(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("comment.comment_condition_list",map);
	}

	@Override
	public int insert(CommentVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("comment.comment_insert",vo) ;
	}

	@Override
	public int delete(int cmt_idx) {
		// TODO Auto-generated method stub
		return sqlSession.delete("comment.comment_delete", cmt_idx);
	}

	@Override
	public int selectRowTotal(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("comment.comment_row_total",map);
	}

}
