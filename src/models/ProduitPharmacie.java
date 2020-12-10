package models;

import java.time.LocalDate;


public class ProduitPharmacie {

	public ProduitPharmacie(String nom, String type, String quantite_c, String prix_achat, String prix_vente,
			LocalDate dateExp, String pharmacie) {
		super();
		this.nom = nom;
		this.type = type;
		this.quantite_c = quantite_c;
		this.prix_achat = prix_achat;
		this.prix_vente = prix_vente;
		this.dateExp = dateExp;
		this.pharmacie = pharmacie;
	}
	public String nom;
    public String type;
    public String quantite_c;
    public String prix_achat;
    public String prix_vente;
    public LocalDate dateExp;
    public String pharmacie;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuantite_c() {
		return quantite_c;
	}
	public void setQuantite_c(String quantite_c) {
		this.quantite_c = quantite_c;
	}
	public String getPrix_achat() {
		return prix_achat;
	}
	public void setPrix_achat(String prix_achat) {
		this.prix_achat = prix_achat;
	}
	public String getPrix_vente() {
		return prix_vente;
	}
	public void setPrix_vente(String prix_vente) {
		this.prix_vente = prix_vente;
	}
	public LocalDate getDateExp() {
		return dateExp;
	}
	public void setDateExp(LocalDate dateExp) {
		this.dateExp = dateExp;
	}
	public String getPharmacie() {
		return pharmacie;
	}
	public void setPharmacie(String pharmacie) {
		this.pharmacie = pharmacie;
	}
    
    

}
