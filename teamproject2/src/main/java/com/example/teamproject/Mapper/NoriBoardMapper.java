package com.example.teamproject.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamproject.Vo.NoriBoardCommentVo;
import com.example.teamproject.Vo.NoriBoardImgVo;
import com.example.teamproject.Vo.NoriBoardVo;

@Mapper
public interface NoriBoardMapper {

	int selectNoriBoardCount(String searchCategory, String sportsCategory, String searchWord);

	ArrayList<NoriBoardVo> selectNoriBoardList(String searchCategory, String sportsCategory, String searchWord,
			int startRow, int endRow);

	void noriBoardInsert(NoriBoardVo noriBoardVo);

	void noriBoardImgInsert(int nb_num, String fileName);

	void updateNoriBoardHit(int nb_num);

	NoriBoardVo selectNoriBoardView(int nb_num);

	ArrayList<NoriBoardImgVo> selectNoriBoardImg(int nb_num);

	NoriBoardVo selectNextView(int nb_num);

	NoriBoardVo selectPreView(int nb_num);

	ArrayList<NoriBoardCommentVo> selectAllNoriBoardComment(int nb_num);

	int selectAllNoriBoardCommentCount(int nb_num);

	void noriBoardDelete(int nb_num);

	void noriBoardDeleteImg(int nb_num);

	void noriBoardModify(NoriBoardVo noriBoardVo);

	void noriBoardImgModify(String fileName, int img_no);

	void noriBoardCommentWrite(NoriBoardCommentVo noriBoardCommentVo);

	NoriBoardCommentVo selectOneNoriComment(int c_no);

	void noriBoardCommentModify(NoriBoardCommentVo noriBoardCommentVo);

	void noriBoardCommentDelete(int c_no);


}
