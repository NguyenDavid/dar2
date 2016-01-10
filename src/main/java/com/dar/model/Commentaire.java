package com.dar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commentaire")
public class Commentaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String contenu;

	@ManyToOne
	private Cafe cafe;
	
	@Column(nullable = false)
	private String owner;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	public Cafe getCafe(){
		return this.cafe;
	}
	
	public void setCafe(Cafe cafe){
		this.cafe = cafe;
	}
	
	public String getOwner(){
		return this.owner;
	}
	
	public void setOwner(String owner){
		this.owner = owner;
	}
}
