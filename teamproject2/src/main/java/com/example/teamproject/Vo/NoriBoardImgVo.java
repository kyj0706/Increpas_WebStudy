package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoriBoardImgVo {
	
	private int img_no;
	private String img_name;
	private int eb_num;
	
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
	public int getEb_num() {
		return eb_num;
	}
	public void setEb_num(int eb_num) {
		this.eb_num = eb_num;
	}
	
	
}
