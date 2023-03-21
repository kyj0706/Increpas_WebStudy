package com.example.teamproject.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.Mapper.NoticeBoardMapper;
import com.example.teamproject.Vo.NoticeBoardImgVo;
import com.example.teamproject.Vo.NoticeBoardVo;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {
	
	@Autowired
	NoticeBoardMapper noticeBoardMapper;
//	게시판가져오기
	@Override
	public Map<String, Object> selectNoticeBoardList(String searchCategory, String sportsCategory, String searchWord,
			int page) {
		Map<String, Object> map = new HashMap<String, Object>();

		int limit = 10;
		int numLimit = 10;
		int listCount = noticeBoardMapper.selectNoticeBoardCount(searchCategory, sportsCategory, searchWord);
		int startPage = (((int) ((double) page / numLimit + 0.99)) - 1) * numLimit + 1;
		int endPage = startPage + numLimit - 1;
		int maxPage = ((int)((double) listCount / limit + 0.99));
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
		ArrayList<NoticeBoardVo> list = noticeBoardMapper.selectNoticeBoardList(searchCategory, sportsCategory,
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
//	게시글작성
	@Override
	public void noticeBoardInsert(NoticeBoardVo noticeBoardVo, ArrayList<NoticeBoardImgVo> imgList) {
		noticeBoardMapper.noticeBoardInsert(noticeBoardVo);
		int n_num = noticeBoardVo.getN_num();
		if (imgList.size() != 0) {
			for (int i = 0; i < imgList.size(); i++) {
				String fileName = imgList.get(i).getImg_name();
				noticeBoardMapper.noticeBoardImgInsert(n_num, fileName);
			}

		}
	}
//	게시글 가져오기
	@Override
	public Map<String, Object> selectNoticeView(int n_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 게시글 조회수 1씩증가
		noticeBoardMapper.updateNoticeBoardHit(n_num);
		// 게시글 및 이미지 가져오기
		NoticeBoardVo noticeBoardVo = noticeBoardMapper.selectNoticeBoardView(n_num);
		ArrayList<NoticeBoardImgVo> imgList = noticeBoardMapper.selectNoticeBoardImg(n_num);

		if (imgList.size() != 0) {
			map.put("imgList", imgList);
		}
		// 게시글 이전글 글번호 뽑아오기
		NoticeBoardVo nextView = noticeBoardMapper.selectNextView(n_num);
		// 게시글 다음글 글번호 뽑아오기
		NoticeBoardVo preView = noticeBoardMapper.selectPreView(n_num);
		map.put("noticeBoardVo", noticeBoardVo);
		map.put("nextView", nextView);
		map.put("preView", preView);
		return map;
	}
//	게시글삭제
	@Override
	public void noticeBoardDelete(int n_num) {
		noticeBoardMapper.noticeBoardDelete(n_num);
		noticeBoardMapper.noticeBoardDeleteImg(n_num);
		
	}
//	게시글 수정가져오기
	@Override
	public Map<String, Object> selectNoticeBoardModifyView(int n_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		NoticeBoardVo noticeBoardrVo = noticeBoardMapper.selectNoticeBoardView(n_num);
		ArrayList<NoticeBoardImgVo> imgList = noticeBoardMapper.selectNoticeBoardImg(n_num);

		if (imgList.size() != 0) {
			map.put("imgList", imgList);
		}

		map.put("noticeBoardrVo", noticeBoardrVo);
		return map;
	}
//	게시글 수정
	@Override
	public void noticeBoardModify(NoticeBoardVo noticeBoardVo, ArrayList<NoticeBoardImgVo> imgList) {
		noticeBoardMapper.noticeBoardModify(noticeBoardVo);
		int n_num = noticeBoardVo.getN_num();
		ArrayList<NoticeBoardImgVo> imgOriginalList = noticeBoardMapper.selectNoticeBoardImg(n_num);
		if (imgList.size() != 0) {
			for (int i = 0; i < imgList.size(); i++) {
				String fileName = imgList.get(i).getImg_name();
				if(fileName != null) {
					int img_no = imgOriginalList.get(i).getImg_no();
					noticeBoardMapper.noticeBoardImgModify(fileName,img_no);
				}
			}

		}
		for(int i= 0; i< imgOriginalList.size(); i++) {
			System.out.println(imgOriginalList.get(i).getImg_name());
		}
	}

}
