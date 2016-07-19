package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.UserApp;
import com.cooksys.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public void addUser(UserApp user) {
		repo.save(user);
	}

	public UserApp logIn(UserApp user) {
		UserApp temp = repo.findByUsername(user.getUsername());
		if (temp != null) {
			if (temp.getPassword().equals(user.getPassword())) {
				return temp;
			} else {
				return null;
			}
		}
		return null;

	}

	public List<UserApp> getAllUsers() {
		return repo.findAll();
	}

	public UserApp getUserById(Long id) {
		return repo.findOne(id);
	}

	public UserApp getUserByUsername(String name) {
		return repo.findByUsername(name);
	}

}
