package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoriBoardVo {
	private int nb_num;
	private String nb_title;
	private String nb_content;
	private String nb_category;
	private String nb_date;
	private String m_nickname;
	private int nb_hit;
	private String m_id;
	public int getNb_num() {
		return nb_num;
	}
	public void setNb_num(int nb_num) {
		this.nb_num = nb_num;
	}
	public String getNb_title() {
		return nb_title;
	}
	public void setNb_title(String nb_title) {
		this.nb_title = nb_title;
	}
	public String getNb_content() {
		return nb_content;
	}
	public void setNb_content(String nb_content) {
		this.nb_content = nb_content;
	}
	public String getNb_category() {
		return nb_category;
	}
	public void setNb_category(String nb_category) {
		this.nb_category = nb_category;
	}
	public String getNb_date() {
		return nb_date;
	}
	public void setNb_date(String nb_date) {
		this.nb_date = nb_date;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public int getNb_hit() {
		return nb_hit;
	}
	public void setNb_hit(int nb_hit) {
		this.nb_hit = nb_hit;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
	
}
