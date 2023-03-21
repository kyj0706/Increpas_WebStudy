package com.example.teamproject.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.Mapper.NoriBoardMapper;
import com.example.teamproject.Vo.NoriBoardCommentVo;
import com.example.teamproject.Vo.NoriBoardImgVo;
import com.example.teamproject.Vo.NoriBoardVo;

@Service
public class NoriBoardServiceImpl implements NoriBoardService {
	@Autowired
	NoriBoardMapper noriBoardMapper;
//	게시판 불러오기
	@Override
	public Map<String, Object> selectNoriBoardList(String searchCategory, String sportsCategory, String searchWord,
			int page) {
		Map<String, Object> map = new HashMap<String, Object>();

		int limit = 10;
		int numLimit = 10;
		int listCount = noriBoardMapper.selectNoriBoardCount(searchCategory, sportsCategory, searchWord);
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
		ArrayList<NoriBoardVo> list = noriBoardMapper.selectNoriBoardList(searchCategory, sportsCategory,
				searchWord, startRow, endRow);
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
	public void noriBoardInsert(NoriBoardVo noriBoardVo, ArrayList<NoriBoardImgVo> imgList) {
		noriBoardMapper.noriBoardInsert(noriBoardVo);
		int nb_num = noriBoardVo.getNb_num();
		if (imgList.size() != 0) {
			for (int i = 0; i < imgList.size(); i++) {
				String fileName = imgList.get(i).getImg_name();
				noriBoardMapper.noriBoardImgInsert(nb_num, fileName);
			}

		}
	}
//	게시글 불러오기
	@Override
	public Map<String, Object> selectnoriBoardView(int nb_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 게시글 조회수 1씩증가
		noriBoardMapper.updateNoriBoardHit(nb_num);
		// 게시글 및 이미지 가져오기
		NoriBoardVo noriBoardVo = noriBoardMapper.selectNoriBoardView(nb_num);
		ArrayList<NoriBoardImgVo> imgList = noriBoardMapper.selectNoriBoardImg(nb_num);

		if (imgList.size() != 0) {
			map.put("imgList", imgList);
		}
		// 게시글 이전글 글번호 뽑아오기
		NoriBoardVo nextView = noriBoardMapper.selectNextView(nb_num);
		// 게시글 다음글 글번호 뽑아오기
		NoriBoardVo preView = noriBoardMapper.selectPreView(nb_num);
		// 게시글 댓글전체 가져오기
		ArrayList<NoriBoardCommentVo> commentList = noriBoardMapper.selectAllNoriBoardComment(nb_num);
		// 게시글 댓글전체 개수 가져오기
		int noriBoardCommentCount = noriBoardMapper.selectAllNoriBoardCommentCount(nb_num);
		map.put("noriBoardVo", noriBoardVo);
		map.put("nextView", nextView);
		map.put("preView", preView);
		map.put("commentList", commentList);
		map.put("noriBoardCommentCount", noriBoardCommentCount);
		return map;
	}
//	게시글 삭제
	@Override
	public void noriBoardDelete(int nb_num) {
		noriBoardMapper.noriBoardDelete(nb_num);
		noriBoardMapper.noriBoardDeleteImg(nb_num);
		
	}
//	게시글 수정 내용 가져오기	
	@Override
	public Map<String, Object> selectNoriBoardModifyView(int nb_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		NoriBoardVo noriBoardrVo = noriBoardMapper.selectNoriBoardView(nb_num);
		ArrayList<NoriBoardImgVo> imgList = noriBoardMapper.selectNoriBoardImg(nb_num);

		if (imgList.size() != 0) {
			map.put("imgList", imgList);
		}

		map.put("noriBoardrVo", noriBoardrVo);
		return map;
	}
//	게시글 수정
	@Override
	public void noriBoardModify(NoriBoardVo noriBoardVo, ArrayList<NoriBoardImgVo> imgList) {
		noriBoardMapper.noriBoardModify(noriBoardVo);
		int nb_num = noriBoardVo.getNb_num();
		ArrayList<NoriBoardImgVo> imgOriginalList = noriBoardMapper.selectNoriBoardImg(nb_num);
		if (imgList.size() != 0) {
			for (int i = 0; i < imgList.size(); i++) {
				String fileName = imgList.get(i).getImg_name();
				if(fileName != null) {
					int img_no = imgOriginalList.get(i).getImg_no();
					noriBoardMapper.noriBoardImgModify(fileName,img_no);
				}
			}

		}
		for(int i= 0; i< imgOriginalList.size(); i++) {
			System.out.println(imgOriginalList.get(i).getImg_name());
		}
		
	}
//	댓글 달기
	@Override
	public Map<String, Object> noriBoardCommentWrite(NoriBoardCommentVo noriBoardCommentVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		noriBoardMapper.noriBoardCommentWrite(noriBoardCommentVo);
		NoriBoardCommentVo nbCommentVo = noriBoardMapper.selectOneNoriComment(noriBoardCommentVo.getC_no());
		int noriBoardCommentCount = noriBoardMapper.selectAllNoriBoardCommentCount(noriBoardCommentVo.getNb_num());
		map.put("nbCommentVo", nbCommentVo);
		map.put("noriBoardCommentCount", noriBoardCommentCount);
		return map;
	}
//	댓글수정
	@Override
	public Map<String, Object> noriBoardCommentModify(NoriBoardCommentVo noriBoardCommentVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		noriBoardMapper.noriBoardCommentModify(noriBoardCommentVo);
		NoriBoardCommentVo nbCommentVo = noriBoardMapper.selectOneNoriComment(noriBoardCommentVo.getC_no());
		map.put("nbCommentVo", nbCommentVo);
		return map;
	}
//	댓글 삭제
	@Override
	public int noriBoardCommentDelete(int c_no, int nb_num) {
		noriBoardMapper.noriBoardCommentDelete(c_no);
		int commentCount = noriBoardMapper.selectAllNoriBoardCommentCount(nb_num);
		return commentCount;
	}
}
