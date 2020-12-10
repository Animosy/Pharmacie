package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import models.ProduitPharmacie;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static models.PharmacieInfos.listProduitStocke;

public class ProduitController implements Initializable {

    @FXML
    private TextField nomProduit;

    @FXML
    private TextField typeProduit;

    @FXML
    private TextField prixAchat;

    @FXML
    private TextField quantiteField;

    @FXML
    private TextField prixVente;

    @FXML
    private DatePicker dateField;

    @FXML
    private TableView<ProduitPharmacie> produitTable;

    @FXML
    private TableColumn<ProduitPharmacie,String> nom,type,quantite_c,prix_achat,prix_vente,pharmacie_c;

    @FXML
    private TableColumn<ProduitPharmacie, LocalDate> date;

    @FXML
    private ComboBox<String> pharmacieProduit;
    
    @FXML
    private Button ajouter;

    

    // initialiser le tableau des medicaments
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	

        nom.setCellValueFactory(new PropertyValueFactory<ProduitPharmacie,String>("nom"));
        type.setCellValueFactory(new PropertyValueFactory<ProduitPharmacie,String>("type"));
        quantite_c.setCellValueFactory(new PropertyValueFactory<ProduitPharmacie,String>("quantite_c"));
        pharmacie_c.setCellValueFactory(new PropertyValueFactory<ProduitPharmacie,String>("pharmacie"));
        prix_achat.setCellValueFactory(new PropertyValueFactory<ProduitPharmacie,String>("prix_achat"));
        prix_vente.setCellValueFactory(new PropertyValueFactory<ProduitPharmacie,String>("prix_vente"));
        date.setCellValueFactory(new PropertyValueFactory<ProduitPharmacie,LocalDate>("dateExp"));
        
        produitTable.setItems(listProduitStocke);
        produitTable.setEditable(true);

        nom.setCellFactory(TextFieldTableCell.forTableColumn());
        type.setCellFactory(TextFieldTableCell.forTableColumn());
        quantite_c.setCellFactory(TextFieldTableCell.forTableColumn());
        pharmacie_c.setCellFactory(TextFieldTableCell.forTableColumn());
        prix_achat.setCellFactory(TextFieldTableCell.forTableColumn());
        prix_vente.setCellFactory(TextFieldTableCell.forTableColumn());



    }

    // ajouter un medicament
    public void ajouterProduitButtonClicked (ActionEvent event) {
    	ProduitPharmacie produit;
    	
    		// creer un medicament externe
    		 produit = new ProduitPharmacie(
    				 nomProduit.getText(),
                    typeProduit.getText(),
                    quantiteField.getText(),
                    prixAchat.getText(),
                    prixVente.getText(),
                    dateField.getValue(),
                    pharmacieProduit.getSelectionModel().getSelectedItem().toString()
                    );

            listProduitStocke.add(produit);

            nomProduit.clear();
            typeProduit.clear();
            quantiteField.clear();
            prixAchat.clear();
        quantiteField.clear();
        prixVente.clear();

    }

    // supprimer un medicament selectionnes
    public void supprimerProduitButtonClicked (ActionEvent event) {
        ProduitPharmacie produit = produitTable.getSelectionModel().getSelectedItem();
        listProduitStocke.remove(produit);
    }

    // retouner au menu principal
    public void retourButtonClicked (ActionEvent event) throws IOException {

        Stage stage = (Stage) nomProduit.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
