package dao;

import java.util.List;
import java.util.Map;

import vo.VisitVo;

public interface VisitDao {
	
	
	//방명록 조회
	public List<VisitVo> selectList();
	public List<VisitVo> selectList(Map<String, String> map);
	//idx에 해당되는 게시물 1건 조회
	public VisitVo selectOne(int idx);
	//추가하기
	public int insert(VisitVo vo);
	public int delete(int idx);
	public int update(VisitVo vo);	
		
	
	
}
