package vo;
/*
 VO : Value Object
 1.가급적이면 DB필드명과 동일한 속성명을 사용
 2.속성(변수)에 대한 getter/setter생성해라

 */
public class SawonVo {
	int sabun,deptno,sapay,samgr;
	String saname,sasex,sajob,sahire;
	
	
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getSapay() {
		return sapay;
	}
	public void setSapay(int sapay) {
		this.sapay = sapay;
	}
	public int getSamgr() {
		return samgr;
	}
	public void setSamgr(int samgr) {
		this.samgr = samgr;
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
	public String getSajob() {
		return sajob;
	}
	public void setSajob(String sajob) {
		this.sajob = sajob;
	}
	public String getSahire() {
		return sahire.substring(0,10);
	}
	public void setSahire(String sahire) {
		this.sahire = sahire;
	}
	
	
}
