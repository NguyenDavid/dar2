package com.dar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cafe")
public class Cafe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nom;

	@Column
	private double x;
	
	@Column
	private double y;
	
	@Column( nullable = false )
	private int arrondissement;
	
	@Column( nullable = false )
	private String adresse;

	@OneToMany(mappedBy="cafe")
	@Column(nullable = true)
	private List<Commentaire> commentaires;
	
	public Cafe(){
		
	}
	
	public Cafe(String nom, double x, double y, int arrondissement, String adresse) {
		super();
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.arrondissement = arrondissement;
		this.adresse = adresse;
		this.commentaires = new ArrayList<Commentaire>();
	}
	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getArrondissement() {
		return arrondissement;
	}

	public void setArrondissement(int arrondissement) {
		this.arrondissement = arrondissement;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public List<Commentaire> getCommentaires(){
		return this.commentaires;
	}
	public double distance(Cafe c2){
		double x2 = c2.getX();
		double y2 = c2.getY();
		return Math.sqrt((x2-x)*(x2-x)+(y2-y)*(y2-y));
	}
}
