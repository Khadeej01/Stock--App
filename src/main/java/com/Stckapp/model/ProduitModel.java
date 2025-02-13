package com.Stckapp.model;

public class ProduitModel {
	private int id ;
	private String nom;
	private String description;
	private int quantite ;
	private int prix ;
	private String categorie ;
	
	
	public ProduitModel (int id, String nom,  String description, int quantite , int prix , String categorie) {
	
	this.id = id;
	this.nom = nom;
	this.description = description;
	this.quantite = quantite;
	this.prix = prix;
	this.categorie = categorie; 
}
	public ProduitModel ( String nom,  String description, int quantite , int prix , String categorie) {
		this.nom = nom;
		this.description = description;
		this.quantite = quantite;
		this.prix = prix;
		this.categorie = categorie; 
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return "ProduitModel [id=" + id + ", nom=" + nom + ", description=" + description + ", quantite=" + quantite
				+ ", prix=" + prix + ", categorie=" + categorie + "]";
	}
	

	
	
}
 
