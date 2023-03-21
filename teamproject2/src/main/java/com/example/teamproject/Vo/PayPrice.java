package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayPrice {
	private String payweek;
	private int payprice;
	private int refundprice;
	public String getPayweek() {
		return payweek;
	}
	public void setPayweek(String payweek) {
		this.payweek = payweek;
	}
	public int getPayprice() {
		return payprice;
	}
	public void setPayprice(int payprice) {
		this.payprice = payprice;
	}
	public int getRefundprice() {
		return refundprice;
	}
	public void setRefundprice(int refundprice) {
		this.refundprice = refundprice;
	}
	
	
	
}
