package vo;

public class BoardVo {
	
	int 	no;					//����¡ ó��
	
	int		b_idx;				//�Ϸù�ȣ
	String 	b_subject;			//����
	String	b_content;			//����
	String 	b_ip;				//������
	String 	b_regdate;			//�ۼ�����
	int 	b_readhit;			//��ȸ��
	String 	b_use;				//�������(��������)
	int 	mem_idx;			//ȸ����ȣ(FK)
	String 	mem_name;			//ȸ����
	
	//�亯�� �Խ��� ����
	int 	b_ref;				//�����۹�ȣ
	int 	b_step;				//�ۼ���
	int 	b_depth;			//�۱���
	
	//����� ���� 
	int comment_count;			//����� ����
	
	
	
	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	//get&set
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public int getB_idx() {
		return b_idx;
	}

	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public String getB_subject() {
		return b_subject;
	}
	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_ip() {
		return b_ip;
	}
	public void setB_ip(String b_ip) {
		this.b_ip = b_ip;
	}
	public String getB_regdate() {
		return b_regdate;
	}
	public void setB_regdate(String b_regdate) {
		this.b_regdate = b_regdate;
	}
	public int getB_readhit() {
		return b_readhit;
	}
	public void setB_readhit(int b_readhit) {
		this.b_readhit = b_readhit;
	}
	public String getB_use() {
		return b_use;
	}
	public void setB_use(String b_use) {
		this.b_use = b_use;
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
	public int getB_ref() {
		return b_ref;
	}
	public void setB_ref(int b_ref) {
		this.b_ref = b_ref;
	}
	public int getB_step() {
		return b_step;
	}
	public void setB_step(int b_step) {
		this.b_step = b_step;
	}
	public int getB_depth() {
		return b_depth;
	}
	public void setB_depth(int b_depth) {
		this.b_depth = b_depth;
	}
	

	
	
		
}
