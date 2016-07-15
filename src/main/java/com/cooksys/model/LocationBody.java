package com.cooksys.model;

public class LocationBody {

	private String title;
	private Long num;

	public LocationBody() {

	}

	public LocationBody(String title, Long num) {
		this.title = title;
		this.num = num;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
	
}