package com.dar.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tag")
public class Tag {

	@Id
	@Column(nullable = false)
	private String nom;
	
	//@OneToMany(mappedBy="tag")
//	@Column(nullable = true)
//	private List<String> publications;
	
	public String getNom(){
		return nom;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
//	public Collection<String> getPublications(){
//		return publications;
//	}
	
}
