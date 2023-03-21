package vo;

/*
 	VO(Value Object)
 		1.���� ��������ϴ� ��ü
 			->DB��� ���ڵ带 ���Ѵ�.
 		2.�Ǵ� DTO (data Transfer Object)��� �Ѵ�. [���ް�ü]
	[�����ҹ�]	
		3.get/set�� ������ �����ؾ� �Ѵ�.(���� ������Ҽ� �ִ� ��� ����)
	[3�� ��ü���Ѷ�]-> �ʼ��� �ƴϴ�. ��..... �ٸ����ϸ� ������� ���ϴ�...	
		4.DB �÷���(column) == VO �Ӽ���(property) == ��:�Է�parameter��
		5.Overload�� ������ ����� �⺻�����ڴ� ������ �����ض�
		  (������ȭó���� �⺻�����ڸ� �̿��ؼ� ��ü�� �����Ѵ�.)
		
 */



public class SungVo {

	int 	idx;
	String	name;
	int 	kor;
	int 	eng;
	int		mat;
	
	//client(Java)�������� ������ ��찡 ����(DB�����ؼ� �������� ������)
	//�б����뵥���� ����� �������� String�޴´�.
	String 	tot;
	String	avg;
	String 	rank;
	
	//�⺻������
	public SungVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	//insert������
	public SungVo(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	//update������
	public SungVo(int idx, String name, int kor, int eng, int mat) {
		super();
		this.idx = idx;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	



	//Overload������
	public SungVo(int idx, String name, int kor, int eng, int mat, String tot, String avg, String rank) {
		super();
		this.idx = idx;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
		this.avg = avg;
		this.rank = rank;
	}




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
	public String getTot() {
		return tot;
	}
	public void setTot(String tot) {
		this.tot = tot;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
}
