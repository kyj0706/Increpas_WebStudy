package dao;

import java.util.List;
import java.util.Map;

import vo.BoardVo;

public interface BoardDao {
	
	//��ü��ȸ
	List<BoardVo> 		selectList();
	//���Ǻ���ȸ
	List<BoardVo> 		selectList(Map map);
	//1����ȸ
	BoardVo 	  		selectOne(int b_idx);
	
	//��ü �Խù���
	int 				selectRowTotal();
	//�Խù� �˻� ���� ��
	int					selectRowTotal(Map map);
	
	
	//���۾���
	int insert(BoardVo vo);
	//��۾���
	int reply(BoardVo vo);
	//�������
	int update_step(BoardVo vo);
	
	//��ȸ������
	int update_readhit(int b_idx);
	
	
	//�����ϱ�
	int update(BoardVo vo);
	
	//����(���������� �ƴϴ� update ó�� use y -> n ����
	int delete(int b_idx);

}
