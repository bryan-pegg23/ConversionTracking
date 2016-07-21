package com.cooksys.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.entity.LocationApp;

public class LocationResponse {

	private Long id;
	private String area;
	private Long annoumusNumber;
	private Long userNumber;
	private Long areaCode;
	
	public LocationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocationResponse(Long id, String area, Long annoumusNumber, Long userNumber, Long areaCode) {
		this.id = id;
		this.area = area;
		this.annoumusNumber = annoumusNumber;
		this.userNumber = userNumber;
		this.areaCode = areaCode;
	}
	
	public static LocationResponse get(LocationApp local) {
		if (local == null)
			return null;
		Long totalHits = local.getAnnoumusNumber() + local.getUserNumber();
		return new LocationResponse(local.getId(), local.getArea(), totalHits, local.getUserNumber(), local.getAreaCode());
	}
	
	public static List<LocationResponse> getList(List<LocationApp> list) {
		List<LocationResponse> locationList = new ArrayList<>();
		for (LocationApp location : list)
			locationList.add(LocationResponse.get(location));
		
		return locationList;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Long getAnnoumusNumber() {
		return annoumusNumber;
	}
	public void setAnnoumusNumber(Long annoumusNumber) {
		this.annoumusNumber = annoumusNumber;
	}
	public Long getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(Long userNumber) {
		this.userNumber = userNumber;
	}
	public Long getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(Long areaCode) {
		this.areaCode = areaCode;
	}
	
}
