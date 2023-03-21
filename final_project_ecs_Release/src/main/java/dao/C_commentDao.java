package dao;

import java.util.List;
import java.util.Map;

import vo.C_commentVo;

public interface C_commentDao {

	List<C_commentVo> selectList(int c_b_idx);
	List<C_commentVo> selectList(Map map);
	
	int             insert(C_commentVo vo);
	
	int             delete(int c_cmt_idx);
}
