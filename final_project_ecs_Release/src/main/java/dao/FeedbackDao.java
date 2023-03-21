package dao;

import java.util.List;
import java.util.Map;

import vo.C_boardVo;
import vo.C_memberVo;
import vo.FeedbackVo;

public interface FeedbackDao {

	//��ü��ȸ
	List<FeedbackVo> selectList();
	List<FeedbackVo> selectList(Map map);
	List<FeedbackVo> selectList2(Map map);
	
	//mem_idx�� �ش�Ǵ� 1��(��)�� ����
	public FeedbackVo selectOne1(int f_idx);	
	
	public String selectOne4(Map map);
	
	//mem_id�� �ش�Ǵ� 1��(��)�� ����
	public FeedbackVo selectOne2(int c_mem_idx);
	public FeedbackVo selectOne3(String statNm);

	public int insert(FeedbackVo vo);
	int            selectRowTotal();
	int            selectRowTotal(Map map);

	
}
