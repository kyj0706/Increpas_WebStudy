package dao;

import java.util.ArrayList;
import java.util.List;

import vo.C_boardVo;
import vo.C_memberVo;
import vo.ChargingVo;

public interface AdminDao {
	
	//ȸ������Ʈ
	List<C_memberVo> adminCmemberList();
	
	//�����Խ��Ǹ���Ʈ
	List<C_boardVo> adminCboardList();
	
	//�������׸���Ʈ
	
	//�����Ҹ���Ʈ
	ArrayList<ChargingVo> adminCharginList();
	

}
