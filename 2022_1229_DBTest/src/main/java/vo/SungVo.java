package vo;

public class SungVo {

	String name;
	int idx,kor,eng,mat;
	
	
	
	
	public SungVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public SungVo(String name, int idx, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.idx = idx;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	
	
}
