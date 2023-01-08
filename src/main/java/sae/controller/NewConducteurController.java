package sae.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sae.model.exception.HeuresConduitesNegativeException;
import sae.model.exception.VisitesNegatifException;
import sae.model.listeconducteur.Commerciaux;
import sae.model.listeconducteur.Conducteur;
import sae.model.listeconducteur.ListeConducteurs;
import sae.model.listeconducteur.Livreurs;
import sae.model.listevehicule.TypePermis;

/**
 * La classe NewConducteurController illustre le fonctionnement du controleur associé a la vue new-Conducteur.
 *
 * @author Vincent Da Silva
 *
 */
public class NewConducteurController {
	
    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * Une énumeration pour savoir si le conducteur est un livreur ou un commerciaux.
     */
    private enum TypeConducteur {LIVREUR,COMMERCIAUX};
    
    /**
     * La scène principale de l'application, pour pouvoir revenir en arrière une fois l'opération terminée.
     */
    private Scene mainScene;
    
    /**
     * Menu déroulant pour choisir le type de conducteur.
     */
    @FXML
    private ComboBox<TypeConducteur> typeConducteur;

    /**
     * TextField pour récuperer le nombre d'heures de conduites.
     */
    @FXML
    private TextField nbHeuresConduite;

    /**
     * TextField pour récuperer le nombre de visites.
     */
    @FXML
    private TextField nbVisites;

    /**
     * TextField pour récuperer le nom du conducteur.
     */
    @FXML
    private TextField nomConducteur;

    /**
     * TextField pour récuperer le numero du permis 
     */
    @FXML
    private TextField numeroPermis;

    /**
     * TextField pour récuperer le prénom du conducteur
     */
    @FXML
    private TextField prenomConducteur;

    /**
     * Menu déroulant pour choisir le type de permis.
     */
    @FXML
    private ComboBox<TypePermis> typePermis;

    /**
     * La liste des conducteurs affiché par l'application.
     */
	private ListeConducteurs listeConducteur;
    
	/**
	 * Variable d'un conducteur.
	 */
	private Conducteur conducteur;
    
	/**
	 * Variable permettant de savoir si on modifie ou non le conducteur.
	 */
	private boolean edit = false;
    
	/**
     * Initialise les combo-boxes avec les différents types possibles.
     */
    @FXML
    void initialize() {
    	typePermis.setItems(FXCollections.observableArrayList(TypePermis.values()));
    	typeConducteur.setItems(FXCollections.observableArrayList(TypeConducteur.values()));
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
     * Stocke la liste de conducteur.
     *
     * @param listeConducteur La liste de conducteur.
     */
    public void bind(ListeConducteurs listeConducteur) {
    	this.listeConducteur = listeConducteur;
    }
    
    /**
     * Permet de mettre les informations du conducteur que l'on veut modifier. 
     *
     * @param conducteur Le conducteur qu'on modifie.
     * @param listeConducteur La liste des conducteurs.
     */
    void setConducteur(Conducteur conducteur, ListeConducteurs listeConducteur) {
    	this.conducteur = conducteur;
    	this.listeConducteur = listeConducteur;
    	edit = true;
    	if(conducteur != null) {
	    	prenomConducteur.setText(conducteur.getPrenomConducteur());
	    	nomConducteur.setText(conducteur.getNomConducteur());
	    	numeroPermis.setText(conducteur.getNumPermisConduire());
	    	typePermis.getSelectionModel().select(conducteur.getTypePermisConduire());
	    	if(conducteur instanceof Livreurs l) {
	    		nbHeuresConduite.setText(Integer.toString(l.getNbHeuresConduiteEffectuees()));
	    		typeConducteur.getSelectionModel().select(TypeConducteur.LIVREUR);
	    	}
	    	else if(conducteur instanceof Commerciaux c) {
	    		nbVisites.setText(Integer.toString(c.getNbVisitesEffectuees()));
	    		typeConducteur.getSelectionModel().select(TypeConducteur.COMMERCIAUX);
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
     * Permet de valider l'ajout et de l'ajouter dans la liste de conducteur.
     *
     * @param event
     * @throws NumberFormatException
     * @throws HeuresConduitesNegativeException
     * @throws VisitesNegatifException
     */
    @FXML
    void validerAjout(ActionEvent event) throws NumberFormatException, HeuresConduitesNegativeException, VisitesNegatifException {
    	if(typeConducteur.getValue().equals(TypeConducteur.COMMERCIAUX)) {
    		listeConducteur.ajouterConducteur(new Commerciaux(Integer.parseInt(nbVisites.getText()), nomConducteur.getText(),prenomConducteur.getText(),
    				numeroPermis.getText(), typePermis.getSelectionModel().getSelectedItem()));
    	}
    	if(typeConducteur.getValue().equals(TypeConducteur.LIVREUR)) {
    		listeConducteur.ajouterConducteur(new Livreurs(Integer.parseInt(nbHeuresConduite.getText()), nomConducteur.getText(),prenomConducteur.getText(),
    				numeroPermis.getText(), typePermis.getSelectionModel().getSelectedItem()));
    	}
    	if(edit)
    		listeConducteur.supprimerConducteur(conducteur);
    	stage.setScene(mainScene);
    }
    	

}
