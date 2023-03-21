package vo;

public class CommentVo {
	
	int cmt_idx;						//일련번호
	String cmt_content;					//내용 (정작가지오 올건 이거 하나다)
	String cmt_ip;						//아이피
	String cmt_regdate;					//등록일자
	int b_idx;							//게시물번호
	int mem_idx;						//유저번호
	String mem_id;						//유저아이디
	String mem_name;					//유저이름
	
	
	
	
	
	
	//get & set
	public int getCmt_idx() {
		return cmt_idx;
	}
	public void setCmt_idx(int cmt_idx) {
		this.cmt_idx = cmt_idx;
	}
	public String getCmt_content() {
		return cmt_content;
	}
	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}
	public String getCmt_ip() {
		return cmt_ip;
	}
	public void setCmt_ip(String cmt_ip) {
		this.cmt_ip = cmt_ip;
	}
	public String getCmt_regdate() {
		return cmt_regdate;
	}
	public void setCmt_regdate(String cmt_regdate) {
		this.cmt_regdate = cmt_regdate;
	}
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public int getMem_idx() {
		return mem_idx;
	}
	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	
	


	
	
}
