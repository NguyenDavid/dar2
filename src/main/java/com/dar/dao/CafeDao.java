package com.dar.dao;

import java.util.List;

import com.dar.model.Cafe;
import com.dar.model.Commentaire;

public interface CafeDao {
	
	/*
	 * CREATE and UPDATE
	 */
	public void saveCafe(Cafe cafe);
	
	/*
	 * READ
	 */
	public List<Cafe> listCafes();
	
	public Cafe getCafe(String nom);
	
	public List<Commentaire> commentaires(Cafe cafe);
	
	public void deleteCafe(Cafe cafe);
	
	public List<Cafe> getCafeByArrondissement(int arrondissement);
}
