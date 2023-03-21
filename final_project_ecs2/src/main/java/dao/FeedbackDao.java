package dao;

import java.util.List;
import java.util.Map;

import vo.FeedbackVo;

public interface FeedbackDao {

	//전체조회
	public List<FeedbackVo> selectList();
	
	//mem_idx에 해당되는 1명(건)의 정보
	public FeedbackVo selectOne1(int f_idx);	
	
	//mem_id에 해당되는 1명(건)의 정보
	public FeedbackVo selectOne2(String c_mem_name);
	public FeedbackVo selectOne3(String statNm);

	public int insert(FeedbackVo vo);

	List<FeedbackVo> selectList(Map map);
	
	int            selectRowTotal();
	int            selectRowTotal(Map map);

	
}
