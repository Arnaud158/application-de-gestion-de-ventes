package sae.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sae.model.article.Stock;
import sae.model.client.CarnetClients;
import sae.model.exception.HeuresConduitesNegativeException;
import sae.model.listeconducteur.ListeConducteurs;
import sae.model.listevehicule.FlotteVehicules;
import javafx.event.ActionEvent;

import java.io.IOException;

/**
 * La classe EcranAccueilController illustre le fonctionnement du contrôleur associé à la vue ecranAccueil-view.
 * 
 * @author Thimothée Lepetz
 */
public class EcranAccueilController {
	
    /**
     * La fen�tre de l'application.
     */
    private Stage stage;

    /**
     * La scène où la vue gérée par ce contrôleur est affichée.
     */
    private Scene scene;
    
    /**
     * Stocke la fenêtre de l'application.
     *
     * @param stage La fen^étre de l'application.
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
    
    boolean defaut = false; 
    
    Stock stock = Stock.defautStock();
    
    CarnetClients carnetClients = CarnetClients.defautCarnetClients();
    
    ListeConducteurs listeConducteurs;
    
    FlotteVehicules listeVehicules = FlotteVehicules.defautVehicule();
    
    public void setDefautListeConducteur() throws HeuresConduitesNegativeException {
    	this.listeConducteurs = ListeConducteurs.defautConducteur();
    }
    
    
    /**
     * Permet d'afficher la vue du carnet de clients.
     * 
     * @param event
     * @throws IOException
     * @throws HeuresConduitesNegativeException 
     */
    @FXML
    void afficheCarnetClients(ActionEvent event) throws IOException, HeuresConduitesNegativeException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/carnetClients-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene carnetClientsScene = new Scene(viewContent);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(carnetClientsScene);

        // On lie le modèle au nouveau contrôleur.
        CarnetClientsController controller = fxmlLoader.getController();
        controller.bind(carnetClients);
        controller.setStage(stage);
        controller.setScene(carnetClientsScene);
        controller.setAccueilScene(scene);
    }

    /**
     * Permet d'afficher la vue de la liste de conducteur.
     * 
     * @param event
     * @throws IOException
     * @throws HeuresConduitesNegativeException 
     */
    @FXML
    void afficheListeConducteurs(ActionEvent event) throws IOException, HeuresConduitesNegativeException {
    	if(!defaut) {
        	setDefautListeConducteur();
        	defaut = true;
        }
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ListeConducteur.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene listeConducteurScene = new Scene(viewContent);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(listeConducteurScene);

        // On lie le modèle au nouveau contrôleur.
        ListeConducteurController controller = fxmlLoader.getController();
        controller.bind(listeConducteurs);
        controller.setStage(stage);
        controller.setScene(listeConducteurScene);
        controller.setAccueilScene(scene);
    }

    /**
     * Permet d'afficher la vue de la liste de vehicule.
     * 
     * @param event
     * @throws IOException
     * @throws HeuresConduitesNegativeException 
     */
    @FXML
    void afficheListeVehicules(ActionEvent event) throws IOException, HeuresConduitesNegativeException {
    	if(!defaut) {
        	setDefautListeConducteur();
        	defaut = true;
        }
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/FlotteVehicule.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene listeVehiculesScene = new Scene(viewContent);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(listeVehiculesScene);

        // On lie le modèle au nouveau contrôleur.
        FlotteVehiculeController controller = fxmlLoader.getController();
        controller.bind(listeVehicules);
        controller.setStage(stage);
        controller.setScene(listeVehiculesScene);
        controller.setAccueilScene(scene);
        controller.setConducteur(listeConducteurs);
    }

    /**
     * Permet d'afficher la vue de la liste des clients.
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    void afficheStock(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/stock-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene stockScene = new Scene(viewContent);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(stockScene);

        // On lie le modèle au nouveau contrôleur.
        StockController controller = fxmlLoader.getController();        
        controller.bind(stock);
        controller.setStage(stage);
        controller.setScene(stockScene);
        controller.setAccueilScene(scene);
    }
    
}