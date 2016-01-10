package com.dar.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	@Column(nullable=false)
//	private String nom;
	
	@Column( nullable = false, unique=true)
	private String email;
	
	@Column(length = 60, nullable = false)
	private String password;
	
	@Column(nullable=true)
	private int arrondissement;
	
	@OneToOne(cascade=CascadeType.ALL)
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
//	public String getNom(){
//		return nom;
//	}
//	
//	public void setNom(String nom){
//		this.nom = nom;
//	}

	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public int getArrondissement(){
		return arrondissement;
	}
	
	public void setArrondissement(int arrondissement){
		this.arrondissement = arrondissement;
	}
}
