package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import vo.VisitVo;

public class VisitDaoImpl implements VisitDao{

	//Setter Injection
	SqlSession sqlSession; //SqlSessionTemplate(spring) <- SqlSessionFactyBean
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	//���� ��ȸ
	public List<VisitVo> selectList() {

	    //spring��ü�� SqlSessionTemplate => 1.openSession() ->2.�۾�����->3.�ݱ�
		return sqlSession.selectList("visit.visit_list");		
		
	}
	
	public List<VisitVo> selectList(Map<String, String> map) {
		// TODO Auto-generated method stub
	
		return sqlSession.selectList("visit.visit_list_condition", map);
	}
	
	
	//idx�� �ش�Ǵ� �Խù� 1�� ��ȸ
	public VisitVo selectOne(int idx) {
		
		return sqlSession.selectOne("visit.visit_one" , idx);
	}

	//�߰��ϱ�
	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
			
		return sqlSession.insert("visit.visit_insert" ,   vo  );
		
		
	}

	public int delete(int idx) {
		// TODO Auto-generated method stub
		
		return sqlSession.delete("visit.visit_delete" ,   idx  );
	}

	public int update(VisitVo vo) {
		// TODO Auto-generated method stub
		
		return sqlSession.update("visit.visit_update" ,   vo );
	}

	
	
	
	
	
}
