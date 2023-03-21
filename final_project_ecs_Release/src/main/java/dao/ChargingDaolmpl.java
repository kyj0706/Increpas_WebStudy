package dao;

import org.apache.ibatis.session.SqlSession;

import vo.ChargingVo;

public class ChargingDaolmpl implements ChargingDao {

	SqlSession sqlSession;

	@Override
	public ChargingVo selectOne(String statNm) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Feedback.Feedback_one", statNm);
	}

}
