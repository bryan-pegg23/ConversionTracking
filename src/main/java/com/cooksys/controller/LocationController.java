package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.LocationApp;
import com.cooksys.entity.UserApp;
import com.cooksys.model.LocationBody;
import com.cooksys.service.LocationService;
import com.cooksys.service.UserService;

@RestController
@RequestMapping("Location")
public class LocationController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private LocationService locationService;

	@RequestMapping(method = RequestMethod.POST)
	public String createLocation(@RequestBody LocationBody local) {
		if(local.getTitle() == null){
			locationService.incrementNum(local);
			return "got location";
		} else{
			locationService.create(local);
			return "cretaed location";
		}
	}
	
	@RequestMapping(value = "getAll", method=RequestMethod.GET)
	public List<LocationApp> getAllLocations() {
		return locationService.getAllLocations();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public LocationApp getLocation(@PathVariable Long id) {
		return locationService.getLocationById(id);
	}
	
	@RequestMapping(value="name/{name}", method=RequestMethod.GET)
	public LocationApp getLocationByName(@PathVariable String name) {
		return locationService.getLocationByName(name);
	}
	
	@RequestMapping(value="users/{id}", method=RequestMethod.GET)
	public List<UserApp> getUsersByLocation(@PathVariable Long id) {
		return locationService.getAllUsersByLocation(id);
	}
	
	@RequestMapping(value="conversion/{id}", method=RequestMethod.GET)
	public String getLocationConversion(@PathVariable Long id) {
		return locationService.getConRateByLocal(id);
	}

}
