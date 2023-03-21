package com.example.teamproject.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamproject.Vo.EventBoardVo;
import com.example.teamproject.Vo.Fac_admin_Vo;
import com.example.teamproject.Vo.FmanagerVo;
import com.example.teamproject.Vo.PaymentVo;
import com.example.teamproject.Vo.QBoardVo;
import com.example.teamproject.Vo.ReservationVo;
import com.example.teamproject.Vo.ReviewVo;



@Mapper
public interface Fac_admin_Mapper {

	//insertList
	int insertFile(Fac_admin_Vo fac_admin_Vo);

	//AllList
	List<Fac_admin_Vo> selectAllList(String fm_id);

	//selectOneList
	Fac_admin_Vo selectOneList(int finfo_no);

	//modify
	int updateOneList(Fac_admin_Vo fac_admin_Vo);

	//delete
	void deleteOneList(int finfo_no);

	//select Reserve List
	List<ReservationVo> selectReserveList(String fm_id);

	FmanagerVo fmanagerMypage(String fm_id);

	int fm_Modify(FmanagerVo fVo);

	ArrayList<ReviewVo> selectReviewList(String fm_id,String finfo_name);

	int selectReserCount(String finfo_name, String fm_id);

	int selectFinfoNo(String finfo_name);

	int selectReviewNo(String finfo_name, String fm_id);

	int selectPayNo(String finfo_name, String fm_id);

	int selectRefundNo(String finfo_name,String fm_id);

	ArrayList<PaymentVo> selectPayInfo(String fm_id, String finfo_name);

	String getRefundDate(int reser_no);
	
	int selectTotalPrice(String fm_id, String finfo_name);

	int selectTotalRefund(String fm_id, String finfo_name);

	ArrayList<QBoardVo> selectQBoardList(String fm_id, String member);

	ArrayList<EventBoardVo> selectEventBoard(String fm_id);

	ArrayList<String> selectFinFoName(String fm_id);

}
