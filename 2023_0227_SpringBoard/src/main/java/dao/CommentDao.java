package dao;

import java.util.List;
import java.util.Map;

import vo.CommentVo;

public interface CommentDao {
	
	//댓글 전체리스트
	List<CommentVo> selectList(int b_idx);
	List<CommentVo> selectList(Map map);
	
	int 			selectRowTotal(Map map);
	
	//댓글추가
	int 			insert(CommentVo vo);
	
	//댓글삭제
	int				delete(int cmt_idx);
	
	
	
}
