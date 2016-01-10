package com.dar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dar.dao.CafeDao;
import com.dar.model.Cafe;
import com.dar.model.Commentaire;
import com.dar.service.CafeService;

@Service
public class CafeServiceImpl implements CafeService {

	@Autowired
	private CafeDao cafeDao;
	
	@Transactional
	@Override
	public void saveCafe(Cafe cafe) {
		// TODO Auto-generated method stub
		cafeDao.saveCafe(cafe);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cafe> listCafes() {
		// TODO Auto-generated method stub
		return cafeDao.listCafes();
	}

	@Transactional(readOnly = true)
	@Override
	public Cafe getCafe(String nom) {
		// TODO Auto-generated method stub
		return cafeDao.getCafe(nom);
	}
	
	@Transactional
	@Override
	public List<Commentaire> commentaires(Cafe cafe) {
		// TODO Auto-generated method stub
		return cafeDao.commentaires(cafe);
	}
	
	@Transactional
	@Override
	public void deleteCafe(Cafe cafe) {
		// TODO Auto-generated method stub
		cafeDao.deleteCafe(cafe);
	}

	@Transactional
	@Override
	public List<Cafe> getCafeByArrondissement(int arrondissement){
		return cafeDao.getCafeByArrondissement(arrondissement);
	}
}
