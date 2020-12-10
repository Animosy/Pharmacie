package models;

public class Client {

    private String nom;
    private String prenom;
    private String adresse;
    private String modePaiement;
    
	public Client(String nom, String prenom, String adresse, String modePaiement) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.modePaiement = modePaiement;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getModePaiement() {
		return modePaiement;
	}
	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

   


}
