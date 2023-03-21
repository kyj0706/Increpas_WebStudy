package vo;

public class MemberVo {

	int    mem_idx;
	String mem_name;
	String mem_id;
	String mem_pwd;
	String mem_zipcode;
	String mem_address;
	String mem_grade;
	String mem_regdate;
	
	String mem_pwd_hide;//조회용
	
	public String getMem_pwd_hide() {
		
		int len = mem_pwd.length();//전체비번의 길이
		
		StringBuffer sb = new StringBuffer();
		sb.append(mem_pwd.substring(0, len/2));//원래비번의 1/2만 가져오기
		//          0123456    
		// mem_pwd="abcdefg"
		for(int i= (len/2) ; i < len;i++) {
			sb.append("*");
		}
		
		return sb.toString();
	}


	public MemberVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MemberVo(String mem_name, String mem_id, String mem_pwd, String mem_zipcode, String mem_address) {
		super();
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_zipcode = mem_zipcode;
		this.mem_address = mem_address;
	}

	
	public MemberVo(int mem_idx, String mem_name, String mem_id, String mem_pwd, String mem_zipcode, String mem_address,
			String mem_grade) {
		super();
		this.mem_idx = mem_idx;
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_zipcode = mem_zipcode;
		this.mem_address = mem_address;
		this.mem_grade = mem_grade;
	}


	public int getMem_idx() {
		return mem_idx;
	}
	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_zipcode() {
		return mem_zipcode;
	}
	public void setMem_zipcode(String mem_zipcode) {
		this.mem_zipcode = mem_zipcode;
	}
	public String getMem_address() {
		return mem_address;
	}
	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}
	public String getMem_grade() {
		return mem_grade;
	}
	public void setMem_grade(String mem_grade) {
		this.mem_grade = mem_grade;
	}
	public String getMem_regdate() {
		return mem_regdate;
	}
	public void setMem_regdate(String mem_regdate) {
		this.mem_regdate = mem_regdate;
	}
	
	

}
