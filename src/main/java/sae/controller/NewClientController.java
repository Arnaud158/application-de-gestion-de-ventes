package sae.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sae.model.client.CarnetClients;
import sae.model.client.Client;
import sae.model.client.ClientEntreprise;
import sae.model.client.ClientParticulier;
import sae.model.client.Genre;

/**
 * La classe NewClientController illustre le fonctionnement du contrôleur associé à la vue new-client.
 * 
 * @author Thimothée Lepetz
 */
public class NewClientController {

    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * La scène principale de l'application, pour pouvoir revenir en arrière une fois
     * l'opération terminée.
     */
    private Scene mainScene;
	
    /**
     * Enumération du type de client soit Particulier ou Entreprise
     */
    private enum TypeClients {CLIENTPARTICULIER,CLIENTENTREPRISE};
    
    /**
     * Le champ de texte pour mettre l'adresse du client.
     */
    @FXML
    private TextField adresseClient;

    /**
     * Le champ de texte pour mettre le contact du client.
     */
    @FXML
    private TextField contactClient;

    
    @FXML
    private ComboBox<Genre> genreClient;

    /**
     * Le champ de texte pour mettre le nom du client.
     */
    @FXML
    private TextField nomClient;

    /**
     * Le champ de texte pour mettre les points de fidélité du client.
     */
    @FXML
    private TextField pointFideliteClient;

    /**
     * Le champ de texte pour mettre le prenom du client.
     */
    @FXML
    private TextField prenomClient;

    /**
     * Le champ de texte pour mettre la référence du client.
     */
    @FXML
    private TextField referenceClient;
    
    /**
     * Menu déroulant les types de client.
     */
    @FXML
    private ComboBox<TypeClients> typeClient;
    
    /**
     * Le carnet de clients affiché par l'application
     */
	private CarnetClients carnetClients;
    
	/**
	 * Le client
	 */
	private Client client;
    
    /**
     * Variable permetant de savoir si on modifie ou non l'article.
     */
	private boolean edit = false;
	
    /**
     * Initialise les combo-boxes avec les différents types possibles.
     */
    @FXML
    void initialize() {
    	genreClient.setItems(FXCollections.observableArrayList(Genre.values()));
    	typeClient.setItems(FXCollections.observableArrayList(TypeClients.values()));
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
	 * Définit le carnet de clients.
	 * 
	 * @param stock
	 */
    public void bind(CarnetClients carnetClients) {
    	this.carnetClients = carnetClients;
    }
    
    /**
	 * Permet de mettre les informations du client que l'on veut modifier.
     * 
     * @param client Le client à modifier.
     * @param carnetclients Le carnet de clients.
     */
    void setClient(Client client, CarnetClients carnetclients) {
    	this.client = client;
    	this.carnetClients = carnetClients;
    	edit = true;
    	if(client != null) {
	    	adresseClient.setText(client.getAdresse());
	    	nomClient.setText(client.getNom());
	    	pointFideliteClient.setText(Integer.toString(client.getPointsFidelite()));
	    	referenceClient.setText(Integer.toString(client.getReference()));
	    	if(client instanceof ClientParticulier p) {
	    		prenomClient.setText(p.getPrenom());
	    		genreClient.getSelectionModel().select(p.getGenre());
	    		typeClient.getSelectionModel().select(TypeClients.CLIENTPARTICULIER);
	    	}
	    	if(client instanceof ClientEntreprise e) {
	    		contactClient.setText(e.getContact());
	    		typeClient.getSelectionModel().select(TypeClients.CLIENTENTREPRISE);
	    	}
    	}
    }
    
	/**
	 * Annule l'ajout du client..
	 * 
	 * @param event
	 */
    @FXML
    void annulerAjout(ActionEvent event) {
    	stage.setScene(mainScene);
    }

    /**
     * Valide l'ajout du client.
     * 
     * @param event
     */
    @FXML
    void validerAjout(ActionEvent event) {
    	if(typeClient.getValue().equals(TypeClients.CLIENTENTREPRISE)) {
    		carnetClients.ajouterClient(new ClientEntreprise(nomClient.getText(),adresseClient.getText(),
    				Integer.parseInt(pointFideliteClient.getText()),contactClient.getText()));
    	}
    	if(typeClient.getValue().equals(TypeClients.CLIENTPARTICULIER)) {
    		carnetClients.ajouterClient(new ClientParticulier(nomClient.getText(),adresseClient.getText(),
    				Integer.parseInt(pointFideliteClient.getText()),prenomClient.getText(),
    				genreClient.getSelectionModel().getSelectedItem()));
    	}
    	if(edit)
    		carnetClients.supprimerClient(client);
    	stage.setScene(mainScene);
    }

}
