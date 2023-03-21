package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FreeBoardMemberImgVo {
	
	private int img_no;
	private String img_name;
	private int fbm_num;
	public int getImg_no() {
		return img_no;
	}
	public void setImg_no(int img_no) {
		this.img_no = img_no;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public int getFbm_num() {
		return fbm_num;
	}
	public void setFbm_num(int fbm_num) {
		this.fbm_num = fbm_num;
	}
	
	
}
