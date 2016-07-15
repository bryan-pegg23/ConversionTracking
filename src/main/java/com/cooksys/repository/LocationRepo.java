package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.LocationApp;

public interface LocationRepo extends JpaRepository<LocationApp, Long>{
	
	LocationApp findByAreaCode(Long name);

	public LocationApp findByArea(String name);
	
}
