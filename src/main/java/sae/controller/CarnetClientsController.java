/**
 * Ce logiciel est distribuÃ© Ã  des fins Ã©ducatives.
 *
 * Il est fourni "tel quel", sans garantie dâ€™aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualitÃ© marchande, dâ€™adÃ©quation
 * Ã  un usage particulier et dâ€™absence de contrefaÃ§on.
 * En aucun cas, les auteurs ou titulaires du droit dâ€™auteur ne seront
 * responsables de tout dommage, rÃ©clamation ou autre responsabilitÃ©, que ce
 * soit dans le cadre dâ€™un contrat, dâ€™un dÃ©lit ou autre, en provenance de,
 * consÃ©cutif Ã  ou en relation avec le logiciel ou son utilisation, ou avec
 * dâ€™autres Ã©lÃ©ments du logiciel.
 *
 * (c) 2022 Romain Wallon - UniversitÃ© d'Artois.
 * Tous droits rÃ©servÃ©s.
 */

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
import sae.model.client.CarnetClients;
import sae.model.client.Client;
import sae.model.client.ClientEntreprise;
import sae.model.client.ClientParticulier;

/**
 * La classe CarnetClientsController illustre le fonctionnement du contrôleur associé à la vue carnetClients.
 *
 * @author Thimothée Lepetz
 *
 */
public class CarnetClientsController {

    /**
     * La fenètre de l'application.
     */
    private Stage stage;

    /**
     * La scène où la vue gérée par ce contrôleur est affichée.
     */
    private Scene scene;
    
    /**
     * La scène de l'écran d'accueil.
     */
    private Scene accueilScene;
    
    /**
     * Le carnet de clients affiché par l'application
     */
	private CarnetClients carnetClients;
	
    /**
     * Le Label contenant l'adresse du client.
     */
    @FXML
    private Label adresseClient;

    /**
     * La ListView contenant tous les clients.
     */
    @FXML
    private ListView<Client> clientsList;
    
    /**
     * Le Label contenant le contact du client.
     */
    @FXML
    private Label contactClient;

    /**
     * Le Label contenant le genre du client.
     */
    @FXML
    private Label genreClient;
    
    /**
     * Le Label contenant le nom du client.
     */
    @FXML
    private Label nomClient;

    /**
     * Le Label contenant les points de fidélité du client.
     */
    @FXML
    private Label pointFidelite;

    /**
     * Le Label contenant le prenom du client.
     */
    @FXML
    private Label prenomClient;
    
    /**
     * Le Label contenant la référence du client.
     */
    @FXML
    private Label referenceClient;

    /**
     * Stocke la fenètre de l'application.
     *
     * @param stage La fenètre de l'application.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Stocke la scène de l'application.
     *
     * @param scene La scène de l'application.
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
     * Associe la liste affiché par l'application à ce contrôleur.
     * 
     * @param carnetClients le carnet de clients affichés par l'application.
     */
    public void bind(CarnetClients carnetClients) {
        this.carnetClients = carnetClients;
        //On lie la ListView à la liste des clients
        clientsList.setItems(carnetClients.getClients());
        clientsList.getSelectionModel().selectedItemProperty().addListener((o, p, n) -> {
        	nomClient.setText(n.getNom());									//Affiche le nom du client
        	adresseClient.setText(n.getAdresse());							//Affiche l'adresse du client
        	pointFidelite.setText(Integer.toString(n.getPointsFidelite())); //Affiche les points de fidélité du client
        	referenceClient.setText(Integer.toString(n.getReference()));	//Affiche la référence du client
        	if(n instanceof ClientParticulier cp) {
        		String messageP = "Prénom du client : ";
        		if (cp.getPrenom() != null)
        			messageP += cp.getPrenom();
        		prenomClient.setText(messageP);								//Affiche le prenom du client si ce dernier est un client Particulier.
        		
        		String messageG ="Genre du client : ";
        		if (cp.getGenre() != null)
        			messageG += cp.getGenre().toString();
        		genreClient.setText(messageG);								//Affiche le genre du client si ce dernier est un client Particulier.
        	} else {
        		prenomClient.setText(null);
        		genreClient.setText(null);
        	}
        	if(n instanceof ClientEntreprise ce) {
        		String messageC = "Contact du client : ";
        		if (ce.getContact() != null)
        			messageC += ce.getContact();
        		contactClient.setText(messageC);							//Affiche le contact du client si ce dernier est un client Entreprise.
        	} else {
        		contactClient.setText(null);
        	}
        });
        // permet d'afficher les clients par leur nom uniquement.
        clientsList.setCellFactory(list -> {
        	return new ListCell<>() {
        		@Override
        		public void updateItem(Client client, boolean empty) {
        			super.updateItem(client, empty);
        			if (empty || (client == null)) {
        				setText(null);
        			} else {
        				setText(client.getNom());
        			}
        		}
        	};
        });
    }
    
    /**
     * Permet de changer d'ecran pour, en l'occurence aller à la page qui permet d'ajouter un client
     * ou de modifier un client.
     * 
     * @param modifier
     * @throws IOException
     */
    void modifClient(boolean modifier) throws IOException {
    	// Il faut d'abord rÃ©cupÃ©rer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/new-client.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene ajoutClientScene = new Scene(viewContent);
        // que l'on place elle-mÃªme dans la fenÃªtre pour remplacer la scÃ¨ne courante.
        stage.setScene(ajoutClientScene);

        // On lie le modÃ¨le au nouveau contrÃ´leur.
        NewClientController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setMainScene(scene);
        controller.bind(carnetClients);
        if(modifier) {
        	Client client = clientsList.getSelectionModel().getSelectedItem();
        	controller.setClient(client,carnetClients);
        }
        clientsList.refresh();	
    }
    
    /**
     * Ajoute un client.
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    void ajouterClient(ActionEvent event) throws IOException {
    	boolean modifier = false;
    	modifClient(modifier);
    }

    /**
     * Modifie le client séléctioné
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    void editerClient(ActionEvent event) throws IOException {
    	if(clientsList.getSelectionModel().getSelectedItem() != null) {
	    	boolean modifier = true;
	    	modifClient(modifier);
    	}
    }

    /**
     * Supprime le client séléctioné.
     * 
     * @param event
     */
    @FXML
    void supprimerClient(ActionEvent event) {
    	if(clientsList.getSelectionModel().getSelectedItem() != null)
    		carnetClients.supprimerClient(clientsList.getSelectionModel().getSelectedItem());
    }
    
    /**
     * retourne à l'écran précédent soit ici l'écran d'accueil.
     * 
     * @param event
     */
    @FXML
    void retourEcranAccueil(ActionEvent event) {
        stage.setScene(accueilScene);
    }
    
    /**
     * @return Le carnet de clients
     */
    public CarnetClients getCarnetClients() {
    	return carnetClients;
    }
}