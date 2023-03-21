package com.example.teamproject.Mapper;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamproject.Vo.FreeBoardMemberCommentVo;
import com.example.teamproject.Vo.FreeBoardMemberImgVo;
import com.example.teamproject.Vo.FreeBoardMemberVo;
import com.example.teamproject.Vo.FreeBoardSellerCommentVo;
import com.example.teamproject.Vo.FreeBoardSellerImgVo;
import com.example.teamproject.Vo.FreeBoardSellerVo;

@Mapper
public interface FreeBoardMapper {

	


	int selectFreeBoardMemberListCount(String searchCategory, String sportsCategory, String searchWord);




	void freeBoardMemberInsert(FreeBoardMemberVo freeBoardMemberVo);


	void freeBoardMemberImgInsert(int fbm_num, String fileName);


	ArrayList<FreeBoardMemberVo> selectFreeBoardMemberList(String searchCategory, String sportsCategory,
			String searchWord, int startRow, int endRow);


	FreeBoardMemberVo selectFreeBoardMemberView(int fbm_num);


	ArrayList<FreeBoardMemberImgVo> selectFreeBoardMemberImg(int fbm_num);


	void freeBoardMemberDeleteImg(int fbm_num);


	void freeBoardMemberDelete(int fbm_num);


	void updateFreeBoardMemberHit(int fbm_num);




	FreeBoardMemberVo selectNextView(int fbm_num);




	FreeBoardMemberVo selectPreView(int fbm_num);




	void freeBoardMemberModify(FreeBoardMemberVo freeBoardMemberVo);




	void freeBoardMemberCommentWrite(FreeBoardMemberCommentVo freeBoardCommentVo);




	int selectAllMemberCommentCount(int f_num);




	FreeBoardMemberCommentVo selectOneMemberComment(int c_no);




	ArrayList<FreeBoardMemberCommentVo> selectAllMemberComment(int fbm_num);




	void freeBoardMemberCommentModify(FreeBoardMemberCommentVo freeBoardMemberCommentVo);




	void freeBoardMemberCommentDelete(int c_no);




	int selectFreeBoardSellerListCount(String searchCategory, String sportsCategory, String searchWord);




	ArrayList<FreeBoardSellerVo> selectFreeBoardSellerList(String searchCategory, String sportsCategory,
			String searchWord, int startRow, int endRow);




	void freeBoardSellerInsert(FreeBoardSellerVo freeBoardSellerVo);




	void freeBoardSellerImgInsert(int fbs_num, String fileName);




	void updateFreeBoardSellerHit(int fbs_num);




	FreeBoardSellerVo selectFreeBoardSellerView(int fbs_num);




	ArrayList<FreeBoardSellerImgVo> selectFreeBoardSellerImg(int fbs_num);




	FreeBoardSellerVo selectNextSellerView(int fbs_num);




	FreeBoardSellerVo selectPreSellerView(int fbs_num);




	ArrayList<FreeBoardSellerCommentVo> selectAllSellerComment(int fbs_num);




	int selectAllSellerCommentCount(int fbs_num);




	void freeBoardSellerDelete(int fbs_num);




	void freeBoardSellerDeleteImg(int fbs_num);




	void freeBoardSellerCommentWrite(FreeBoardSellerCommentVo freeBoardSellerCommentVo);




	FreeBoardSellerCommentVo selectOneSellerComment(int c_no);




	void freeBoardSellerCommentModify(FreeBoardSellerCommentVo freeBoardSellerCommentVo);




	void freeBoardSellerCommentDelete(int c_no);




	void freeBoardImgModify(String fileName, int img_no);




	ArrayList<FreeBoardSellerImgVo> selectFreeSellerMemberImg(int fbs_num);




	void freeBoardSellerModify(FreeBoardSellerVo freeBoardSellerVo);




	void freeBoardSellerImgModify(String fileName, int img_no);





}
