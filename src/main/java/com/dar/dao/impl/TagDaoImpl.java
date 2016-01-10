package com.dar.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dar.dao.TagDao;
import com.dar.model.Tag;

@Repository
public class TagDaoImpl implements TagDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveTag(Tag tag) {
		// TODO Auto-generated method stub
		getSession().merge(tag);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tag> listTags() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Tag.class);
		return criteria.list();
	}

	@Override
	public Tag getTag(String nom) {
		// TODO Auto-generated method stub
		return (Tag) getSession().get(Tag.class, nom);
	}

//	@Override
//	public List<String> publications(String nom) {
//		// TODO Auto-generated method stub
//		Tag t = getTag(nom);
//		List<String> publicationsList = new ArrayList<String>(t.getPublications());
//		return publicationsList;
//	}

	@Override
	public void deleteTag(Tag tag) {
		// TODO Auto-generated method stub
		getSession().delete(tag);
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
