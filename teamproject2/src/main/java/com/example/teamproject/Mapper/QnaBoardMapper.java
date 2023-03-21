package com.example.teamproject.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamproject.Vo.QnaBoardVo;

@Mapper
public interface QnaBoardMapper {

	int selectQnaBoardListCount(String category);

	ArrayList<QnaBoardVo> selectQnaBoardList(String category, int startRow, int endRow);

	void qnaBoardWrite(QnaBoardVo qnaBoardVo);

	QnaBoardVo selectQnaInfo(int qb_num);

	void qnaModify(QnaBoardVo qnaBoardVo);

	void qnaDelete(int qb_num);

}
