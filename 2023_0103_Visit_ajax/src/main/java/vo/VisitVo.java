package vo;

public class VisitVo {
	
	int idx;
	String name,content,pwd,ip; //이름 내용 비밀번호 아이피
	String regdate,modifydate; 	//최초시간 , 수정시간
	
	//기본생성자 (값을 주고 받을거면 만들어라)
	public VisitVo() {
		// TODO Auto-generated constructor stub
	}
	
	//insert를 포장하기 위해 만든 생성자
	public VisitVo(String name, String content, String pwd, String ip) {
		super();
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}

	//update를 포장하기 위해 만든 생성자
	public VisitVo(int idx, String name, String content, String pwd, String ip) {
		super();
		this.idx = idx;
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}
	

	

	//Vo 를생성하면 이유불문 get/set을 생성
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
