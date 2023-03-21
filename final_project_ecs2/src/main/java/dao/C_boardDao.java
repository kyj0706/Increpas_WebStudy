package dao;

import java.util.List;
import java.util.Map;

import vo.C_boardVo;

public interface C_boardDao {

	List<C_boardVo>  selectList();
	List<C_boardVo>  selectList(Map map);
	C_boardVo        selectOne(int c_b_idx);
	int            selectRowTotal();
	int            selectRowTotal(Map map);
	
	int insert(C_boardVo vo); //새글쓰기
	
	//답글쓰기
	int reply(C_boardVo vo);
	int update_step(C_boardVo vo);
	
	int update_readhit(int c_b_idx); //조회수증가
	int update(C_boardVo vo);
	int delete(int c_b_idx);
	
	
}
