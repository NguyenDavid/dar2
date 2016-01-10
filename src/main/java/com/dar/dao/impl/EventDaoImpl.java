package com.dar.dao.impl;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dar.dao.EventDao;
import com.dar.model.Event2;

@Repository
public class EventDaoImpl implements EventDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveEvent(Event2 event) {
		getSession().merge(event);

	}

	@SuppressWarnings("unchecked")
	public List<Event2> listEvents() {

		return getSession().createCriteria(Event2.class).list();
	}

	public Event2 getEvent(Long id) {
		return (Event2) getSession().get(Event2.class, id);
	}

	public void deleteEvent(Long id) {

		Event2 event = getEvent(id);

		if (null != event) {
			getSession().delete(event);
		}

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
