package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVo;

public class MemberDaoImpl implements MemberDao{

	SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	//전체조회
	public List<MemberVo> selectList() {

		return sqlSession.selectList("member.member_list");
	}
	
	
	//mem_idx에 해당되는 1명(건)의 정보
	public MemberVo selectOne(int mem_idx) {
	
		return sqlSession.selectOne("member.member_one_idx", mem_idx);
	}
	
	
	//mem_id에 해당되는 1명(건)의 정보
	public MemberVo selectOne(String mem_id) {
	
		return sqlSession.selectOne("member.member_one_id", mem_id);
	}

	public int insert(MemberVo vo) {
		// TODO Auto-generated method stub
			
		return sqlSession.insert("member.member_insert", vo);
	}

	public int update(MemberVo vo) {
		// TODO Auto-generated method stub
			
		return sqlSession.update("member.member_update", vo);
	}

	public int delete(int mem_idx) {
		// TODO Auto-generated method stub
				
		return sqlSession.delete("member.member_delete", mem_idx);
	}
	
	
	
}
