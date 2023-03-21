package dao;

import vo.ChargingVo;

public interface ChargingDao {

	ChargingVo selectOne(String statNm);
	
}
