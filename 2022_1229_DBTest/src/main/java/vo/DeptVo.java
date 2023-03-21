package vo;

public class DeptVo {
	
	int 	deptno;  //부서번호
	String 	dname;	 //부서이름
	String 	loc;	 //부서위치
	
	
	
	//생성자는 선택사항 
	
	//이유 불문하고 get/set 생성
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
	
	
	
}
