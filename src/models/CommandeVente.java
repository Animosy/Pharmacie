package models;

import java.time.LocalDate;

public class CommandeVente {

    private String nomProduit;
    private String nomClient;
    private String quantite;
    private LocalDate date;
    private String modePaiment;
    
    
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getModePaiment() {
		return modePaiment;
	}
	public void setModePaiment(String modePaiment) {
		this.modePaiment = modePaiment;
	}
	public CommandeVente(String nomProduit, String nomClient, String quantite, LocalDate date, String modePaiment) {
		super();
		this.nomProduit = nomProduit;
		this.nomClient = nomClient;
		this.quantite = quantite;
		this.date = date;
		this.modePaiment = modePaiment;
	}


}
