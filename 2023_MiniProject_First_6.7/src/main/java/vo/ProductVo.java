package vo;

public class ProductVo {
	
	int product_idx;
	
	String product_name;
	String product_content;
	int product_price;
	
	String product_category;
	String product_company;
	
	String product_image1;
	String product_image2;
	String product_image3;
	String product_image4;
	
	String product_regdate_date;
	
	
	
	//기본생성자
	public ProductVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	//insert
	public ProductVo(String product_name, String product_content, int product_price, String product_category,
			String product_company, String product_image1, String product_image2, String product_image3,
			String product_image4) {
		super();
		this.product_name = product_name;
		this.product_content = product_content;
		this.product_price = product_price;
		this.product_category = product_category;
		this.product_company = product_company;
		this.product_image1 = product_image1;
		this.product_image2 = product_image2;
		this.product_image3 = product_image3;
		this.product_image4 = product_image4;
	}

	public int getProduct_idx() {
		return product_idx;
	}

	public void setProduct_idx(int product_idx) {
		this.product_idx = product_idx;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_content() {
		return product_content;
	}

	public void setProduct_content(String product_content) {
		this.product_content = product_content;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public String getProduct_company() {
		return product_company;
	}

	public void setProduct_company(String product_company) {
		this.product_company = product_company;
	}

	public String getProduct_image1() {
		return product_image1;
	}

	public void setProduct_image1(String product_image1) {
		this.product_image1 = product_image1;
	}

	public String getProduct_image2() {
		return product_image2;
	}

	public void setProduct_image2(String product_image2) {
		this.product_image2 = product_image2;
	}

	public String getProduct_image3() {
		return product_image3;
	}

	public void setProduct_image3(String product_image3) {
		this.product_image3 = product_image3;
	}

	public String getProduct_image4() {
		return product_image4;
	}

	public void setProduct_image4(String product_image4) {
		this.product_image4 = product_image4;
	}

	public String getProduct_regdate_date() {
		return product_regdate_date;
	}

	public void setProduct_regdate_date(String product_regdate_date) {
		this.product_regdate_date = product_regdate_date;
	}
	
	
	
	
	
}