package dao;

import java.util.List;

import vo.C_memberVo;

public interface C_memberDao {

	//전체조회
	public List<C_memberVo> selectList();
	
	//mem_idx에 해당되는 1명(건)의 정보
	public C_memberVo selectOne(int c_mem_idx);	
	
	//mem_id에 해당되는 1명(건)의 정보
	public C_memberVo selectOne(String c_mem_id);

	//추가
	public int insert(C_memberVo vo);
	
	int modify(C_memberVo vo);
	
	//public int update(C_memberVo vo);

	public int delete(int c_mem_idx);
	
}
