package com.dar.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(length = 30, nullable = false)
    private String lieu;
    
    @Column(length = 2, nullable = false)
    private String jour;
    
    @Column(length = 2, nullable = false)
    private String mois;
    
    @Column(length = 4, nullable = false)
    private String annee;
    
    @Column(length = 2, nullable = false)
    private String heure;
    
    @Column(length = 2, nullable = false)
    private String minute;
    
    @Column(length = 2, nullable = false)
    private String duree;

    
    
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}
	
	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}
	
	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}
	
	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}
	
	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}
	
	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}


}

   