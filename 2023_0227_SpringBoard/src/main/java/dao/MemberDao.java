package dao;

import java.util.List;

import vo.MemberVo;

public interface MemberDao {

	//��ü��ȸ
	public List<MemberVo> selectList();
	
	//mem_idx�� �ش�Ǵ� 1��(��)�� ����
	public MemberVo selectOne(int mem_idx);	
	
	//mem_id�� �ش�Ǵ� 1��(��)�� ����
	public MemberVo selectOne(String mem_id);

	public int insert(MemberVo vo);
	
	public int update(MemberVo vo);

	public int delete(int mem_idx);
	
	
}
