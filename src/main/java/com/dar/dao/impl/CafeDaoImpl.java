package com.dar.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dar.dao.CafeDao;
import com.dar.model.Cafe;
import com.dar.model.Commentaire;

@Repository
public class CafeDaoImpl implements CafeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveCafe(Cafe cafe) {
		// TODO Auto-generated method stub
		getSession().merge(cafe);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cafe> listCafes() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Cafe.class);
		return criteria.list();
	}

	@Override
	public Cafe getCafe(String nom) {
		// TODO Auto-generated method stub
		List<Cafe> cafeList = new ArrayList<Cafe>();
		Query query = getSession().createQuery("from Cafe c where c.nom = :nom");
		query.setParameter("nom", nom);
		cafeList = query.list();
		if(cafeList.size()>0){
			return cafeList.get(0);
		}
		else{
			return null;
		}
	}
	
	@Override
	public List<Commentaire> commentaires(Cafe cafe) {
		// TODO Auto-generated method stub
		List<Commentaire> commentairesList = new ArrayList<Commentaire>();
		Query query = getSession().createQuery("from Commentaire c where c.cafe = :cafe");
		query.setParameter("cafe", cafe);
		commentairesList = query.list();
		return commentairesList;
	}

	@Override
	public void deleteCafe(Cafe cafe) {
		// TODO Auto-generated method stub
		getSession().delete(cafe);
	}
	
	@Override
	public List<Cafe> getCafeByArrondissement(int arrondissement) {
		List<Cafe> cafeList = new ArrayList<Cafe>();
		Query query = getSession().createQuery("from Cafe c where c.arrondissement = :arrondissement");
		query.setParameter("arrondissement", arrondissement);
		cafeList = query.list();
		return cafeList;
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
