package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVo;

public class DeptDaoImpl implements DeptDao{

	//spring���� ������ SqlSessionTemplate��ü�� ���Ŵ����� �޴´�
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
