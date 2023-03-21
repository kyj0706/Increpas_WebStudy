package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationVo {
	private int reser_no;        
	private int finfo_no;
	private String fm_id;
	private int m_no;
	private String m_name;
	private String finfo_name;
	private String m_nickname;
	private int finfo_price;
	private String finfo_sport;
	private String apply_date;
	private String reser_date;          
	private String reser_time; 
	private String reser_status;
	public int getReser_no() {
		return reser_no;
	}
	public void setReser_no(int reser_no) {
		this.reser_no = reser_no;
	}
	public int getFinfo_no() {
		return finfo_no;
	}
	public void setFinfo_no(int finfo_no) {
		this.finfo_no = finfo_no;
	}
	public String getFm_id() {
		return fm_id;
	}
	public void setFm_id(String fm_id) {
		this.fm_id = fm_id;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getFinfo_name() {
		return finfo_name;
	}
	public void setFinfo_name(String finfo_name) {
		this.finfo_name = finfo_name;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public int getFinfo_price() {
		return finfo_price;
	}
	public void setFinfo_price(int finfo_price) {
		this.finfo_price = finfo_price;
	}
	public String getFinfo_sport() {
		return finfo_sport;
	}
	public void setFinfo_sport(String finfo_sport) {
		this.finfo_sport = finfo_sport;
	}
	public String getApply_date() {
		return apply_date;
	}
	public void setApply_date(String apply_date) {
		this.apply_date = apply_date;
	}
	public String getReser_date() {
		return reser_date;
	}
	public void setReser_date(String reser_date) {
		this.reser_date = reser_date;
	}
	public String getReser_time() {
		return reser_time;
	}
	public void setReser_time(String reser_time) {
		this.reser_time = reser_time;
	}
	public String getReser_status() {
		return reser_status;
	}
	public void setReser_status(String reser_status) {
		this.reser_status = reser_status;
	}
	
	
}
