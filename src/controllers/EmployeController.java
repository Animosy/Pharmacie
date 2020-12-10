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
import javafx.stage.Stage;
import models.Client;
import models.employe.Pharmacien;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static models.PharmacieInfos.listClient;

public class EmployeController implements Initializable {

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField adresseField;

    @FXML
    private ComboBox<String> typeEmp;

    @FXML
    private TableView<Client> employeTable;

    @FXML
    private TableColumn<Pharmacien,String> nom,prenom,adresse,type, salaire;
    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//    		nom.setCellValueFactory(new PropertyValueFactory<Pharmacien,String>("nom"));
//            prenom.setCellValueFactory(new PropertyValueFactory<Pharmacien,String>("prenom"));
//            adresse.setCellValueFactory(new PropertyValueFactory<Pharmacien,String>("adresse"));
//            type.setCellValueFactory(new PropertyValueFactory<Pharmacien,String>("Pharmacien"));
//            salaire.setCellValueFactory(new PropertyValueFactory<Pharmacien,String>("salaire"));
        

        // initialiser le tableau des clients 
        
//    	employeTable.setItems(listClient);
//    	employeTable.setEditable(true);
//
//        nom.setCellFactory(TextFieldTableCell.forTableColumn());
//        prenom.setCellFactory(TextFieldTableCell.forTableColumn());
//        adresse.setCellFactory(TextFieldTableCell.forTableColumn());
//        salaire.setCellFactory(TextFieldTableCell.forTableColumn());

        ArrayList<String> list = new ArrayList<String>();
        list.add("Pharmacien");
        list.add("preparateur de commande");
        ObservableList<String> obList = FXCollections.observableList(list);
        typeEmp.getItems().clear();
        typeEmp.setItems(obList);


    }

    // ajouter un client dans la liste des clients
    
    public void ajouterButtonClicked (ActionEvent event) {

//        Client client = new Client (nomField.getText(),prenomField.getText(),adresseField.getText(),typeEmp.getSelectionModel().getSelectedItem().toString());
//            listClient.add(client);
//            nomField.clear();
//            prenomField.clear();
//            adresseField.clear();
    }

    //supprimer un client
    public void supprimerButtonClicked (ActionEvent event) {
        Client client  = employeTable.getSelectionModel().getSelectedItem();
        listClient.remove(client);
    }

    // retourner au menu principal
    public void retourButtonClicked (ActionEvent event) throws IOException {

        Stage stage = (Stage) nomField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
