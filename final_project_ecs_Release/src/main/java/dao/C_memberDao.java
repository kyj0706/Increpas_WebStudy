package dao;

import java.util.List;

import vo.C_memberVo;

public interface C_memberDao {

	//��ü��ȸ
	public List<C_memberVo> selectList();
	
	//mem_idx�� �ش�Ǵ� 1��(��)�� ����
	public C_memberVo selectOne(int c_mem_idx);	
	
	//mem_id�� �ش�Ǵ� 1��(��)�� ����
	public C_memberVo selectOne(String c_mem_id);

	//�߰�
	public int insert(C_memberVo vo);
	
	int modify(C_memberVo vo);
	
	//public int update(C_memberVo vo);

	public int delete(int c_mem_idx);
	
}
