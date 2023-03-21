package com.example.teamproject.Service;

import java.util.ArrayList;
import java.util.Map;

import com.example.teamproject.Vo.NoriBoardCommentVo;
import com.example.teamproject.Vo.NoriBoardImgVo;
import com.example.teamproject.Vo.NoriBoardVo;

public interface NoriBoardService {

	Map<String, Object> selectNoriBoardList(String searchCategory, String sportsCategory, String searchWord, int page);

	void noriBoardInsert(NoriBoardVo noriBoardVo, ArrayList<NoriBoardImgVo> imgList);

	Map<String, Object> selectnoriBoardView(int nb_num);

	void noriBoardDelete(int nb_num);

	void noriBoardModify(NoriBoardVo noriBoardVo, ArrayList<NoriBoardImgVo> imgList);

	Map<String, Object> selectNoriBoardModifyView(int nb_num);

	Map<String, Object> noriBoardCommentWrite(NoriBoardCommentVo noriBoardCommentVo);

	int noriBoardCommentDelete(int c_no, int nb_num);

	Map<String, Object> noriBoardCommentModify(NoriBoardCommentVo noriBoardCommentVo);

}
