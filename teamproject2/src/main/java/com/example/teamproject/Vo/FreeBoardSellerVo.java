package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FreeBoardSellerVo {
	private int fbs_num;
	private String fbs_title;
	private String fbs_content;
	private String fbs_category;
	private String fbs_date;
	//private String FM_NAME;
	private int fbs_hit;
	private String fm_id;
	public int getFbs_num() {
		return fbs_num;
	}
	public void setFbs_num(int fbs_num) {
		this.fbs_num = fbs_num;
	}
	public String getFbs_title() {
		return fbs_title;
	}
	public void setFbs_title(String fbs_title) {
		this.fbs_title = fbs_title;
	}
	public String getFbs_content() {
		return fbs_content;
	}
	public void setFbs_content(String fbs_content) {
		this.fbs_content = fbs_content;
	}
	public String getFbs_category() {
		return fbs_category;
	}
	public void setFbs_category(String fbs_category) {
		this.fbs_category = fbs_category;
	}
	public String getFbs_date() {
		return fbs_date;
	}
	public void setFbs_date(String fbs_date) {
		this.fbs_date = fbs_date;
	}
	public int getFbs_hit() {
		return fbs_hit;
	}
	public void setFbs_hit(int fbs_hit) {
		this.fbs_hit = fbs_hit;
	}
	public String getFm_id() {
		return fm_id;
	}
	public void setFm_id(String fm_id) {
		this.fm_id = fm_id;
	}
	
	
	
}
