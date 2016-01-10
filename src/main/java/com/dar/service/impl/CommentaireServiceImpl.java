package com.dar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dar.dao.CommentaireDao;
import com.dar.model.Commentaire;
import com.dar.service.CommentaireService;

@Service
public class CommentaireServiceImpl implements CommentaireService {

	@Autowired
	private CommentaireDao commentaireDao;
	
	@Transactional
	@Override
	public void saveCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		commentaireDao.saveCommentaire(commentaire);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Commentaire> listCommentaires() {
		// TODO Auto-generated method stub
		return commentaireDao.listCommentaires();
	}

	@Transactional(readOnly = true)
	@Override
	public Commentaire getCommentaire(Long id) {
		// TODO Auto-generated method stub
		return commentaireDao.getCommentaire(id);
	}

	@Transactional
	@Override
	public void deleteCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		commentaireDao.deleteCommentaire(commentaire);
	}

}
