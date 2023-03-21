package com.example.teamproject.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.Mapper.Fac_admin_Mapper;
import com.example.teamproject.Vo.EventBoardVo;
import com.example.teamproject.Vo.Fac_admin_Vo;
import com.example.teamproject.Vo.FmanagerVo;
import com.example.teamproject.Vo.PaymentVo;
import com.example.teamproject.Vo.QBoardVo;
import com.example.teamproject.Vo.ReservationVo;
import com.example.teamproject.Vo.ReviewVo;



@Service
public class Fac_admin_ServiceImpl implements Fac_admin_Service {

	@Autowired
	Fac_admin_Mapper fac_admin_Mapper;
	@Override//insertList
	public int insertFile(Fac_admin_Vo fac_admin_Vo) {
		int result = fac_admin_Mapper.insertFile(fac_admin_Vo);
		System.out.println(fac_admin_Vo.getFm_id());
		return result;
	}

	@Override//allList
	public Map<String, Object> selectAllList(String fm_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Fac_admin_Vo> list	= fac_admin_Mapper.selectAllList(fm_id);
		map.put("list", list);
		return map;
	}

	@Override//selectOneList
	public Fac_admin_Vo selectOneList(int finfo_no) {
		Fac_admin_Vo fac_admin_Vo = fac_admin_Mapper.selectOneList(finfo_no);
		return fac_admin_Vo;
	}

	@Override//modify
	public int updateListModify(Fac_admin_Vo fac_admin_Vo) {
		int result = fac_admin_Mapper.updateOneList(fac_admin_Vo);
		return result;
	}

	@Override//delete
	public void deleteOneList(int finfo_no) {
		fac_admin_Mapper.deleteOneList(finfo_no);
		
	}
	
	
	//시설예약 리스트
	@Override
	public Map<String, Object> selectReserveList(int page, String fm_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ReservationVo> list = fac_admin_Mapper.selectReserveList(fm_id);
		
		map.put("list", list);
		
		return map;
	}

	@Override
	public FmanagerVo fmanagerMypage(String fm_id) {
		FmanagerVo fVo = fac_admin_Mapper.fmanagerMypage(fm_id);
		return fVo;
	}

	@Override
	public int fm_Modify(FmanagerVo fVo) {
		System.out.println("수정");

		int result = fac_admin_Mapper.fm_Modify(fVo);
		
		return result;
	}
	
	
	@Override
	public Map<String, Object> selectReviewList(String fm_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		ArrayList<String> finfo_name = fac_admin_Mapper.selectFinFoName(fm_id);
		map.put("finfo_name",finfo_name);
		return map;
	}

	@Override
	public Map<String, Object> selectInfo(String fm_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		ArrayList<String> finfo_name = fac_admin_Mapper.selectFinFoName(fm_id);
		map.put("finfo_name",finfo_name);
		return map;
	}
	
	
//	정산관리
	@Override
	public Map<String, Object> selectPayInfo(String fm_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		
		return map;
	}

	@Override
	public Map<String, Object> selectQBoardList(String fm_id, String member) {
		Map<String,Object> map = new HashMap<String, Object>();
		ArrayList<QBoardVo> list = fac_admin_Mapper.selectQBoardList(fm_id,member);
		map.put("list", list);
		return map;
	}
	//이벤트 관리 페이지
	@Override
	public Map<String, Object> selectEventBoard(String fm_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		ArrayList<EventBoardVo> list = fac_admin_Mapper.selectEventBoard(fm_id);
		map.put("list", list);
		return map;
	}

	@Override
	public Map<String, Object> selecFinfoName(String fm_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		
		return map;
	}

	@Override
	public Map<String, Object> selectFinfoInfo(String finfo_name,String fm_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		int reserNo = fac_admin_Mapper.selectReserCount(finfo_name,fm_id);
		int reviewNo = fac_admin_Mapper.selectReviewNo(finfo_name,fm_id);
		int payNo = fac_admin_Mapper.selectPayNo(finfo_name,fm_id);
		int refundNo = fac_admin_Mapper.selectRefundNo(finfo_name,fm_id);
		int totalPrice = fac_admin_Mapper.selectTotalPrice(fm_id,finfo_name);
		int totalRefund = fac_admin_Mapper.selectTotalRefund(fm_id,finfo_name);
		ArrayList<PaymentVo> list = fac_admin_Mapper.selectPayInfo(fm_id,finfo_name);
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getPay_status().equals("1")) {
				list.get(i).setRefund_date(fac_admin_Mapper.getRefundDate(list.get(i).getReser_no()));
			}
		}
		map.put("reserNo", reserNo);
		map.put("reviewNo", reviewNo);
		map.put("payNo", payNo);
		map.put("refundNo", refundNo);
		map.put("totalPrice", totalPrice);
		map.put("totalRefund", totalRefund);
		map.put("list", list);
		return map;
	}

	@Override
	public Map<String, Object> selectfinfoComment(String finfo_name, String fm_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		ArrayList<ReviewVo> list =  fac_admin_Mapper.selectReviewList(fm_id,finfo_name);
		map.put("list", list);
		return map;
	}

	@Override
	public Map<String, Object> weekPrice(String finfo_name, String fm_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		int totalPrice = fac_admin_Mapper.selectTotalPrice(fm_id,finfo_name);
		int totalRefund = fac_admin_Mapper.selectTotalRefund(fm_id,finfo_name);
		map.put("totalPrice", totalPrice);
		map.put("totalRefund", totalRefund);
		return map;
	}

	

}
