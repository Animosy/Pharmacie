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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import models.Client;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static models.PharmacieInfos.listClient;

public class ClientController implements Initializable {

    @FXML
    private TextField nomClient;

    @FXML
    private TextField prenomClient;

    @FXML
    private TextField adresseClient;

    @FXML
    private ComboBox<String> modePaiement;

    @FXML
    private TableView<Client> clientTable;

    @FXML
    private TableColumn<Client,String> nom,prenom,adresse,modePaiementColumn;
    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Client,String>("prenom"));
        adresse.setCellValueFactory(new PropertyValueFactory<Client,String>("adresse"));
        modePaiementColumn.setCellValueFactory(new PropertyValueFactory<Client,String>("modePaiement"));

        // initialiser le tableau des clients 
        
        clientTable.setItems(listClient);
        clientTable.setEditable(true);

        nom.setCellFactory(TextFieldTableCell.forTableColumn());
        prenom.setCellFactory(TextFieldTableCell.forTableColumn());
        adresse.setCellFactory(TextFieldTableCell.forTableColumn());
        modePaiementColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        ArrayList<String> list = new ArrayList<String>();
        list.add("Carte Visa");
        list.add("Master Carte");
        ObservableList<String> obList = FXCollections.observableList(list);
        modePaiement.getItems().clear();
        modePaiement.setItems(obList);


    }

    // ajouter un client dans la liste des clients
    
    public void ajouterButtonClicked (ActionEvent event) {

        Client client = new Client (nomClient.getText(),prenomClient.getText(),adresseClient.getText(),modePaiement.getSelectionModel().getSelectedItem().toString());
            listClient.add(client);
            nomClient.clear();
            prenomClient.clear();
            adresseClient.clear();
    }

    //supprimer un client
    public void supprimerButtonClicked (ActionEvent event) {
        Client client  = clientTable.getSelectionModel().getSelectedItem();
        listClient.remove(client);
    }

    // retourner au menu principal
    public void retourButtonClicked (ActionEvent event) throws IOException {

        Stage stage = (Stage) nomClient.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
