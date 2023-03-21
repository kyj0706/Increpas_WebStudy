package com.example.teamproject.Service;

import java.util.Map;

import com.example.teamproject.Vo.QnaBoardVo;


public interface QnaBoardService {

	Map<String, Object> selectQnaBoard(String category,int page);

	void qnaBoardWrite(QnaBoardVo qnaBoardVo);

	QnaBoardVo selectQnaInfo(int qb_num);

	void qnaModify(QnaBoardVo qnaBoardVo);

	void qnaDelete(int qb_num);

}
