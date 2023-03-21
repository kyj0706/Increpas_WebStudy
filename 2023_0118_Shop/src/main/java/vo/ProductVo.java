package vo;

public class ProductVo {

	int p_idx;						//일련번호
	String category;				//카테고리(컴퓨터/스포츠)
	String p_num;					//상품번호(모델번호)
	String p_name;					//상품명
	String p_company;				//제조사
	int p_price;					//가격(단가)
	int p_saleprice;				//할인가
	String p_image_s;				//상품이미지(소)
	String p_image_l;				//상품이미지(대)
	String p_content;				//상품설명
	String p_date;					//등록일자
	
	int discount_rate;
	
	
	
	public int getDiscount_rate() {
		//할인율 = (정가-할인가)/정가 * 100
		if(p_price==0) return 0;
		
		
		return (int) ((double)(p_price-p_saleprice)/p_price*100);
	}

	
	public ProductVo() {
		// TODO Auto-generated constructor stub
	}
	
//등록에 필요한 생성자	
	public ProductVo(String category, String p_num, String p_name, String p_company, int p_price, int p_saleprice,
			String p_image_s, String p_image_l, String p_content) {
		super();
		this.category = category;
		this.p_num = p_num;
		this.p_name = p_name;
		this.p_company = p_company;
		this.p_price = p_price;
		this.p_saleprice = p_saleprice;
		this.p_image_s = p_image_s;
		this.p_image_l = p_image_l;
		this.p_content = p_content;
	}







	public int getP_idx() {
		return p_idx;
	}
	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getP_num() {
		return p_num;
	}
	public void setP_num(String p_num) {
		this.p_num = p_num;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_company() {
		return p_company;
	}
	public void setP_company(String p_company) {
		this.p_company = p_company;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_saleprice() {
		return p_saleprice;
	}
	public void setP_saleprice(int p_saleprice) {
		this.p_saleprice = p_saleprice;
	}
	public String getP_image_s() {
		return p_image_s;
	}
	public void setP_image_s(String p_image_s) {
		this.p_image_s = p_image_s;
	}
	public String getP_image_l() {
		return p_image_l;
	}
	public void setP_image_l(String p_image_l) {
		this.p_image_l = p_image_l;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	
	
	
	
}
