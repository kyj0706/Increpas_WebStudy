package com.example.teamproject.Mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamproject.Vo.EventBoardVo;
import com.example.teamproject.Vo.Fac_admin_Vo;
import com.example.teamproject.Vo.MemberVo;
import com.example.teamproject.Vo.NoticeBoardVo;
import com.example.teamproject.Vo.PaymentVo;
import com.example.teamproject.Vo.RefundVo;
import com.example.teamproject.Vo.ReservationVo;
import com.example.teamproject.Vo.ReviewVo;

@Mapper
public interface ReservationMapper {

	int selectFinfoCount(String sportCategory, String searchWord, String searchCategory);

	ArrayList<Fac_admin_Vo> selectFinfoList(String searchCategory, String sportCategory, String searchWord,
			int startRow, int endRow);

	Fac_admin_Vo selectfinfoView(int finfo_no);

	MemberVo selectMember(String id);

	ArrayList<String> reserDateCheck(String reserDate, int finfo_no);

	void reservation(ReservationVo reservatsionVo);

	ReservationVo selectResult(int reser_no);

	int getReservationFee(int finfo_no);

	void cancelResrvation(int reser_no);

	void insertPay(int m_no, int reser_no, int fee);

	ArrayList<EventBoardVo> selectEventInfo();

	ArrayList<NoticeBoardVo> selectNoticeInfo();

	MemberVo selectMemberInfo(int m_no);

	PaymentVo selectPaymentInfo(int reser_no);

	String selectImgName(int finfo_no);

	void cancelPayment(int reser_no);

	int selectRefundFee(int reser_no);

	int selectRefundM_no(int reser_no);

	void insertRefund(int reser_no, int refundFee, int m_no);

	RefundVo selectRefundInfo(int reser_no);

	ArrayList<String> selectSportList(String searchArea);

	ArrayList<Fac_admin_Vo> selectFinfoName(String searchArea, String sportCategory);

	String selectFinfo_Phone(String fm_id);

	void writeReview(ReviewVo reviewVo);

	ReviewVo selectOneReview(int r_no);

	ArrayList<ReviewVo> selectAllReview(int finfo_no);

	int selectReviewCount(int finfo_no);

	int getReviewCount(int finfo_no);

	int reserCheck(int m_no, int finfo_no);
	
	ArrayList<Fac_admin_Vo> selectNewFinfo();

	void deleteReview(int r_no);



}
