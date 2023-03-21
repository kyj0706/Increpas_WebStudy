package com.example.teamproject.Service;

import java.util.Map;

import com.example.teamproject.Vo.Fac_admin_Vo;
import com.example.teamproject.Vo.FmanagerVo;



public interface Fac_admin_Service {

	//insertList
	int insertFile(Fac_admin_Vo fac_admin_Vo);

	//allList
	Map<String, Object> selectAllList(String fm_id);

	//selectOneList
	Fac_admin_Vo selectOneList(int finfo_no);

	//modify
	int updateListModify(Fac_admin_Vo fac_admin_Vo);

	//delete
	void deleteOneList(int finfo_no);

	Map<String, Object> selectReserveList(int page, String fm_id);

	FmanagerVo fmanagerMypage(String fm_id);

	int fm_Modify(FmanagerVo fVo);

	Map<String, Object> selectReviewList(String fm_id);

	Map<String, Object> selectInfo(String fm_id);

	Map<String, Object> selectPayInfo(String fm_id);

	Map<String, Object> selectQBoardList(String fm_id, String member);

	Map<String, Object> selectEventBoard(String fm_id);

	Map<String, Object> selecFinfoName(String fm_id);

	Map<String, Object> selectFinfoInfo(String finfo_name, String fm_id);

	Map<String, Object> selectfinfoComment(String finfo_name, String fm_id);

	Map<String, Object> weekPrice(String finfo_name, String fm_id);

	//select Reserve List

}
