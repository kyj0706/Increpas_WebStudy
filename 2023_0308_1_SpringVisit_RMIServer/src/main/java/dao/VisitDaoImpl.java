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

	//방명록 조회
	public List<VisitVo> selectList() {

	    //spring객체인 SqlSessionTemplate => 1.openSession() ->2.작업수행->3.닫기
		return sqlSession.selectList("visit.visit_list");		
		
	}
	
	public List<VisitVo> selectList(Map<String, String> map) {
		// TODO Auto-generated method stub
	
		return sqlSession.selectList("visit.visit_list_condition", map);
	}
	
	
	//idx에 해당되는 게시물 1건 조회
	public VisitVo selectOne(int idx) {
		
		return sqlSession.selectOne("visit.visit_one" , idx);
	}

	//추가하기
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
