package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.BoardVo;

public class BoardDaoImpl implements BoardDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	
	
	
	//�� ����Ʈ
	@Override
	public List<BoardVo> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("board.board_list");
	}
	
	//paging ó��
	@Override
	public List<BoardVo> selectList(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("board.board_condition_list",map);
	}
	
	//�󼼳��� ����
	@Override
	public BoardVo selectOne(int b_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.board_one",b_idx);
	}
	
	//insert
	@Override
	public int insert(BoardVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("board.board_insert", vo);
	}
	
	//���insert
	@Override
	public int reply(BoardVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("board.board_reply", vo);
	}
	
	//��ۼ���
	@Override
	public int update_step(BoardVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("board.board_update_step", vo);
	}
	
	//��ȸ��
	@Override
	public int update_readhit(int b_idx) {
		// TODO Auto-generated method stub
		return sqlSession.update("board.board_update_readhit",b_idx);
	}
	
	//�� ����
	@Override
	public int update(BoardVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("board.board_update", vo);
	}

	//�ۻ���
	@Override
	public int delete(int b_idx) {
		// TODO Auto-generated method stub
		return sqlSession.update("board.board_update_use", b_idx);
	}
	
	
	@Override
	public int selectRowTotal() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.board_row_total");
	}

	@Override
	public int selectRowTotal(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.board_condition_row_total", map);
	}

}
