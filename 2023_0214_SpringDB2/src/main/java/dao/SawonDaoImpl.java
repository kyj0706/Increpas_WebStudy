package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.SawonVo;

public class SawonDaoImpl implements SawonDao {

	
	SqlSession sqlSession;
	
	public SawonDaoImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
	

	@Override
	public List<SawonVo> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("sawon.sawon_list");
	}
	
	
	
	
	
	
	
}
