package com.saeyan.dto;

/*
 * create table product(
	code number(5),
	name varchar2(100),
	price number(8),
	pictureurl varchar2(50),
	description varchar2(1000),
	primary key(code)
);
 */

public class ProductVO {
	private int code;
	private String name;
	private int price;
	private String pictureUrl;
	private String description;

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
