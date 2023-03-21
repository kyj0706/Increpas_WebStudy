package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVo;

public class DeptDaoImpl implements DeptDao{

	//spring에서 생성된 SqlSessionTemplate객체의 사용매뉴얼을 받는다
	//Constructor Injection
	SqlSession sqlSession;
	
	public DeptDaoImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}




	@Override
	public List<DeptVo> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("dept.dept_list");
	}

}
