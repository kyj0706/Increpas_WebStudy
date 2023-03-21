package com.example.teamproject.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.Mapper.QBoardMapper;
import com.example.teamproject.Vo.QBoardVo;
import com.example.teamproject.Vo.ReplyVo;

@Service
public class QBoardServiceImpl implements QBoardService {
	@Autowired
	QBoardMapper qBoardMapper;
	@Override
	public void qBoardWrite(QBoardVo qBoardVo,String member) {
		qBoardMapper.qBoardWrite(qBoardVo,member);
	}
	@Override
	public Map<String, Object> selectView(int q_num) {
		Map<String,Object> map = new HashMap<String,Object>();
		QBoardVo qBoardVo = qBoardMapper.selectView(q_num);
		if(qBoardVo.getQ_status().equals("1")) {
			ReplyVo replyVo = qBoardMapper.selectReply(qBoardVo.getQ_num());
			map.put("replyVo", replyVo);
		}
		map.put("qBoardVo", qBoardVo);
		return map;
	}
	@Override
	public QBoardVo selectQBoardInfo(int q_num) {
		QBoardVo qVo = qBoardMapper.selectQBoardInfo(q_num);
		return qVo;
	}
	@Override
	public void qBoardReply(ReplyVo replyVo) {
		qBoardMapper.qBoardReply(replyVo);
		qBoardMapper.changeStatus(replyVo.getQ_num());
	}
	
	
}
