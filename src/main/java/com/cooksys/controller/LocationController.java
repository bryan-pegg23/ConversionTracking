package com.cooksys.controller;

import java.text.ParseException;
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
import com.cooksys.model.LocationResponse;
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
	
	@RequestMapping(value="day", method=RequestMethod.GET)
	public List<LocationResponse> getAllLocationsByDay() throws ParseException {
		return LocationResponse.getList(locationService.getAllLocationsByDaysNum(0L));
	}

	@RequestMapping(value="week", method=RequestMethod.GET)
	public List<LocationResponse> getAllLocationsByWeek() throws ParseException {
		return LocationResponse.getList(locationService.getAllLocationsByDaysNum(7L));
	}
	
	@RequestMapping(value="month", method=RequestMethod.GET)
	public List<LocationResponse> getAllLocationsByMonth() throws ParseException {
		return LocationResponse.getList(locationService.getAllLocationsByDaysNum(30L));
	}
	
	@RequestMapping(value="year", method=RequestMethod.GET)
	public List<LocationResponse> getAllLocationsByYear() throws ParseException {
		return LocationResponse.getList(locationService.getAllLocationsByDaysNum(360L));
	}
	
	@RequestMapping(value="day/{id}", method=RequestMethod.GET)
	public LocationResponse getLocationByDay(@PathVariable("id") Long id) throws ParseException {
		return LocationResponse.get(locationService.getLocationByDaysNum(id, 0L));
	}
	
	@RequestMapping(value="week/{id}", method=RequestMethod.GET)
	public LocationResponse getLocationByWeek(@PathVariable("id") Long id) throws ParseException {
		return LocationResponse.get(locationService.getLocationByDaysNum(id, 7L));
	}
	
	@RequestMapping(value="month/{id}", method=RequestMethod.GET)
	public LocationResponse getLocationByMonth(@PathVariable("id") Long id) throws ParseException {
		return LocationResponse.get(locationService.getLocationByDaysNum(id, 30L));
	}
	
	@RequestMapping(value="year/{id}", method=RequestMethod.GET)
	public LocationResponse getLocationByYear(@PathVariable("id") Long id) throws ParseException {
		return LocationResponse.get(locationService.getLocationByDaysNum(id, 360L));
	}
	
}
