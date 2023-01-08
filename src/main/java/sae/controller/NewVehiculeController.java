package sae.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sae.model.listeconducteur.Commerciaux;
import sae.model.listeconducteur.Conducteur;
import sae.model.listeconducteur.ListeConducteurs;
import sae.model.listeconducteur.Livreurs;
import sae.model.listevehicule.FlotteVehicules;
import sae.model.listevehicule.Fourgon;
import sae.model.listevehicule.Vehicule;
import sae.model.listevehicule.Voiture;

/**
 * La classe NewVehiculeController illustre le fonctionnement de FlotteVehicule.
 *
 * @author Vincent Da Silva
 *
 */
public class NewVehiculeController {
	
    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * Une énumeration pour savoir si le vehicule est un fourgon ou une voiture.
     */
    private enum TypeVehicule {FOURGON,VOITURE};
    
    /**
     * La scène principale de l'application, pour pouvoir revenir en arrière une fois l'opération terminée.
     */
    private Scene mainScene;
    
    /**
     * TextField pour récuperer l'année de mise en circulation.
     */
    @FXML
    private TextField anneeMiseCirculation;

    /**
     * TextField pour récuperer la charge maximal en kilogramme.
     */
    @FXML
    private TextField chargeMaxKilogramme;

    /**
     * TextField pour récuperer la charge maximal en metre cube.
     */
    @FXML
    private TextField chargeMaxMetreCube;

    /**
     * TextField pour récuperer le kilométrage.
     */
    @FXML
    private TextField kilometrageVehicule;

    /**
     * TextField pour récuperer la marque du véhicule.
     */
    @FXML
    private TextField marqueVehicule;

    /**
     * TextField pour récuperer le modele du véhicule.
     */
    @FXML
    private TextField modeleVehicule;

    /**
     * TextField pour récuperer le numéro d'immatriculation.
     */
    @FXML
    private TextField numeroImmatricualtionVehicule;

    /**
     * Menu déroulant pour choisir le type de véhicule. 
     */
    @FXML
    private ComboBox<TypeVehicule> typeVehicule;
    
    
    @FXML
    private ComboBox<Conducteur> listeLivreurs;

    
    @FXML
    private ComboBox<Conducteur> listeCommerciaux;
    
    /**
     * La flotte de véhicule.
     */
	private FlotteVehicules flotteVehicule;
    
	/**
	 * Variable d'un véhicule.
	 */
	private Vehicule vehicule;
    
	/**
	 * Variable de la liste des conducteurs.
	 */
	private ListeConducteurs conducteurs;
	/**
	 * Variable permettant de savoir si on modifie ou non le véhicule.
	 */
	private boolean edit = false;
    
	/**
     * Initialise les combo-boxes avec les différents types possibles.
     */
    @FXML
    void initialize() {
    	typeVehicule.setItems(FXCollections.observableArrayList(TypeVehicule.values()));
    }
	
    public void setConducteurs(ListeConducteurs conducteurs) {
        this.conducteurs=conducteurs;
        listeCommerciaux.setItems(FXCollections.observableArrayList(conducteurs.commerciauxDispo()));
        listeLivreurs.setItems(FXCollections.observableArrayList(conducteurs.livreurDispo()));

    }
    
    /**
     * Stocke la fenêtre de l'application.
     *
     * @param stage La fenêtre de l'application.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Stocke la scène de l'application.
     *
     * @param scene La scène de l'application.
     */
    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }
    
    /**
     * Stocke la flotte de véhicule.
     *
     * @param flotteVehicule La flotte de véhicule.
     */
    public void bind(FlotteVehicules flotteVehicule) {
    	this.flotteVehicule = flotteVehicule;
    }
    
    /**
     * Permet de mettre les informations du véhicule que l'on veut modifier. 
     *
     * @param vehicule
     * @param flotteVehicule
     */
    void setVehicule(Vehicule vehicule, FlotteVehicules flotteVehicule) {
    	this.vehicule = vehicule;
    	this.flotteVehicule = flotteVehicule;
    	edit = true;
    	if(vehicule != null) {
	    	numeroImmatricualtionVehicule.setText(vehicule.getNumImmatriculationVehicule());
	    	modeleVehicule.setText(vehicule.getModeleVehicule());
	    	marqueVehicule.setText(vehicule.getMarqueVehicule());
	    	kilometrageVehicule.setText(Double.toString(vehicule.getKilometrageVehicule()));
	    	anneeMiseCirculation.setText(Integer.toString(vehicule.getAnneeMiseCirculationVehicule()));
	    	
	    	if(vehicule instanceof Fourgon f) {
	    		chargeMaxKilogramme.setText(Double.toString(f.getVolumeMaximalKilogramme()));
	    		chargeMaxMetreCube.setText(Double.toString(f.getVolumeMaximalMetreCube()));
	    		typeVehicule.getSelectionModel().select(TypeVehicule.FOURGON);
	    		if(f.getLivreur() != null)
	    			listeLivreurs.getSelectionModel().select(f.getLivreur());
	    	}
	    	else if(vehicule instanceof Voiture v) {
	    		typeVehicule.getSelectionModel().select(TypeVehicule.VOITURE);
	    		if(v.getCommercial() != null)
	    			listeCommerciaux.getSelectionModel().select(v.getCommercial());
	    	}
    	}
    }
    
    /**
     * Permet d'annuler l'ajout.
     *
     * @param event
     */
    @FXML
    void annulerAjout(ActionEvent event) {
    	stage.setScene(mainScene);
    }

    /**
     * Permet de valider l'ajout et de l'ajouter dans la liste de véhicule.
     *
     * @param event
     * @throws NumberFormatException
     */
    @FXML
    void validerAjout(ActionEvent event) throws NumberFormatException {
    	TypeVehicule typeVi = typeVehicule.getSelectionModel().getSelectedItem();
    	if(typeVi == TypeVehicule.FOURGON) {
    		if(listeLivreurs.getSelectionModel().getSelectedItem() instanceof Livreurs li)
    		flotteVehicule.ajouteVehicule(new Fourgon(Double.parseDouble(chargeMaxKilogramme.getText()), Double.parseDouble(chargeMaxMetreCube.getText()), numeroImmatricualtionVehicule.getText(), modeleVehicule.getText(),marqueVehicule.getText(),
    				Double.parseDouble(kilometrageVehicule.getText()), Integer.parseInt(anneeMiseCirculation.getText()),li));
    		else {
        		flotteVehicule.ajouteVehicule(new Fourgon(Double.parseDouble(chargeMaxKilogramme.getText()), Double.parseDouble(chargeMaxMetreCube.getText()), numeroImmatricualtionVehicule.getText(), modeleVehicule.getText(),marqueVehicule.getText(),
        				Double.parseDouble(kilometrageVehicule.getText()), Integer.parseInt(anneeMiseCirculation.getText())));
    		}
    	}
    	if(typeVi == TypeVehicule.VOITURE) {
    		if(listeCommerciaux.getSelectionModel().getSelectedItem() instanceof Commerciaux co)
    		flotteVehicule.ajouteVehicule(new Voiture(numeroImmatricualtionVehicule.getText(), modeleVehicule.getText(),marqueVehicule.getText(),
    				Double.parseDouble(kilometrageVehicule.getText()), Integer.parseInt(anneeMiseCirculation.getText()),co));
    		else {
        		flotteVehicule.ajouteVehicule(new Voiture(numeroImmatricualtionVehicule.getText(), modeleVehicule.getText(),marqueVehicule.getText(),
        				Double.parseDouble(kilometrageVehicule.getText()), Integer.parseInt(anneeMiseCirculation.getText())));
    		}
    	}
    	if(edit)
    		flotteVehicule.supprimerVehicule(vehicule);
    	stage.setScene(mainScene);
    }
    	

}
