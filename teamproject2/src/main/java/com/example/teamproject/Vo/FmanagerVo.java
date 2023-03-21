package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FmanagerVo {

	private int fm_no;
	private String fm_id;
	private String fm_pw;
	private String fm_name;
	private String fm_add1;
	private String fm_phone;
	private String fm_cor_num;
	private String fm_point;
	private String fm_email;
	
	public int getFm_no() {
		return fm_no;
	}
	public void setFm_no(int fm_no) {
		this.fm_no = fm_no;
	}
	public String getFm_id() {
		return fm_id;
	}
	public void setFm_id(String fm_id) {
		this.fm_id = fm_id;
	}
	public String getFm_pw() {
		return fm_pw;
	}
	public void setFm_pw(String fm_pw) {
		this.fm_pw = fm_pw;
	}
	public String getFm_name() {
		return fm_name;
	}
	public void setFm_name(String fm_name) {
		this.fm_name = fm_name;
	}
	public String getFm_add1() {
		return fm_add1;
	}
	public void setFm_add1(String fm_add1) {
		this.fm_add1 = fm_add1;
	}
	public String getFm_phone() {
		return fm_phone;
	}
	public void setFm_phone(String fm_phone) {
		this.fm_phone = fm_phone;
	}
	public String getFm_cor_num() {
		return fm_cor_num;
	}
	public void setFm_cor_num(String fm_cor_num) {
		this.fm_cor_num = fm_cor_num;
	}
	public String getFm_point() {
		return fm_point;
	}
	public void setFm_point(String fm_point) {
		this.fm_point = fm_point;
	}
	public String getFm_email() {
		return fm_email;
	}
	public void setFm_email(String fm_email) {
		this.fm_email = fm_email;
	}
	
	
}


