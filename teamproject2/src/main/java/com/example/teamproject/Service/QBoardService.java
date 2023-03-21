package com.example.teamproject.Service;

import java.util.Map;

import com.example.teamproject.Vo.QBoardVo;
import com.example.teamproject.Vo.ReplyVo;

public interface QBoardService {

	void qBoardWrite(QBoardVo qBoardVo, String member);

	Map<String, Object> selectView(int q_num);

	QBoardVo selectQBoardInfo(int q_num);

	void qBoardReply(ReplyVo replyVo);

}
