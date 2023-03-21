package com.example.teamproject.Service;

import java.util.ArrayList;
import java.util.Map;

import com.example.teamproject.Vo.NoticeBoardImgVo;
import com.example.teamproject.Vo.NoticeBoardVo;

public interface NoticeBoardService {

	Map<String, Object> selectNoticeBoardList(String searchCategory, String sportsCategory, String searchWord,
			int page);

	void noticeBoardInsert(NoticeBoardVo noticeBoardVo, ArrayList<NoticeBoardImgVo> imgList);

	Map<String, Object> selectNoticeView(int n_num);

	void noticeBoardDelete(int n_num);

	Map<String, Object> selectNoticeBoardModifyView(int n_num);

	void noticeBoardModify(NoticeBoardVo noticeBoardVo, ArrayList<NoticeBoardImgVo> imgList);

}
