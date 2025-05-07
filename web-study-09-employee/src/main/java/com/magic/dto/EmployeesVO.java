package com.magic.dto;

import java.sql.Date;

public class EmployeesVO {
	
	private String id;
	private String pwd;
	private String name;
	private String lev;
	private Date enter;
	private int gender;
	private String phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public Date getEnter() {
		return enter;
	}
	public void setEnter(Date enter) {
		this.enter = enter;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return " \n EmployeesVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", lev=" + lev + ", enter=" + enter
				+ ", gender=" + gender + ", phone=" + phone + "]";
	}
	
	

}
