package vo;

public class ChargingVo {

	String statNm;   //충전소명
	String addr;   //주소
	String location;   //상세위치
	String useTime;   //이용가능시간
	String stat;   //충전기상태
	String chgerType;    //충전기타입
	String output;   //충전용량
	String method;   //충전방식
	int    zscode;   //지역구분 상세 코드 
	String parkingFree;   //주차료무료
	String note;   //충전소 안내
	String lat; //위도
	String lng;	//경도
	
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
