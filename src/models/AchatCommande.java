package models;

import java.time.LocalDate;

public class AchatCommande {

    private String pharmacie;
    private String produit;
    private String quantite;
    private String compteBancaire;
    private LocalDate date;
    
	public AchatCommande(String pharmacie, String produit, String quantite, String compteBancaire, LocalDate date) {
		super();
		this.pharmacie = pharmacie;
		this.produit = produit;
		this.quantite = quantite;
		this.compteBancaire = compteBancaire;
		this.date = date;
	}

	public String getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(String pharmacie) {
		this.pharmacie = pharmacie;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public String getCompteBancaire() {
		return compteBancaire;
	}

	public void setCompteBancaire(String compteBancaire) {
		this.compteBancaire = compteBancaire;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	
}
