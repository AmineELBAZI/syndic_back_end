package com.example.demo.entities;





import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Proprietaire extends Personne {
	
	private String type;
	private String nom_vehicule;
	private String matricule_vehicule;
	private int depense;	
	private boolean depense_statu ;
	
	@OneToMany
	private List<Apartment>  apartment;
	
	  public Proprietaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proprietaire(int id, String email, String nom, String prenom, String password) {
		super(id, email, nom, prenom, password);
		// TODO Auto-generated constructor stub
	}

	public Proprietaire(int id, String email, String nom, String prenom, String password,
              String type,Apartment  apartment,
              LocalDate date_debut, LocalDate date_fin, String nom_vehicule,
              String matricule_vehicule, int depense, boolean depense_statu) {

super(id, email, nom, prenom, password); 

this.type = type;
this.nom_vehicule = nom_vehicule;
this.matricule_vehicule = matricule_vehicule;
this.depense = depense;
this.depense_statu = depense_statu;
}
	
	public int getDepense() {
		return depense;
	}
	public void setDepense(int depense) {
		this.depense = depense;
	}
	public boolean isDepense_statu() {
		return depense_statu;
	}
	public void setDepense_statu(boolean depense_statu) {
		this.depense_statu = depense_statu;
	}
	

	
	public String getNom_vehicule() {
		return nom_vehicule;
	}
	public void setNom_vehicule(String nom_vehicule) {
		this.nom_vehicule = nom_vehicule;
	}
	public String getMatricule_vehicule() {
		return matricule_vehicule;
	}
	public void setMatricule_vehicule(String matricule_vehicule) {
		this.matricule_vehicule = matricule_vehicule;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrix() {
		return depense;
	}
	public void setPrix(int depense) {
		this.depense = depense;
	}
	
	
	
	
	
	
	

}
