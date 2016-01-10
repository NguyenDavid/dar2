package com.dar.dao;

import java.util.List;

import com.dar.model.Commentaire;

public interface CommentaireDao {
	/*
	 * CREATE and UPDATE
	 */
	public void saveCommentaire(Commentaire commentaire);
	
	/*
	 * READ
	 */
	public List<Commentaire> listCommentaires();
	
	public Commentaire getCommentaire(Long id);
	
	public void deleteCommentaire(Commentaire commentaire);
}
