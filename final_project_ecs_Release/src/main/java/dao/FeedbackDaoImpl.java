	package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.FeedbackVo;

public class FeedbackDaoImpl implements FeedbackDao{

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	//��ü��ȸ
	@Override
	public List<FeedbackVo> selectList() {

		return sqlSession.selectList("feedback.feedback_list");
	}
	
	@Override
	public List<FeedbackVo> selectList(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("feedback.feedback_condition_list",map);
	}
	
	@Override
	public List<FeedbackVo> selectList2(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("feedback.feedback_star_avg",map);
	}
	
	@Override
	public String selectOne4(Map map) {
		return sqlSession.selectOne("feedback.feedback_stasdar_avg", map);
	}
	
	@Override
	public FeedbackVo selectOne1(int f_idx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//mem_id�� �ش�Ǵ� 1��(��)�� ����
	@Override
	public FeedbackVo selectOne2(int c_mem_idx) {
	
		return sqlSession.selectOne("feedback.feedback_one_id", c_mem_idx);
	}
	
	//mem_idx�� �ش�Ǵ� 1��(��)�� ����
	@Override
	public FeedbackVo selectOne3(String statNm) {
		return sqlSession.selectOne("feedback.feedback_stasdar_avg", statNm);
	}

	@Override
	public int insert(FeedbackVo vo) {
		// TODO Auto-generated method stub
			
		return sqlSession.insert("feedback.feedback_insert", vo);
	}

	@Override
	public int selectRowTotal() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("feedback.feedbackrow_total");
	}

	@Override
	public int selectRowTotal(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("feedback.feedback_condition_row_total",map);
	}


	
}