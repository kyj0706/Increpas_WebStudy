package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.C_boardVo;

public class C_boardDaoImpl implements C_boardDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<C_boardVo> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("c_board.c_board_list");
	}

	@Override
	public List<C_boardVo> selectList(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("c_board.c_board_condition_list",map);
	}

	@Override
	public C_boardVo selectOne(int c_b_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("c_board.c_board_one", c_b_idx);
	}

	@Override
	public int insert(C_boardVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("c_board.c_board_insert", vo);
	}

	@Override
	public int reply(C_boardVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("c_board.c_board_reply", vo);
	}

	@Override
	public int update_step(C_boardVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("c_board.c_board_update_step", vo);
	}

	@Override
	public int update_readhit(int c_b_idx) {
		// TODO Auto-generated method stub
		return sqlSession.update("c_board.c_board_update_readhit", c_b_idx);
	}

	
	@Override
	public int update(C_boardVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("c_board.c_board_update", vo);
	}
	

	@Override
	public int delete(int c_b_idx) {
		// TODO Auto-generated method stub
		return sqlSession.update("c_board.c_board_update_use", c_b_idx);
	}

	@Override
	public int selectRowTotal() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("c_board.c_board_row_total");
	}

	@Override
	public int selectRowTotal(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("c_board.c_board_condition_row_total",map);
	}

}


