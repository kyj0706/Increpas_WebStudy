package vo;

import java.util.List;

public class DeptVO {

	int deptno;
	String dname;
	String loc;
	
	List<SawonVO> sa_list;
	
	

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public List<SawonVO> getSa_list() {
		return sa_list;
	}

	public void setSa_list(List<SawonVO> sa_list) {
		this.sa_list = sa_list;
	}



	

	
}
