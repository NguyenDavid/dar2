package com.dar.service;

import java.util.List;

import com.dar.model.Commentaire;

public interface CommentaireService {
	public void saveCommentaire(Commentaire commentaire);
	
	public List<Commentaire> listCommentaires();
	
	public Commentaire getCommentaire(Long id);
	
	
	
	public void deleteCommentaire(Commentaire commentaire);
}
