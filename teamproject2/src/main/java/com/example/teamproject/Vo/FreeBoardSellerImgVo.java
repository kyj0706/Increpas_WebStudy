package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FreeBoardSellerImgVo {
	
	private int img_no;
	private String img_name;
	private int fbs_num;
	
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
	public int getFbs_num() {
		return fbs_num;
	}
	public void setFbs_num(int fbs_num) {
		this.fbs_num = fbs_num;
	}
	
	
}
