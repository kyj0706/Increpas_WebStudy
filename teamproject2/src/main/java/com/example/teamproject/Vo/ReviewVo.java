package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewVo {
	private int r_no;
	private int m_no;
	private int finfo_no;
	private String r_date;
	private String m_nickname;
	private String m_name;
	private String r_content;
	private int r_rate;
	public int getR_no() {
		return r_no;
	}
	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public int getFinfo_no() {
		return finfo_no;
	}
	public void setFinfo_no(int finfo_no) {
		this.finfo_no = finfo_no;
	}
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public int getR_rate() {
		return r_rate;
	}
	public void setR_rate(int r_rate) {
		this.r_rate = r_rate;
	}
	
	
}
