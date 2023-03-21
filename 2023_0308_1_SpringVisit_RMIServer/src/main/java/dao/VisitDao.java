package dao;

import java.util.List;
import java.util.Map;

import vo.VisitVo;

public interface VisitDao {
	
	
	//���� ��ȸ
	public List<VisitVo> selectList();
	public List<VisitVo> selectList(Map<String, String> map);
	//idx�� �ش�Ǵ� �Խù� 1�� ��ȸ
	public VisitVo selectOne(int idx);
	//�߰��ϱ�
	public int insert(VisitVo vo);
	public int delete(int idx);
	public int update(VisitVo vo);	
		
	
	
}
