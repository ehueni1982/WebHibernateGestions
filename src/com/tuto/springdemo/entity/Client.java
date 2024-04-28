package com.tuto.springdemo.entity;

import javax.persistence.*;
import javax.websocket.OnClose;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Identity la valeur de la clé primaire sera générée automatiquement
	@Column(name ="id")
	private int id;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="email")
	private String email;
	
//Contructeur avec paramètres
	public Client(int id, String prenom, String nom, String email) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
	}
	//Contructeur sans 
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Getters et Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Client [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + "]";
	}
	
	
	
	
	
	
	

}
