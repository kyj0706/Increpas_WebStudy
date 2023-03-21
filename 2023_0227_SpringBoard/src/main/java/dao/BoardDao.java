package dao;

import java.util.List;
import java.util.Map;

import vo.BoardVo;

public interface BoardDao {
	
	//전체조회
	List<BoardVo> 		selectList();
	//조건별조회
	List<BoardVo> 		selectList(Map map);
	//1건조회
	BoardVo 	  		selectOne(int b_idx);
	
	//전체 게시물수
	int 				selectRowTotal();
	//게시물 검색 조건 수
	int					selectRowTotal(Map map);
	
	
	//새글쓰기
	int insert(BoardVo vo);
	//답글쓰기
	int reply(BoardVo vo);
	//답글증가
	int update_step(BoardVo vo);
	
	//조회수증가
	int update_readhit(int b_idx);
	
	
	//수정하기
	int update(BoardVo vo);
	
	//삭제(실제삭제는 아니다 update 처리 use y -> n 으로
	int delete(int b_idx);

}
