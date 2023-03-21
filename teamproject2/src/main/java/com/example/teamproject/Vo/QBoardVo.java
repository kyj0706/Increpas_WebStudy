package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QBoardVo {

	private int q_num;
	private String q_title;
	private String q_content;
	private int q_group;
	private String q_date;
	private String q_category;
	private String q_member;
	private String q_status;
	private String member_id;
	private String m_nickname;
	private String fm_name;
	public int getQ_num() {
		return q_num;
	}
	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public int getQ_group() {
		return q_group;
	}
	public void setQ_group(int q_group) {
		this.q_group = q_group;
	}
	public String getQ_date() {
		return q_date;
	}
	public void setQ_date(String q_date) {
		this.q_date = q_date;
	}
	public String getQ_category() {
		return q_category;
	}
	public void setQ_category(String q_category) {
		this.q_category = q_category;
	}
	public String getQ_member() {
		return q_member;
	}
	public void setQ_member(String q_member) {
		this.q_member = q_member;
	}
	public String getQ_status() {
		return q_status;
	}
	public void setQ_status(String q_status) {
		this.q_status = q_status;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public String getFm_name() {
		return fm_name;
	}
	public void setFm_name(String fm_name) {
		this.fm_name = fm_name;
	}
	
	
}
