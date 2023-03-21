package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.C_boardVo;
import vo.C_memberVo;
import vo.ChargingVo;

public class AdminDaoImpl implements AdminDao {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//회원리스트
	@Override
	public List<C_memberVo> adminCmemberList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("admin.c_member_list");
	}


	//게시판리스트
	@Override
	public List<C_boardVo> adminCboardList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("admin.c_borde_list");
	}

	//충전소리스트
	@Override
	public ArrayList<ChargingVo> adminCharginList() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
