package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.employe.Pharmacien;
import models.pharmacie.Pharmacie;

import java.time.LocalDate;

public class PharmacieInfos {

    public static ObservableList<ProduitPharmacie> listProduitStocke = FXCollections.observableArrayList(
    		new ProduitPharmacie("Amodex 1g", "Comprimé", "150", "5.46", "30", LocalDate.of(2022, 11, 20),  "fabriquant 1"),
            new ProduitPharmacie("Omeprazole", "Antisecretoire", "150", "5.66", "50", LocalDate.of(2021, 01, 19), "fabriquant 2"),
            new ProduitPharmacie("Benzodiazepine", "Antihistaminique", "85", "5.13", "42", LocalDate.of(2022, 8, 4), "fabriquant 3")
    		);
    
    public static ObservableList<Pharmacie> listPharmacies = FXCollections.observableArrayList(
    		new Pharmacie("La croix", 20, 69, "89876543", new Pharmacien("Zouhair", "Maazouz", "1 Rue 4", 1500)),
    		new Pharmacie("La croix", 20, 69, "89876543", new Pharmacien("Zouhair", "Maazouz", "1 Rue 4", 1500)),
    		new Pharmacie("La croix", 20, 69, "89876543", new Pharmacien("Zouhair", "Maazouz", "1 Rue 4", 1500))
    		);

    public static ObservableList<ProduitParapharmaceutique> listProduitParapharm = FXCollections.observableArrayList(
            new ProduitParapharmaceutique("Gel Vichy","Gel Hydroalcoolique","350","55"),
            new ProduitParapharmaceutique("Masque protection","FFP2","200","60"),
            new ProduitParapharmaceutique("Lingette waterwipe","Coton Absorbante","440","30"),
            new ProduitParapharmaceutique("Gants","Medicale","220","40"),
            new ProduitParapharmaceutique("Brosse a dent OraleB","Electrique","690","24")
    );

    public static ObservableList<Client> listClient = FXCollections.observableArrayList(
            new Client ("Kendjouh","Soheib","2 Rue A","Carte Visa"),
            new Client ("Bekdouche","Ali","2 Rue B","Carte Visa"),
            new Client ("Karoun","Yacine","2 Rue C","Master Carte")
    );

    public static ObservableList<AchatCommande> listCommande = FXCollections.observableArrayList(
            new AchatCommande("La croix","Amodex 1g","3","Compte LCL",LocalDate.of(2022, 11, 20))
    );

    public static  ObservableList<CommandeVente> listVente = FXCollections.observableArrayList(
            new CommandeVente("Amodex 1g","Y.Karoun","2",LocalDate.of(2020,10,22),"Carte Visa")
    );

}
