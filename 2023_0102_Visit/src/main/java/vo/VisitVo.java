package vo;

public class VisitVo {
	
	int idx;
	String name,content,pwd,ip; //�̸� ���� ��й�ȣ ������
	String regdate,modifydate; 	//���ʽð� , �����ð�
	
	//�⺻������ (���� �ְ� �����Ÿ� ������)
	public VisitVo() {
		// TODO Auto-generated constructor stub
	}
	
	//insert�� �����ϱ� ���� ���� ������
	public VisitVo(String name, String content, String pwd, String ip) {
		super();
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}

	//update�� �����ϱ� ���� ���� ������
	public VisitVo(int idx, String name, String content, String pwd, String ip) {
		super();
		this.idx = idx;
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}
	

	

	//Vo �������ϸ� �����ҹ� get/set�� ����
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getModifydate() {
		return modifydate;
	}
	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}
	
	
	

	
	
	

}
