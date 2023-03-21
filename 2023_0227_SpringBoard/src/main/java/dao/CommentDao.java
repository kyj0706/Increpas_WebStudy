package dao;

import java.util.List;
import java.util.Map;

import vo.CommentVo;

public interface CommentDao {
	
	//��� ��ü����Ʈ
	List<CommentVo> selectList(int b_idx);
	List<CommentVo> selectList(Map map);
	
	int 			selectRowTotal(Map map);
	
	//����߰�
	int 			insert(CommentVo vo);
	
	//��ۻ���
	int				delete(int cmt_idx);
	
	
	
}
