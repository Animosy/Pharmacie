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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import models.AchatCommande;
import models.PharmacieInfos;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static models.PharmacieInfos.listCommande;

public class CommandeController implements Initializable {

    @FXML
    private ComboBox<String> pharmacieFeild;

    @FXML
    private ComboBox<String> compteField;

    @FXML
    private ComboBox<String> produitFeild;
    
    @FXML
    private TextField quantiteField;

    @FXML
    private DatePicker dateField;
    
    @FXML
    private TableView<AchatCommande> achatTable;

    @FXML
    private TableColumn<AchatCommande , String> nomPharmacie,nomProduit,quantite,compteC;

    @FXML
    private TableColumn<AchatCommande, LocalDate> date;
    
    // initialiser le tableau des commandes avec la liste des commandes
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	
    	ArrayList<String> listProduits = new ArrayList<String>();
    	for(int i=0;i<PharmacieInfos.listProduitStocke.size();i++) {
    		listProduits.add(PharmacieInfos.listProduitStocke.get(i).getNom());
    	}
    	
    	ObservableList<String> obListP = FXCollections.observableList(listProduits);
    	produitFeild.getItems().clear();
    	produitFeild.setItems(obListP);
        
    	
    	ArrayList<String> listPharmacies = new ArrayList<String>();
    	for(int i=0;i<PharmacieInfos.listPharmacies.size();i++) {
    		listPharmacies.add(PharmacieInfos.listPharmacies.get(i).getNom());
    	}
    	
    	ObservableList<String> obList = FXCollections.observableList(listPharmacies);
        pharmacieFeild.getItems().clear();
        pharmacieFeild.setItems(obList);
        
        
        nomPharmacie.setCellValueFactory(new PropertyValueFactory<AchatCommande,String>("pharmacie"));
        nomProduit.setCellValueFactory(new PropertyValueFactory<AchatCommande,String>("produit"));
        quantite.setCellValueFactory(new PropertyValueFactory<AchatCommande,String>("quantite"));
        compteC.setCellValueFactory(new PropertyValueFactory<AchatCommande,String>("compteBancaire"));
        date.setCellValueFactory(new PropertyValueFactory<AchatCommande,LocalDate>("date"));
        
        achatTable.setItems(listCommande);
        achatTable.setEditable(true);

        nomPharmacie.setCellFactory(TextFieldTableCell.forTableColumn());
        nomProduit.setCellFactory(TextFieldTableCell.forTableColumn());
        quantite.setCellFactory(TextFieldTableCell.forTableColumn());
        compteC.setCellFactory(TextFieldTableCell.forTableColumn());
        compteC.setCellFactory(TextFieldTableCell.forTableColumn());


    }

    //ajouter une commande a la liste des commandes
    public void vendreButtonClicked (ActionEvent event) {
//    	AchatCommande commande = new AchatCommande (pharmacieFeild.getSelectionModel().getSelectedItem().toString(),produitFeild.getSelectionModel().getSelectedItem().toString(),quantiteField.getText(), compteField.getSelectionModel().getSelectedItem().toString(), dateField.getValue());
//        listCommande.add(commande);
//
//        quantiteField.clear();
//    }
//
//    //supprimer une commande du tableau ( de la liste )
//    public void supprimerButtonClicked (ActionEvent event) {
//        AchatCommande commande = achatTable.getSelectionModel().getSelectedItem();
//        listCommande.remove(commande);
//
//    }
//
//    // vendre un produit
//    public void vendreButtonClicked (ActionEvent event) {
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
    // retourner au menu principal
    public void retourButtonClicked (ActionEvent event) throws IOException {

        Stage stage = (Stage) quantiteField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/MenuCommand.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    
}
