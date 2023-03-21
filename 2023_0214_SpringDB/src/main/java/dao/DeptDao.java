package dao;

import java.util.List;

import vo.DeptVo;

public interface DeptDao {
	
	//명세(기능)목록
	List<DeptVo> selectList();
	

}
