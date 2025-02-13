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




	
	
}
 
