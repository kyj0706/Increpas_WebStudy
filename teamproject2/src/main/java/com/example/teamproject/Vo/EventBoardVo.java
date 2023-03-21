package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventBoardVo {
	private int eb_num;
	private String eb_title;
	private String eb_content;
	private String eb_date;
	private String eb_start_date;
	private String eb_end_date;
	private int eb_status;
	private String m_nickname;
	private int eb_hit;
	private String fm_name;
	private String fm_id;
	private String finfo_name;
	private String img_name;
	
	public int getEb_num() {
		return eb_num;
	}
	public void setEb_num(int eb_num) {
		this.eb_num = eb_num;
	}
	public String getEb_title() {
		return eb_title;
	}
	public void setEb_title(String eb_title) {
		this.eb_title = eb_title;
	}
	public String getEb_content() {
		return eb_content;
	}
	public void setEb_content(String eb_content) {
		this.eb_content = eb_content;
	}
	public String getEb_date() {
		return eb_date;
	}
	public void setEb_date(String eb_date) {
		this.eb_date = eb_date;
	}
	public String getEb_start_date() {
		return eb_start_date;
	}
	public void setEb_start_date(String eb_start_date) {
		this.eb_start_date = eb_start_date;
	}
	public String getEb_end_date() {
		return eb_end_date;
	}
	public void setEb_end_date(String eb_end_date) {
		this.eb_end_date = eb_end_date;
	}
	public int getEb_status() {
		return eb_status;
	}
	public void setEb_status(int eb_status) {
		this.eb_status = eb_status;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public int getEb_hit() {
		return eb_hit;
	}
	public void setEb_hit(int eb_hit) {
		this.eb_hit = eb_hit;
	}
	public String getFm_name() {
		return fm_name;
	}
	public void setFm_name(String fm_name) {
		this.fm_name = fm_name;
	}
	public String getFm_id() {
		return fm_id;
	}
	public void setFm_id(String fm_id) {
		this.fm_id = fm_id;
	}
	public String getFinfo_name() {
		return finfo_name;
	}
	public void setFinfo_name(String finfo_name) {
		this.finfo_name = finfo_name;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	
	
}
