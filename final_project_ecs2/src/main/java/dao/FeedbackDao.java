package dao;

import java.util.List;
import java.util.Map;

import vo.FeedbackVo;

public interface FeedbackDao {

	//��ü��ȸ
	public List<FeedbackVo> selectList();
	
	//mem_idx�� �ش�Ǵ� 1��(��)�� ����
	public FeedbackVo selectOne1(int f_idx);	
	
	//mem_id�� �ش�Ǵ� 1��(��)�� ����
	public FeedbackVo selectOne2(String c_mem_name);
	public FeedbackVo selectOne3(String statNm);

	public int insert(FeedbackVo vo);

	List<FeedbackVo> selectList(Map map);
	
	int            selectRowTotal();
	int            selectRowTotal(Map map);

	
}
