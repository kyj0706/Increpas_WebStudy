package vo;

public class DeptVo {
	
	int 	deptno;  //�μ���ȣ
	String 	dname;	 //�μ��̸�
	String 	loc;	 //�μ���ġ
	
	
	
	//�����ڴ� ���û��� 
	
	//���� �ҹ��ϰ� get/set ����
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
