package vo;

import java.util.List;

public class SawonVO {
	
	//member field / property
	int sabun;
	String saname;
	String sasex;
	int deptno;
	String sajob;
	String sahire;
	int samgr;
	int sapay;
	
	List<GogekVO> go_list;
	
	
	
	//	get/set
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getSaname() {
		return saname;
	}
	public void setSaname(String saname) {
		this.saname = saname;
	}
	public String getSasex() {
		return sasex;
	}
	public void setSasex(String sasex) {
		this.sasex = sasex;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getSajob() {
		return sajob;
	}
	public void setSajob(String sajob) {
		this.sajob = sajob;
	}
	public String getSahire() {
		return sahire;
	}
	public void setSahire(String sahire) {
		this.sahire = sahire;
	}
	public int getSamgr() {
		return samgr;
	}
	public void setSamgr(int samgr) {
		this.samgr = samgr;
	}
	public int getSapay() {
		return sapay;
	}
	public void setSapay(int sapay) {
		this.sapay = sapay;
	}
	public List<GogekVO> getGo_list() {
		return go_list;
	}
	public void setGo_list(List<GogekVO> go_list) {
		this.go_list = go_list;
	}

	
	

}
