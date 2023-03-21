package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefundVo {
	
	private int refund_no;
	private int reser_no;
	private int m_no;
	private int refund_price;
	private String refund_date;
	public int getRefund_no() {
		return refund_no;
	}
	public void setRefund_no(int refund_no) {
		this.refund_no = refund_no;
	}
	public int getReser_no() {
		return reser_no;
	}
	public void setReser_no(int reser_no) {
		this.reser_no = reser_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public int getRefund_price() {
		return refund_price;
	}
	public void setRefund_price(int refund_price) {
		this.refund_price = refund_price;
	}
	public String getRefund_date() {
		return refund_date;
	}
	public void setRefund_date(String refund_date) {
		this.refund_date = refund_date;
	}
	
	
}
