package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.CommandeVente;
import models.PharmacieInfos;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static models.PharmacieInfos.listVente;

public class VenteController implements Initializable {

    @FXML
    private ComboBox<String> pharmacie;

    @FXML
    private ComboBox<String> produit;
    
    @FXML
    private ComboBox<String> modePaiment;
    
    @FXML
    private ComboBox<String> nomClientField;
    
    @FXML
    private TextField quantiteField;
    
    @FXML
    private DatePicker dateField;

    @FXML
    private TableView<CommandeVente> venteTable;

    @FXML
    private TableColumn<CommandeVente,String> nomProduit,quantite,nomClient,modeP;
    @FXML
    private TableColumn<CommandeVente, LocalDate> date;
    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    	
    	ArrayList<String> listClients = new ArrayList<String>();
    	for(int i=0;i<PharmacieInfos.listClient.size();i++) {
    		listClients.add(PharmacieInfos.listClient.get(i).getNom());
    	}
    	
    	ObservableList<String> obListC = FXCollections.observableList(listClients);
    	nomClientField.getItems().clear();
    	nomClientField.setItems(obListC);
    	
    	
    	ArrayList<String> listProduits = new ArrayList<String>();
    	for(int i=0;i<PharmacieInfos.listProduitStocke.size();i++) {
    		listProduits.add(PharmacieInfos.listProduitStocke.get(i).getNom());
    	}
    	
    	ObservableList<String> obListP = FXCollections.observableList(listProduits);
    	produit.getItems().clear();
    	produit.setItems(obListP);
        
    	
    	ArrayList<String> listPharmacies = new ArrayList<String>();
    	for(int i=0;i<PharmacieInfos.listPharmacies.size();i++) {
    		listPharmacies.add(PharmacieInfos.listPharmacies.get(i).getNom());
    	}
    	
    	ObservableList<String> obListPh = FXCollections.observableList(listPharmacies);
    	pharmacie.getItems().clear();
    	pharmacie.setItems(obListPh);
    	
        nomClient.setCellValueFactory(new PropertyValueFactory<CommandeVente,String>("nomClient"));
        nomProduit.setCellValueFactory(new PropertyValueFactory<CommandeVente,String>("nomProduit"));
        quantite.setCellValueFactory(new PropertyValueFactory<CommandeVente,String>("quantite"));
        modeP.setCellValueFactory(new PropertyValueFactory<CommandeVente,String>("modePaiment"));
        date.setCellValueFactory(new PropertyValueFactory<CommandeVente,LocalDate>("date"));

        venteTable.setItems(listVente);
        venteTable.setEditable(true);

    }

    // vendre un produit
    public void vendreButtonClicked (ActionEvent event) {
//    	ProduitPharmacie med = null;
//    	// verifier si le produit est un medicament qui existe dans le stock des medicaments
//    	for(int i=0;i<PharmacieInfos.listProduitStocke.size();i++) {
//    		if(PharmacieInfos.listProduitStocke.get(i).getNom().equals(nomProduit.getText())) {
//    			med = PharmacieInfos.listProduitStocke.get(i);
//    			break;
//    		}
//    	}
//    	
//    	if(med != null) {
//    		// verifier si la quantite est disponible dans le stock
//    		if (Integer.parseInt(quantiteField.getText()) <= Integer.parseInt(med.getQuantite_c()) ) {
//    					// calculer le prix du medicament
//    					double prix = Double.parseDouble(med.getPrix_vente()) * Double.parseDouble(quantiteField.getText()) ;
//    					
//    					// verifier si le client est assure pour beneficier d'un rembourcement
////    					if(modePaiment.getSelectionModel().getSelectedItem().toString().equals("Carte Visa")) {
////    						prix = prix - ( Double.parseDouble(med.getTauxRembourcement()) * Double.parseDouble(quantiteField.getText()) );
////    					}
//    					
//    					// demande de confirmation de la vente
//    					Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                        alert.setTitle("Prix Final");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Le prix final du Medicament = "+prix+" D.A \n Confirmer la vente ? ");
//                        alert.showAndWait();
//                        
//                        // si la vente a ete confirmer
//                        if(alert.getResult() == ButtonType.OK) {                         	
//                        	CommandeVente vente = new CommandeVente(nomProduit.getText(),
//                        			nomClientField.getText(),
//                        			quantiteField.getText(),
//                        			dateField.getValue(),
//                        			modePaiment.getSelectionModel().getSelectedItem().toString());
//                        	
//                        	med.setQuantite_c(Integer.toString(Integer.parseInt(med.quantite_c)-Integer.parseInt(quantiteField.getText())));
//                        	listVente.add(vente);
//                        	venteTable.setItems(listVente);
//                        }
//                        
//    			}
//    		else {
//    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("ERROR");
//                alert.setHeaderText(null);
//                alert.setContentText("Quantite insufisante dans le Stock");
//                alert.showAndWait();
//    		}
//    	}
//
//
//        nomClientField.clear();
//        quantiteField.clear();

    }

    // aller directement a l'interface de gestion des commandes pour commander un produit
    public void commandeButtonClicked (ActionEvent event) throws IOException {

        Stage stage = (Stage) nomClientField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/Commande.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    // retourner au menu principal
    public void retourButtonClicked (ActionEvent event) throws IOException {

        Stage stage = (Stage) nomClientField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/MenuCommand.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
