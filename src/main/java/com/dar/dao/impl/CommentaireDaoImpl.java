package com.dar.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dar.dao.CommentaireDao;
import com.dar.model.Commentaire;

@Repository
public class CommentaireDaoImpl implements CommentaireDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		getSession().merge(commentaire);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commentaire> listCommentaires() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Commentaire.class);
		return criteria.list();
	}

	@Override
	public Commentaire getCommentaire(Long id) {
		// TODO Auto-generated method stub
		return (Commentaire) getSession().get(Commentaire.class, id);
	}

	@Override
	public void deleteCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		getSession().delete(commentaire);
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
