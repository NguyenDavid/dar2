package com.dar.service;

import java.util.List;

import com.dar.model.Cafe;
import com.dar.model.Commentaire;

public interface CafeService {
	
	public void saveCafe(Cafe cafe);
	
	public List<Cafe> listCafes();
	
	public Cafe getCafe(String nom);
	
	public List<Commentaire> commentaires(Cafe cafe);
	
	public void deleteCafe(Cafe cafe);
	
	public List<Cafe> getCafeByArrondissement(int arrondissement);
}
