package com.dar.dao;

import java.util.List;

import com.dar.model.User;

public interface UserDao {
	/*
	 * CREATE and UPDATE
	 */
	public void saveUser(User user); // create and update

	public User getUserById(long id);

	public User getUserByEmail(String email);

	public List<User> getUsers();
}
