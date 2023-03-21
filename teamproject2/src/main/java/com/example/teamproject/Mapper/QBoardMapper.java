package com.example.teamproject.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamproject.Vo.QBoardVo;
import com.example.teamproject.Vo.ReplyVo;

@Mapper
public interface QBoardMapper {

	void qBoardWrite(QBoardVo qBoardVo, String member);

	ArrayList<QBoardVo> selectQBoardList(String m_id);

	void qBoardReply(ReplyVo replyVo);

	QBoardVo selectView(int q_num);

	QBoardVo selectQBoardInfo(int q_num);

	void changeStatus(int q_num);

	ReplyVo selectReply(int q_num);

}
