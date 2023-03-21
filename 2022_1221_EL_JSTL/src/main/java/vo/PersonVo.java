package vo;

// VO(Value Object)

public class PersonVo {
	
	String name;
	int	   age;
	String tel;
	
	
	
	//기본생성자
	public PersonVo() {
		// TODO Auto-generated constructor stub
	}


	//값이 있는 생성자
	public PersonVo(String name, int age, String tel) {
		super();
		this.name = name;
		this.age = age;
		this.tel = tel;
	}


	public String getName() {
		System.out.println("--getNmae()--");
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	

}
