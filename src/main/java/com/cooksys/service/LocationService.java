package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.LocationApp;
import com.cooksys.entity.UserApp;
import com.cooksys.model.LocationBody;
import com.cooksys.repository.LocationRepo;
import com.cooksys.repository.UserRepository;

@Service
public class LocationService {
	
	@Autowired
	private UserRepository repo;

	@Autowired
	private LocationRepo count;
	
	public void create(LocationBody location) {
		LocationApp local;
		local = count.findOne(location.getNum());
		
		if(local != null){
			local.setAnnoumusNumber(local.getAnnoumusNumber() + 1);
			count.save(local);
		}else{
			local = new LocationApp();
			local.setAnnoumusNumber((long)1);
			local.setAreaCode(location.getNum());
			local.setUserNumber((long)0);
			local.setArea(location.getTitle());
			count.save(local);
		}
	}
	
	public void incrementNum(LocationBody location){
		LocationApp local;
		local = count.findOne(location.getNum());
		if(local != null){
			local.setAnnoumusNumber(local.getAnnoumusNumber() + 1);
			count.save(local);
		}
	}

	public void dec(LocationBody location) {
		LocationApp dec;
		dec = count.findOne(location.getNum());
		
		if(dec == null){
			dec = new LocationApp();
			dec.setAnnoumusNumber((long)1);
			dec.setAreaCode(location.getNum());
			dec.setUserNumber((long)0);
			count.save(dec);			
		}else{
			dec.setAnnoumusNumber(dec.getAnnoumusNumber() - 1);
			count.save(dec);
		}
	}
	
	public void incrementUserNum(LocationBody location){
		LocationApp local;
		local = count.findOne(location.getNum());
		if(local != null){
			local.setUserNumber(local.getUserNumber() + 1);
			count.save(local);
		}
	}
	
	public LocationApp getLocationById(Long id) {
		return count.findOne(id);
	}

	public LocationApp getLocationByName(String name) {
		return count.findByArea(name);
	}

	public List<LocationApp> getAllLocations() {
		return count.findAll();
	}

	public List<UserApp> getAllUsersByLocation(Long num) {
		return repo.findBySignupNum(num);
	}

	public String getConRateByLocal(Long id) {
		LocationApp local = count.findOne(id);
		if (local == null){
			return null;
		}
		else{
			String message = "Location: " + local.getArea() + "\n" + "has recieved "+ 
					Long.toString(local.getUserNumber()) + " User hits and "+ Long.toString(local.getAnnoumusNumber()) + " Anonymous hits" +
			"\nConversion Rate: " + Double.toString((double)local.getUserNumber()/(double)(local.getAnnoumusNumber() + local.getUserNumber()));
		return message;
		}
	}

}
