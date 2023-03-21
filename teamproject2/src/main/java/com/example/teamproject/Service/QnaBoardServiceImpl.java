package com.example.teamproject.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.Mapper.QnaBoardMapper;
import com.example.teamproject.Vo.QnaBoardVo;

@Service
public class QnaBoardServiceImpl implements QnaBoardService {
	@Autowired
	QnaBoardMapper qnaBoardMapper;
	@Override
	public Map<String, Object> selectQnaBoard(String category, int page) {
		Map<String, Object> map = new HashMap<String, Object>();

		int limit = 10;
		int numLimit = 10;
		int listCount = qnaBoardMapper.selectQnaBoardListCount(category);
		int startPage = (((int) ((double) page / numLimit + 0.99)) - 1) * numLimit + 1;
		int endPage = startPage + numLimit - 1;
		int maxPage = ((int) ((double) listCount / limit + 0.99));
		if (endPage > maxPage)
			endPage = maxPage;
		int startRow = (page - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println("count" + listCount);
		System.out.println("startPage" + startPage);
		System.out.println("endPage" + endPage);
		System.out.println("maxPage" + maxPage);
		System.out.println("startRow" + startRow);
		System.out.println("endRow" + endRow);
		ArrayList<QnaBoardVo> list = qnaBoardMapper.selectQnaBoardList(category, startRow, endRow);
		map.put("page", page);
		map.put("category", category);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("maxPage", maxPage);
		map.put("list", list);
		return map;
	}
	@Override
	public void qnaBoardWrite(QnaBoardVo qnaBoardVo) {
		qnaBoardMapper.qnaBoardWrite(qnaBoardVo);
		
	}
	@Override
	public QnaBoardVo selectQnaInfo(int qb_num) {
		QnaBoardVo qnaBoardVo = qnaBoardMapper.selectQnaInfo(qb_num);
		return qnaBoardVo;
	}
	@Override
	public void qnaModify(QnaBoardVo qnaBoardVo) {
		qnaBoardMapper.qnaModify(qnaBoardVo);
		
	}
	@Override
	public void qnaDelete(int qb_num) {
		qnaBoardMapper.qnaDelete(qb_num);
	}

}
