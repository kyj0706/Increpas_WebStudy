package vo;

public class ChargingVo {

	String statNm;   //�����Ҹ�
	String addr;   //�ּ�
	String location;   //����ġ
	String useTime;   //�̿밡�ɽð�
	String stat;   //���������
	String chgerType;    //������Ÿ��
	String output;   //�����뷮
	String method;   //�������
	int    zscode;   //�������� �� �ڵ� 
	String parkingFree;   //�����ṫ��
	String note;   //������ �ȳ�
	String lat; //����
	String lng;	//�浵
	
	int pageNo;
	
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getStatNm() {
		return statNm;
	}
	public void setStatNm(String statNm) {
		this.statNm = statNm;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUseTime() {
		return useTime;
	}
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getChgerType() {
		return chgerType;
	}
	public void setChgerType(String chgerType) {
		this.chgerType = chgerType;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public int getZscode() {
		return zscode;
	}
	public void setZscode(int zscode) {
		this.zscode = zscode;
	}
	public String getParkingFree() {
		return parkingFree;
	}
	public void setParkingFree(String parkingFree) {
		this.parkingFree = parkingFree;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
