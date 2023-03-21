package dao;

import java.util.ArrayList;
import java.util.List;

import vo.C_boardVo;
import vo.C_memberVo;
import vo.ChargingVo;

public interface AdminDao {
	
	//회원리스트
	List<C_memberVo> adminCmemberList();
	
	//유저게시판리스트
	List<C_boardVo> adminCboardList();
	
	//공지사항리스트
	
	//충전소리스트
	ArrayList<ChargingVo> adminCharginList();
	

}
