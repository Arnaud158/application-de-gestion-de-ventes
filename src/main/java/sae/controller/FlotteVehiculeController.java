package sae.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sae.model.listeconducteur.ListeConducteurs;
import sae.model.listevehicule.FlotteVehicules;
import sae.model.listevehicule.Fourgon;
import sae.model.listevehicule.Vehicule;
import sae.model.listevehicule.Voiture;

/**
 * La classe FlotteVehiculeController illustre le fonctionnement associé à la vue FlotteVehicule.
 *
 * @author Vincent Da Silva
 *
 */
public class FlotteVehiculeController {

    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * La scéne ou la vue gérée par ce contrôleur est affichée.
     */
    private Scene scene;

    /**
     * La scène de l'écran d'accueil.
     */
    private Scene accueilScene;
    
    /**
     * La flotte de véhicule affiché par l'application.
     */
	private FlotteVehicules flotteVehicules;
	
    /**
     * Label pour afficher l'année de mise en circulation.
     */
    @FXML
    private Label anneeMiseCirculation;

    /**
     * Label pour afficher la charge maximale en kilogramme.
     */
    @FXML
    private Label chargeKilo;

    /**
     * Label pour afficher la charge maximale en metre cube.
     */
    @FXML
    private Label chargesMetreCube;

    /**
     * La ListView pour afficher les différents vehicules.
     */
    @FXML
    private ListView<Vehicule> vehiculeList;

    /**
     * Label pour afficher le kilometrage du véhicule.
     */
    @FXML
    private Label kilometrageVehicule;

    /**
     * Label pour afficher la marque du véhicule.
     */
    @FXML
    private Label marqueVehicule;

    /**
     * Label pour afficher le modéle du vehicule.
     */
    @FXML
    private Label modeleVehicule;

    /**
     * Label pour afficher le nombre d'heures de conduite.
     */
    @FXML
    private Label nbHeuresConduite;

    /**
     * Label pour afficher le numéro d'immatriculation.
     */
    @FXML
    private Label numeroImmatriculationVehicule;

    @FXML
    private Label typeConducteurs;
    
    
    private ListeConducteurs conducteurs;
    
    /**
     * Stocke la fenêtre de l'application.
     *
     * @param stage La fenêtre de l'application.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Stocke la scéne de l'application.
     *
     * @param scene La scéne de l'application.
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }
    
    /**
     * Stocke la scène de l'application.
     *
     * @param scene La scène de l'écran d'accueil de l'application.
     */
    public void setAccueilScene(Scene accueilScene) {
        this.accueilScene = accueilScene;
    }
    
    /**
     * Associe la liste afficher par l'application à ce controleur.
     *
     * @param flotteVehicule La liste des vehicules. 
     *
     */
    public void bind(FlotteVehicules flotteVehicules) {
        this.flotteVehicules = flotteVehicules;
        
        vehiculeList.setItems(flotteVehicules.getVehicule());
        vehiculeList.getSelectionModel().selectedItemProperty().addListener((o, p, n) -> {
        	numeroImmatriculationVehicule.setText(n.getNumImmatriculationVehicule());
        	modeleVehicule.setText(n.getModeleVehicule());
        	marqueVehicule.setText(n.getMarqueVehicule());
        	kilometrageVehicule.setText(Double.toString(n.getKilometrageVehicule()));
        	anneeMiseCirculation.setText(Integer.toString(n.getAnneeMiseCirculationVehicule()));
        	if(n instanceof Fourgon f) {
        		String messageK = "Charge maximal en kilogramme : ";
        		if (Double.toString(f.getVolumeMaximalKilogramme()) != null)
        			messageK += f.getVolumeMaximalKilogramme();
        		chargeKilo.setText(messageK);
        		
        		String messageM = "Charge maximal en metre cube : ";
        		if (Double.toString(f.getVolumeMaximalMetreCube()) != null)
        			messageM += f.getVolumeMaximalMetreCube();
        		chargesMetreCube.setText(messageM);
        		
        		String messageC = "Type de conducteurs : ";
        		if(f.getLivreur() != null)
        			messageC += f.getLivreur();
        		typeConducteurs.setText(messageC);
        	} else {
        		chargeKilo.setText(null);
        		chargesMetreCube.setText(null);

        	}
        	if(n instanceof Voiture v) {
           		String messageC = "Type de conducteurs : ";
        		if(v.getCommercial() != null)
        			messageC += v.getCommercial();
        		typeConducteurs.setText(messageC);
        	}
        });
        vehiculeList.setCellFactory(list -> {
        	return new ListCell<>() {
        		/**
        		 * Permet d'afficher les véhicules par leur numéro d'immatriculation.
        		 * @param vehicule Le véhicule avec le numéro d'immatriculation à afficher.
        		 * @param empty 
        		 */
        		@Override
        		public void updateItem(Vehicule vehicule, boolean empty) {
        			super.updateItem(vehicule, empty);
        			if (empty || (vehicule == null)) {
        				setText(null);
        			} else {
        				setText(vehicule.getNumImmatriculationVehicule());
        			}
        		}
        	};
        });
    }
    
    /**
     * Permet de changer d'écran pour en l'occurence aller à la page qui permet d'ajouter un vehicule ou de modifier un vehicule.
     *
     * @param modifier
     * @throws IOException
     */
    void modifVehicule(boolean modifier) throws IOException {
    	// Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/new-vehicule.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene ajoutVehiculeScene = new Scene(viewContent);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(ajoutVehiculeScene);

        // On lie le modèle au nouveau contrôleur.
        NewVehiculeController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setMainScene(scene);
        controller.bind(flotteVehicules);
        controller.setConducteurs(conducteurs);
        if(modifier) {
        	Vehicule vehicule = vehiculeList.getSelectionModel().getSelectedItem();
        	controller.setVehicule(vehicule,flotteVehicules);
        }
        vehiculeList.refresh();	
    }
    
    /**
     * Modifier le vehicule selectionner.
     *
     * @throws IOException
     */
    @FXML
    void modifierVehicule() throws IOException {
    	if(vehiculeList.getSelectionModel().getSelectedItem() != null) {
	    	boolean modifier = true;
	    	modifVehicule(modifier);
    	}
    }

    /**
     * Ajoute un vehicule.
     *
     * @throws IOException
     */
    @FXML
    void ajouterVehicule() throws IOException {
    	boolean modifier = false;
    	modifVehicule(modifier);

    }

    /**
     * Supprime le vehicule selectionner.
     *
     * @throws IOException
     */
    @FXML
    void supprimerVehicule() throws IOException {
    	if(vehiculeList.getSelectionModel().getSelectedItem() != null)
    		flotteVehicules.supprimerVehicule(vehiculeList.getSelectionModel().getSelectedItem());
    }

    /**
     * retourne à l'écran précédent soit l'écran d'accueil.
     * 
     * @param event
     */
    @FXML
    void retourEcranAccueil(ActionEvent event) {
        stage.setScene(accueilScene);
    }

    /**
     * @return La flotte de véhicules.
     */
    public FlotteVehicules getFlotteVehicules() {
    	return flotteVehicules;
    }
    
    public void setVehiculeList(ListView<Vehicule> vehiculeList) {
		this.vehiculeList = vehiculeList;
	}
    
    public void setConducteur(ListeConducteurs conducteurs) {
    	this.conducteurs=conducteurs;
    }

}

