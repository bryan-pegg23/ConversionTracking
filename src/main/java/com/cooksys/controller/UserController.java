package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.UserApp;
import com.cooksys.model.LocationBody;
import com.cooksys.model.UserBody;
import com.cooksys.service.LocationService;
import com.cooksys.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private LocationService numberService;

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public void register(@RequestBody UserBody body) {
		UserApp user = new UserApp();
		user.setPassword(body.getPassword());
		user.setUsername(body.getUsername());
		user.setSignupNum(body.getNum());
		user.setAdmin(body.getAdmin());
		userService.addUser(user);
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public UserApp logIn(@RequestBody UserBody body) {
		UserApp user = new UserApp();
		user.setPassword(body.getPassword());
		user.setUsername(body.getUsername());
		user.setAdmin(body.getAdmin());
		UserApp result = userService.logIn(user);
		LocationBody localbod = new LocationBody();
		if (body.getNum() != null) {
			localbod.setNum(body.getNum());
			localbod.setTitle(null);
			numberService.dec(localbod);
			numberService.incrementUserNum(localbod);
		}
		return result;
	}

	@RequestMapping(value = "allUsers", method = RequestMethod.GET)
	public List<UserApp> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserApp getUser(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@RequestMapping(value = "name/{username}")
	public UserApp getUserByName(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}

}
