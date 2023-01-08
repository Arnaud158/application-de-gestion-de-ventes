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
import sae.model.listeconducteur.Commerciaux;
import sae.model.listeconducteur.Conducteur;
import sae.model.listeconducteur.ListeConducteurs;
import sae.model.listeconducteur.Livreurs;

/**
 * La classe ListeConducteurController illustre le fonctionnement du controleur associé a la vue ListeConducteur.
 *
 * @author Vincent Da Silva
 *
 */
public class ListeConducteurController {

    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * La scène ou la vue est gérée par ce controleur est affichée.
     */
    private Scene scene;

    /**
     * La scène de l'écran d'accueil.
     */
    private Scene accueilScene;
    
    /**
     * Le liste de conducteur affiché par l'application.
     */
	private ListeConducteurs listeConducteurs;
	
    /**
     * Le label pour afficher le nombre de visites.
     */
    @FXML
    private Label nbVisites;

    /**
     * Le label pour afficher le nombres d'heures de conduite.
     */
    @FXML
    private Label nbHeuresConduite;

    /**
     * Le label pour afficher le nom du conducteur.
     */
    @FXML
    private Label nomConducteur;

    /**
     * La ListView pour afficher les différents conducteurs.
     */
    @FXML
    private ListView<Conducteur> conducteurList;
    
    /**
     * Le label pour afficher le numéro de permis.
     */
    @FXML
    private Label numeroPermis;

    /**
     * Le label pour afficher le prenom du conducteur
     */
    @FXML
    private Label prenomConducteur;

    /**
     * Le label pour afficher les type de permis 
     */
    @FXML
    private Label typePermis;

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
     * @param listeConducteurs La liste des conducteurs. 
     *
     */
    public void bind(ListeConducteurs listeConducteurs) {
        this.listeConducteurs = listeConducteurs;
        
        conducteurList.setItems(listeConducteurs.getConducteur());
        conducteurList.getSelectionModel().selectedItemProperty().addListener((o, p, n) -> {
        	nomConducteur.setText(n.getNomConducteur());
        	prenomConducteur.setText(n.getPrenomConducteur());
        	numeroPermis.setText(n.getNumPermisConduire());
        	typePermis.setText(n.getTypePermisConduire().toString());
        	if(n instanceof Livreurs l) {
        		String messageC = "Nombres heures conduites : ";
        		if (Integer.toString(l.getNbHeuresConduiteEffectuees()) != null)
        			messageC += l.getNbHeuresConduiteEffectuees();
        		nbHeuresConduite.setText(messageC);
        	} else {
        		nbHeuresConduite.setText(null);
        	}
        	
        	if(n instanceof Commerciaux c) {
        		String messageV = "Nombres visites : ";
        		if (Integer.toString(c.getNbVisitesEffectuees()) != null)
        			messageV += c.getNbVisitesEffectuees();
        		nbVisites.setText(messageV);
        	} else {
        		nbVisites.setText(null);
        	}
        });
        conducteurList.setCellFactory(list -> {
        	return new ListCell<>() {
        		/**
        		 * Permet d'afficher Les conducteurs par leur nom uniquement.
        		 * @param conducteur Le conduteur avec le nom a afficher.
        		 * @param empty 
        		 */
        		@Override
        		public void updateItem(Conducteur conducteur, boolean empty) {
        			super.updateItem(conducteur, empty);
        			if (empty || (conducteur == null)) {
        				setText(null);
        			} else {
        				setText(conducteur.getPrenomConducteur());
        			}
        		}
        	};
        });
    }
    
    /**
     * Permet de changer d'écran pour en l'occurence aller à la page qui permet d'ajouter un conducteur ou de modifier un conducteur.
     *
     * @param modifier
     * @throws IOException
     */
    void modifConducteur(boolean modifier) throws IOException {
    	// Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/new-conducteur.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene ajoutConducteurScene = new Scene(viewContent);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(ajoutConducteurScene);

        // On lie le modèle au nouveau contrôleur.
        NewConducteurController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setMainScene(scene);
        controller.bind(listeConducteurs);
        if(modifier) {
        	Conducteur conducteur = conducteurList.getSelectionModel().getSelectedItem();
        	controller.setConducteur(conducteur,listeConducteurs);
        }
        conducteurList.refresh();	
    }
    
    /**
     * Modifie le conducteur selectionner.
     * @throws IOException
     */
    @FXML
    void modifierConducteur() throws IOException {
    	if(conducteurList.getSelectionModel().getSelectedItem() != null) {
	    	boolean modifier = true;
	    	modifConducteur(modifier);
    	}
    }

    /**
     * Ajoute un conducteur.
     * @throws IOException
     */
    @FXML
    void ajouterConducteur() throws IOException {
    	boolean modifier = false;
    	modifConducteur(modifier);

    }

    /**
     * Supprime le conducteur selectionner.
     * @throws IOException
     */
    @FXML
    void supprimerConducteur() throws IOException {
    	if(conducteurList.getSelectionModel().getSelectedItem() != null)
    		listeConducteurs.supprimerConducteur(conducteurList.getSelectionModel().getSelectedItem());
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
     * 
     * @return La liste des conducteurs.
     */
    public ListeConducteurs getListeConducteurs() {
    	return listeConducteurs;
    }
    
}

