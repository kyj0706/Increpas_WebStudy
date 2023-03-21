package vo;

public class StockVo {

	String name; 
	String NowPrice; 
	String vsyesterday; 
	String DungRakrate; 
	String HighPrice; 
	String LowPrice; 
	String georaeryang; 
	String TradingValue;		
	String yesterdayPrice; 
	String sigaPrice;
	
	public StockVo() {
		// TODO Auto-generated constructor stub
	}
	
	public StockVo(String name, String nowPrice, String vsyesterday, String dungRakrate, String highPrice,
			String lowPrice, String georaeryang, String tradingValue, String yesterdayPrice, String sigaPrice) {
		super();
		this.name = name;
		this.NowPrice = nowPrice;
		this.vsyesterday = vsyesterday;
		this.DungRakrate = dungRakrate;
		this.HighPrice = highPrice;
		this.LowPrice = lowPrice;
		this.georaeryang = georaeryang;
		this.TradingValue = tradingValue;
		this.yesterdayPrice = yesterdayPrice;
		this.sigaPrice = sigaPrice;
	}






	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNowPrice() {
		return NowPrice;
	}
	public void setNowPrice(String nowPrice) {
		NowPrice = nowPrice;
	}
	public String getVsyesterday() {
		return vsyesterday;
	}
	public void setVsyesterday(String vsyesterday) {
		this.vsyesterday = vsyesterday;
	}
	public String getDungRakrate() {
		return DungRakrate;
	}
	public void setDungRakrate(String dungRakrate) {
		DungRakrate = dungRakrate;
	}
	public String getHighPrice() {
		return HighPrice;
	}
	public void setHighPrice(String highPrice) {
		HighPrice = highPrice;
	}
	public String getLowPrice() {
		return LowPrice;
	}
	public void setLowPrice(String lowPrice) {
		LowPrice = lowPrice;
	}
	public String getGeoraeryang() {
		return georaeryang;
	}
	public void setGeoraeryang(String georaeryang) {
		this.georaeryang = georaeryang;
	}
	public String getTradingValue() {
		return TradingValue;
	}
	public void setTradingValue(String tradingValue) {
		TradingValue = tradingValue;
	}
	public String getYesterdayPrice() {
		return yesterdayPrice;
	}
	public void setYesterdayPrice(String yesterdayPrice) {
		this.yesterdayPrice = yesterdayPrice;
	}
	public String getSigaPrice() {
		return sigaPrice;
	}
	public void setSigaPrice(String sigaPrice) {
		this.sigaPrice = sigaPrice;
	}
	
	
	
	
	
	
	
}
