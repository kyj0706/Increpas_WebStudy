package com.example.teamproject.Service;

import java.util.ArrayList;
import java.util.Map;

import com.example.teamproject.Vo.Fac_admin_Vo;
import com.example.teamproject.Vo.MemberVo;
import com.example.teamproject.Vo.ReservationVo;
import com.example.teamproject.Vo.ReviewVo;

public interface ReservationService {

	Map<String, Object> selectFinfo(int page, String sportCategory, String searchWord, String searchCategory);

	Fac_admin_Vo selectfinfoView(int finfo_no);

	MemberVo selectMember(String id);

	Map<String, Object> reserDateCheck(String reserDate, int finfo_no);

	Map<String, Object> reservation(ReservationVo reservationVo);

	Map<String, Object> selectResrInfo(int reser_no);

	int cancelReservation(int reser_no);

	Map<String, Object> selectMainInfo();

	Map<String, Object> selectSportList(String searchArea);

	Map<String, Object> selectFinfoName(String searchArea, String sportCategory);

	String selectFinfo_Phone(String fm_id);


	Map<String, Object> writeReview(ReviewVo reviewVo);

	ArrayList<ReviewVo> selectAllReview(int finfo_no);

	Map<String, Object> deleteReview(int r_no, int finfo_no);


}
