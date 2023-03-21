package com.example.teamproject.Service;

import java.util.ArrayList;
import java.util.Map;

import com.example.teamproject.Vo.FreeBoardMemberCommentVo;
import com.example.teamproject.Vo.FreeBoardMemberImgVo;
import com.example.teamproject.Vo.FreeBoardMemberVo;
import com.example.teamproject.Vo.FreeBoardSellerCommentVo;
import com.example.teamproject.Vo.FreeBoardSellerImgVo;
import com.example.teamproject.Vo.FreeBoardSellerVo;



public interface FreeBoardService {

	void freeBoardMemberInsert(FreeBoardMemberVo freeBoardMemberVo, ArrayList<FreeBoardMemberImgVo> imgList);

	Map<String, Object> selectFreeMemberBoardList(String searchCategory, String sportsCategory, String searchWord,
			int page);

	Map<String, Object> selectFreeMemberView(int fbm_num);

	void freeBoardMemberDelete(int fbm_num);

	Map<String, Object> selectFreeBoardMemberModifyView(int fbm_num);

	void freeBoardMemberModify(FreeBoardMemberVo freeBoardMemberVo, ArrayList<FreeBoardMemberImgVo> imgList);

	Map<String, Object> freeBoardMemberCommentWrite(FreeBoardMemberCommentVo freeBoardCommentVo);

	Map<String, Object> freeBoardMemberCommentModify(FreeBoardMemberCommentVo freeBoardMemberCommentVo);

	int freeBoardMemberCommentDelete(int c_no, int f_num);

	Map<String, Object> selectFreeSellerBoardList(String searchCategory, String sportsCategory, String searchWord,
			int page);



	Map<String, Object> selectFreeSellerView(int fbs_num);

	void freeBoardSellerDelete(int fbs_num);

	Map<String, Object> freeBoardSellerCommentWrite(FreeBoardSellerCommentVo freeBoardSellerCommentVo);

	Map<String, Object> freeBoardSellerCommentModify(FreeBoardSellerCommentVo freeBoardSellerCommentVo);

	int freeBoardSellerCommentDelete(int c_no, int fbs_num);

	void freeBoardSellerInsert(FreeBoardSellerVo freeBoardSellerVo, ArrayList<FreeBoardSellerImgVo> imgList);

	Map<String, Object> selectFreeBoardSellerModifyView(int fbs_num);

	void freeBoardSellerModify(FreeBoardSellerVo freeBoardSellerVo, ArrayList<FreeBoardSellerImgVo> imgList);


	
}