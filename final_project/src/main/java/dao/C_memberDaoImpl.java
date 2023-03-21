package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.C_memberVo;

public class C_memberDaoImpl implements C_memberDao{

	SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	//전체조회
	public List<C_memberVo> selectList() {

		return sqlSession.selectList("c_member.c_member_list");
	}
	
	
	//mem_idx에 해당되는 1명(건)의 정보
	public C_memberVo selectOne(int c_mem_idx) {
	
		return sqlSession.selectOne("c_member.c_member_one_idx", c_mem_idx);
	}
	
	
	//mem_id에 해당되는 1명(건)의 정보
	public C_memberVo selectOne(String c_mem_id) {
	
		return sqlSession.selectOne("c_member.c_member_one_id", c_mem_id);
	}

	public int insert(C_memberVo vo) {
		// TODO Auto-generated method stub
			
		return sqlSession.insert("c_member.c_member_insert", vo);
	}

	public int update(C_memberVo vo) {
		// TODO Auto-generated method stub
			
		return sqlSession.update("c_member.c_member_update", vo);
	}

	public int delete(int c_mem_idx) {
		// TODO Auto-generated method stub
				
		return sqlSession.delete("c_member.c_member_delete", c_mem_idx);
	}



	
	
	
}
