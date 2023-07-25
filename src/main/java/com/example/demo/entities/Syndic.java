package com.example.demo.entities;



import jakarta.persistence.Entity;



@Entity
public class Syndic  extends Personne{
	
	private String adresse ;
	private String  gard_type ;
	
	
    public Syndic() {
		super();
		
	}


	public Syndic(int id, String email, String nom, String prenom, String password) {
		super(id, email, nom, prenom, password);
		// TODO Auto-generated constructor stub
	}


	public Syndic(int id, String email, String nom, String prenom, String password,
               String adresse, String gard_type) {

    super(id, email, nom, prenom, password); 

     this.adresse = adresse;
     this.gard_type = gard_type;
    }
	

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse , String statut_day ) {
		this.adresse = adresse;
		this.gard_type = statut_day;
	}




	public String getStatut_day() {
		return gard_type;
	}




	public void setStatut_day(String statut_day) {
		this.gard_type = statut_day;
	}


	public void setAdresse(String adresse2) {
		this.adresse = adresse2;
		
	}


}
