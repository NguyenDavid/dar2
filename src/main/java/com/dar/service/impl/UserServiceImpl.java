package com.dar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dar.dao.UserDao;
import com.dar.model.User;
import com.dar.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDao.saveUser(user);
	}

	@Transactional(readOnly = true)
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	@Transactional(readOnly = true)
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.getUserByEmail(email);
	}

	@Transactional(readOnly = true)
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

}
