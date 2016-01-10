package com.dar.service;

import java.util.List;

import com.dar.model.User;

public interface UserService {
	public void saveUser(User user);

	public User getUserById(Long id);

	public User getUserByEmail(String email);

	public List<User> getUsers();
}
