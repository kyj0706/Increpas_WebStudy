package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QnaBoardVo {
	private int qb_num;
	private String qb_title;
	private String qb_content;
	private String qb_category;
	public int getQb_num() {
		return qb_num;
	}
	public void setQb_num(int qb_num) {
		this.qb_num = qb_num;
	}
	public String getQb_title() {
		return qb_title;
	}
	public void setQb_title(String qb_title) {
		this.qb_title = qb_title;
	}
	public String getQb_content() {
		return qb_content;
	}
	public void setQb_content(String qb_content) {
		this.qb_content = qb_content;
	}
	public String getQb_category() {
		return qb_category;
	}
	public void setQb_category(String qb_category) {
		this.qb_category = qb_category;
	}
	
	
	
}
