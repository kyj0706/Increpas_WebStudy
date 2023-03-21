package com.example.teamproject.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.Mapper.FreeBoardMapper;
import com.example.teamproject.Vo.FreeBoardMemberCommentVo;
import com.example.teamproject.Vo.FreeBoardMemberImgVo;
import com.example.teamproject.Vo.FreeBoardMemberVo;
import com.example.teamproject.Vo.FreeBoardSellerCommentVo;
import com.example.teamproject.Vo.FreeBoardSellerImgVo;
import com.example.teamproject.Vo.FreeBoardSellerVo;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {
	@Autowired
	FreeBoardMapper freeBoardMapper;

//	자유 게시판 (회원)=====================================================================================================================
	// 게시글 쓰기
	@Override
	public void freeBoardMemberInsert(FreeBoardMemberVo freeBoardMemberVo, ArrayList<FreeBoardMemberImgVo> imgList) {
		freeBoardMapper.freeBoardMemberInsert(freeBoardMemberVo);
		int fbm_num = freeBoardMemberVo.getFbm_num();
		if (imgList.size() != 0) {
			for (int i = 0; i < imgList.size(); i++) {
				String fileName = imgList.get(i).getImg_name();
				freeBoardMapper.freeBoardMemberImgInsert(fbm_num, fileName);
			}

		}
	}

	// 게시판 가져오기
	@Override
	public Map<String, Object> selectFreeMemberBoardList(String searchCategory, String sportsCategory,
			String searchWord, int page) {
		Map<String, Object> map = new HashMap<String, Object>();

		int limit = 10;
		int numLimit = 10;
		int listCount = freeBoardMapper.selectFreeBoardMemberListCount(searchCategory, sportsCategory, searchWord);
		int startPage = (((int) ((double) page / numLimit + 0.99)) - 1) * numLimit + 1;
		int endPage = startPage + numLimit - 1;
		int maxPage = ((int) ((double) listCount / limit + 0.99));
		if (endPage > maxPage)
			endPage = maxPage;
		int startRow = (page - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println("count" + listCount);
		System.out.println("startPage" + startPage);
		System.out.println("endPage" + endPage);
		System.out.println("maxPage" + maxPage);
		System.out.println("startRow" + startRow);
		System.out.println("endRow" + endRow);
		ArrayList<FreeBoardMemberVo> list = freeBoardMapper.selectFreeBoardMemberList(searchCategory, sportsCategory,
				searchWord, startRow, endRow);
		
		System.out.println("사이즈");
		System.out.println(list.size());
		
		map.put("page", page);
		map.put("searchCategory", searchCategory);
		map.put("sportsCategory", sportsCategory);
		map.put("searchWord", searchWord);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("maxPage", maxPage);
		map.put("list", list);
		return map;
	}

//	뷰페이지 가져오기
	@Override
	public Map<String, Object> selectFreeMemberView(int fbm_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 게시글 조회수 1씩증가
		freeBoardMapper.updateFreeBoardMemberHit(fbm_num);
		// 게시글 및 이미지 가져오기
		FreeBoardMemberVo freeBoardMemberVo = freeBoardMapper.selectFreeBoardMemberView(fbm_num);
		ArrayList<FreeBoardMemberImgVo> imgList = freeBoardMapper.selectFreeBoardMemberImg(fbm_num);

		if (imgList.size() != 0) {
			map.put("imgList", imgList);
		}
		// 게시글 이전글 글번호 뽑아오기
		FreeBoardMemberVo nextView = freeBoardMapper.selectNextView(fbm_num);
		// 게시글 다음글 글번호 뽑아오기
		FreeBoardMemberVo preView = freeBoardMapper.selectPreView(fbm_num);
		// 게시글 댓글전체 가져오기
		ArrayList<FreeBoardMemberCommentVo> commentList = freeBoardMapper.selectAllMemberComment(fbm_num);
		// 게시글 댓글전체 개수 가져오기
		int freeBoardMemberCommentCount = freeBoardMapper.selectAllMemberCommentCount(fbm_num);
		map.put("freeBoardMemberVo", freeBoardMemberVo);
		map.put("nextView", nextView);
		map.put("preView", preView);
		map.put("commentList", commentList);
		map.put("freeBoardMemberCommentCount", freeBoardMemberCommentCount);
		return map;
	}

//	게시글지우기
	@Override
	public void freeBoardMemberDelete(int fbm_num) {
		freeBoardMapper.freeBoardMemberDelete(fbm_num);
		freeBoardMapper.freeBoardMemberDeleteImg(fbm_num);
	}

	// 수정페이지 오픈

	@Override
	public Map<String, Object> selectFreeBoardMemberModifyView(int fbm_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		FreeBoardMemberVo freeBoardMemberVo = freeBoardMapper.selectFreeBoardMemberView(fbm_num);
		ArrayList<FreeBoardMemberImgVo> imgList = freeBoardMapper.selectFreeBoardMemberImg(fbm_num);

		if (imgList.size() != 0) {
			map.put("imgList", imgList);
		}

		map.put("freeBoardMemberVo", freeBoardMemberVo);
		return map;
	}

//	수정하기
	@Override
	public void freeBoardMemberModify(FreeBoardMemberVo freeBoardMemberVo, ArrayList<FreeBoardMemberImgVo> imgList) {
		System.out.println(freeBoardMemberVo);
		freeBoardMapper.freeBoardMemberModify(freeBoardMemberVo);
		int fbm_num = freeBoardMemberVo.getFbm_num();
		ArrayList<FreeBoardMemberImgVo> imgOriginalList = freeBoardMapper.selectFreeBoardMemberImg(fbm_num);
		if (imgList.size() != 0) {
			for (int i = 0; i < imgList.size(); i++) {
				String fileName = imgList.get(i).getImg_name();
				if(fileName != null) {
					int img_no = imgOriginalList.get(i).getImg_no();
					freeBoardMapper.freeBoardImgModify(fileName,img_no);
				}
			}

		}
		for(int i= 0; i< imgOriginalList.size(); i++) {
			System.out.println(imgOriginalList.get(i).getImg_name());
		}
	}

	// 게시글 댓글달기
	@Override
	public Map<String, Object> freeBoardMemberCommentWrite(FreeBoardMemberCommentVo freeBoardMemberCommentVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		freeBoardMapper.freeBoardMemberCommentWrite(freeBoardMemberCommentVo);
		FreeBoardMemberCommentVo fmbCommentVo = freeBoardMapper
				.selectOneMemberComment(freeBoardMemberCommentVo.getC_no());
		int freeBoardMemberCommentCount = freeBoardMapper
				.selectAllMemberCommentCount(freeBoardMemberCommentVo.getFbm_num());
		map.put("fmbCommentVo", fmbCommentVo);
		map.put("freeBoardMemberCommentCount", freeBoardMemberCommentCount);
		return map;
	}

	@Override
	public Map<String, Object> freeBoardMemberCommentModify(FreeBoardMemberCommentVo freeBoardMemberCommentVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		freeBoardMapper.freeBoardMemberCommentModify(freeBoardMemberCommentVo);
		FreeBoardMemberCommentVo fbmCommentVo = freeBoardMapper
				.selectOneMemberComment(freeBoardMemberCommentVo.getC_no());
		map.put("fbmCommentVo", fbmCommentVo);
		return map;
	}

	@Override
	public int freeBoardMemberCommentDelete(int c_no, int fbm_num) {
		freeBoardMapper.freeBoardMemberCommentDelete(c_no);
		int commentCount = freeBoardMapper.selectAllMemberCommentCount(fbm_num);
		return commentCount;
	}
//	자유 게시판 (판매자)=====================================================================================================================

	@Override
	public Map<String, Object> selectFreeSellerBoardList(String searchCategory, String sportsCategory,
			String searchWord, int page) {
		Map<String, Object> map = new HashMap<String, Object>();

		int limit = 10;
		int numLimit = 10;
		int listCount = freeBoardMapper.selectFreeBoardSellerListCount(searchCategory, sportsCategory, searchWord);
		int startPage = (((int) ((double) page / numLimit + 0.99)) - 1) * numLimit + 1;
		int endPage = startPage + numLimit - 1;
		int maxPage = ((int) ((double) listCount / limit + 0.99));
		if (endPage > maxPage)
			endPage = maxPage;
		int startRow = (page - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		ArrayList<FreeBoardSellerVo> list = freeBoardMapper.selectFreeBoardSellerList(searchCategory, sportsCategory,
				searchWord, startRow, endRow);
		System.out.println("사이즈");
		System.out.println(list.size());
		map.put("page", page);
		map.put("searchCategory", searchCategory);
		map.put("sportsCategory", sportsCategory);
		map.put("searchWord", searchWord);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("maxPage", maxPage);
		map.put("list", list);
		return map;
	}
//	게시글 쓰기
	@Override
	public void freeBoardSellerInsert(FreeBoardSellerVo freeBoardSellerVo, ArrayList<FreeBoardSellerImgVo> imgList) {
		freeBoardMapper.freeBoardSellerInsert(freeBoardSellerVo);
		int fbs_num = freeBoardSellerVo.getFbs_num();
		if (imgList.size() != 0) {
			for (int i = 0; i < imgList.size(); i++) {
				String fileName = imgList.get(i).getImg_name();
				freeBoardMapper.freeBoardSellerImgInsert(fbs_num, fileName);
			}

		}
		
	}
//	게시글 1개 가져오기
	@Override
	public Map<String, Object> selectFreeSellerView(int fbs_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 게시글 조회수 1씩증가
		freeBoardMapper.updateFreeBoardSellerHit(fbs_num);
		// 게시글 및 이미지 가져오기
		FreeBoardSellerVo freeBoardSellerVo = freeBoardMapper.selectFreeBoardSellerView(fbs_num);
		ArrayList<FreeBoardSellerImgVo> imgList = freeBoardMapper.selectFreeBoardSellerImg(fbs_num);

		if (imgList.size() != 0) {
			map.put("imgList", imgList);
		}
		// 게시글 이전글 글번호 뽑아오기
		FreeBoardSellerVo nextView = freeBoardMapper.selectNextSellerView(fbs_num);
		// 게시글 다음글 글번호 뽑아오기
		FreeBoardSellerVo preView = freeBoardMapper.selectPreSellerView(fbs_num);
		// 게시글 댓글전체 가져오기
		ArrayList<FreeBoardSellerCommentVo> commentList = freeBoardMapper.selectAllSellerComment(fbs_num);
		// 게시글 댓글전체 개수 가져오기
		int freeBoardSellerCommentCount = freeBoardMapper.selectAllSellerCommentCount(fbs_num);
		map.put("freeBoardSellerVo", freeBoardSellerVo);
		map.put("nextView", nextView);
		map.put("preView", preView);
		map.put("commentList", commentList);
		map.put("freeBoardSellerCommentCount", freeBoardSellerCommentCount);
		return map;
	}

	@Override
	public void freeBoardSellerDelete(int fbs_num) {
		freeBoardMapper.freeBoardSellerDelete(fbs_num);
		freeBoardMapper.freeBoardSellerDeleteImg(fbs_num);

	}

	@Override
	public Map<String, Object> freeBoardSellerCommentWrite(FreeBoardSellerCommentVo freeBoardSellerCommentVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		freeBoardMapper.freeBoardSellerCommentWrite(freeBoardSellerCommentVo);
		FreeBoardSellerCommentVo fmsCommentVo = freeBoardMapper
				.selectOneSellerComment(freeBoardSellerCommentVo.getC_no());
		int freeBoardSellerCommentCount = freeBoardMapper
				.selectAllSellerCommentCount(freeBoardSellerCommentVo.getFbs_num());
		map.put("fmsCommentVo", fmsCommentVo);
		map.put("freeBoardSellerCommentCount", freeBoardSellerCommentCount);
		return map;
	}

	@Override
	public Map<String, Object> freeBoardSellerCommentModify(FreeBoardSellerCommentVo freeBoardSellerCommentVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		freeBoardMapper.freeBoardSellerCommentModify(freeBoardSellerCommentVo);
		FreeBoardSellerCommentVo fmsCommentVo = freeBoardMapper
				.selectOneSellerComment(freeBoardSellerCommentVo.getC_no());
		map.put("fmsCommentVo", fmsCommentVo);
		return map;
	}

	@Override
	public int freeBoardSellerCommentDelete(int c_no, int fbs_num) {
		freeBoardMapper.freeBoardSellerCommentDelete(c_no);
		int commentCount = freeBoardMapper.selectAllSellerCommentCount(fbs_num);
		return commentCount;
	}

	@Override
	public Map<String, Object> selectFreeBoardSellerModifyView(int fbs_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		FreeBoardSellerVo freeBoardSellerVo = freeBoardMapper.selectFreeBoardSellerView(fbs_num);
		ArrayList<FreeBoardSellerImgVo> imgList = freeBoardMapper.selectFreeBoardSellerImg(fbs_num);

		if (imgList.size() != 0) {
			map.put("imgList", imgList);
		}

		map.put("freeBoardSellerVo", freeBoardSellerVo);
		return map;
	}

	@Override
	public void freeBoardSellerModify(FreeBoardSellerVo freeBoardSellerVo, ArrayList<FreeBoardSellerImgVo> imgList) {
		freeBoardMapper.freeBoardSellerModify(freeBoardSellerVo);
		int fbs_num = freeBoardSellerVo.getFbs_num();
		ArrayList<FreeBoardSellerImgVo> imgOriginalList = freeBoardMapper.selectFreeBoardSellerImg(fbs_num);
		if (imgList.size() != 0) {
			for (int i = 0; i < imgList.size(); i++) {
				String fileName = imgList.get(i).getImg_name();
				if(fileName != null) {
					int img_no = imgOriginalList.get(i).getImg_no();
					freeBoardMapper.freeBoardSellerImgModify(fileName,img_no);
				}
			}

		}
		for(int i= 0; i< imgOriginalList.size(); i++) {
			System.out.println(imgOriginalList.get(i).getImg_name());
		}
		
	}

	

}
