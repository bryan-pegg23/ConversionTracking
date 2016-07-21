package com.cooksys.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class LocationApp {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "area")
	private String area;

	@Column(name = "user_number")
	private Long userNumber;

	@Column(name = "annoumus_number")
	private Long annoumusNumber;
	
	@Column(name = "area_code")
	private Long areaCode;
	
	@ManyToMany(mappedBy = "locations")
	private List<HitsPerDay> hitsPerDay;

	public LocationApp() {

	}

	public LocationApp(Long id, String area, Long userNumber, Long annoumusNumber, Long areaCode,
			List<HitsPerDay> hitsPerDay) {
		this.id = id;
		this.area = area;
		this.userNumber = userNumber;
		this.annoumusNumber = annoumusNumber;
		this.areaCode = areaCode;
		this.hitsPerDay = hitsPerDay;
	}

	public Long getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Long areaCode) {
		this.areaCode = areaCode;
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

	public Long getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(Long userNumber) {
		this.userNumber = userNumber;
	}

	public Long getAnnoumusNumber() {
		return annoumusNumber;
	}

	public void setAnnoumusNumber(Long annoumusNumber) {
		this.annoumusNumber = annoumusNumber;
	}

	public List<HitsPerDay> getHitsPerDay() {
		return hitsPerDay;
	}

	public void setHitsPerDay(List<HitsPerDay> hitsPerDay) {
		this.hitsPerDay = hitsPerDay;
	}

}
