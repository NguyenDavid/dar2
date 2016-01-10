package com.dar.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dar.dao.UserDao;
import com.dar.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		getSession().merge(user);
	}

	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return (User) getSession().get(User.class, id);
	}

	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<User>();
		Query query = getSession().createQuery("from User u where u.email = :email");
		query.setParameter("email", email);
		userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(User.class);
		return criteria.list();
	}
	
	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
