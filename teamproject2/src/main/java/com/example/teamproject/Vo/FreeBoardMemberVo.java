package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FreeBoardMemberVo {
	private int fbm_num;
	private String fbm_title;
	private String fbm_content;
	private String fbm_category;
	private String fbm_date;
	private String m_nickname;
	private int fbm_hit;
	private String m_id;
	public int getFbm_num() {
		return fbm_num;
	}
	public void setFbm_num(int fbm_num) {
		this.fbm_num = fbm_num;
	}
	public String getFbm_title() {
		return fbm_title;
	}
	public void setFbm_title(String fbm_title) {
		this.fbm_title = fbm_title;
	}
	public String getFbm_content() {
		return fbm_content;
	}
	public void setFbm_content(String fbm_content) {
		this.fbm_content = fbm_content;
	}
	public String getFbm_category() {
		return fbm_category;
	}
	public void setFbm_category(String fbm_category) {
		this.fbm_category = fbm_category;
	}
	public String getFbm_date() {
		return fbm_date;
	}
	public void setFbm_date(String fbm_date) {
		this.fbm_date = fbm_date;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public int getFbm_hit() {
		return fbm_hit;
	}
	public void setFbm_hit(int fbm_hit) {
		this.fbm_hit = fbm_hit;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
	
}
