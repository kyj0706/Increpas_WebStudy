package vo;

public class UserVo {
	
	int user_idx;
	String user_name;
	String user_id;
	String user_pw;
	String user_email;
	String user_address1;
	String user_address2;
	String user_post;
	String user_grade;
	String user_regdate;
	String user_modifydate;
	
	//기본생성자
	public UserVo() {
		// TODO Auto-generated constructor stub
	}

	//insert
	public UserVo(String user_name, String user_id, String user_pw, String user_email, String user_address1,
			String user_address2, String user_post, String user_grade) {
		super();
		this.user_name = user_name;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_email = user_email;
		this.user_address1 = user_address1;
		this.user_address2 = user_address2;
		this.user_post = user_post;
		this.user_grade = user_grade;
	}
	
	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_address1() {
		return user_address1;
	}

	public void setUser_address1(String user_address1) {
		this.user_address1 = user_address1;
	}

	public String getUser_address2() {
		return user_address2;
	}

	public void setUser_address2(String user_address2) {
		this.user_address2 = user_address2;
	}

	public String getUser_post() {
		return user_post;
	}

	public void setUser_post(String user_post) {
		this.user_post = user_post;
	}

	public String getUser_grade() {
		return user_grade;
	}

	public void setUser_grade(String user_grade) {
		this.user_grade = user_grade;
	}

	public String getUser_regdate() {
		return user_regdate;
	}

	public void setUser_regdate(String user_regdate) {
		this.user_regdate = user_regdate;
	}

	public String getUser_modifydate() {
		return user_modifydate;
	}

	public void setUser_modifydate(String user_modifydate) {
		this.user_modifydate = user_modifydate;
	}
	
}
