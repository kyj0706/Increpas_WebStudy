package com.example.teamproject.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamproject.Vo.NoticeBoardImgVo;
import com.example.teamproject.Vo.NoticeBoardVo;

@Mapper
public interface NoticeBoardMapper {

	int selectNoticeBoardCount(String searchCategory, String sportsCategory, String searchWord);

	ArrayList<NoticeBoardVo> selectNoticeBoardList(String searchCategory, String sportsCategory, String searchWord,
			int startRow, int endRow);

	void noticeBoardInsert(NoticeBoardVo noticeBoardVo);

	void noticeBoardImgInsert(int n_num, String fileName);

	void updateNoticeBoardHit(int n_num);

	NoticeBoardVo selectNoticeBoardView(int n_num);

	ArrayList<NoticeBoardImgVo> selectNoticeBoardImg(int n_num);

	NoticeBoardVo selectNextView(int n_num);

	NoticeBoardVo selectPreView(int n_num);

	void noticeBoardDelete(int n_num);

	void noticeBoardDeleteImg(int n_num);

	void noticeBoardModify(NoticeBoardVo noticeBoardVo);

	void noticeBoardImgModify(String fileName, int img_no);

}
