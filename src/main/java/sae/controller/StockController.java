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
import sae.model.article.Article;
import sae.model.article.ArticleCat1;
import sae.model.article.ArticleCat2;
import sae.model.article.Stock;

/**
 * La classe StockController illustre le fonctionnement du contrôleur associé à la vue stock-view.
 *
 * @author Thimotheée lepetz
 *
 */
public class StockController {
	
    /**
     * La fenêtre de l'application.
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
	 * Le stock d'article affiché par l'application
	 */
	private Stock stock ;
    
    /**
     * Le Label contenant la capacite ou le poid de l'article selon sa catégorie.
     */
	@FXML
	private Label capaciteOuPoidArticle;

    /**
     * Le Label contenant la catégorie de l'article.
     */
	@FXML
	private Label categorieArticle;

    /**
     * Le Label contenant la désignation de l'article.
     */
	@FXML
	private Label designationArticle;

    /**
     * La ListView contenant tous les articles.
     */
	@FXML
	private ListView<Article> listArticles;

    /**
     * Le Label contenant le prix de l'article.
     */
	@FXML
	private Label prixArticle;

    /**
     * Le Label contenant la quantite de l'article.
     */
	@FXML
	private Label quantiteArticle;

    /**
     * Le Label contenant la référence de l'article.
     */
	@FXML
	private Label referenceArticle;

    
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
     * @param stock Le stock de produits affichés par l'application.
     */
    public void bind(Stock stock) {
    	this.stock = stock;
    	//On lie la ListView à la liste des articles
    	listArticles.setItems(stock.getArticles());
    	listArticles.getSelectionModel().selectedItemProperty().addListener((o, p, n) -> {
    		categorieArticle.setText(n.getCategorie());							//Affiche la catégorie de l'article.
    		designationArticle.setText(n.getDesignation());						//Affiche la désignation de l'article.
    		prixArticle.setText(Double.toString(n.getPrix()));					//Affiche le prix de l'article.
    		quantiteArticle.setText(Integer.toString(n.getQuantiteStock()));	//Affiche la quantite de stock de l'article.
    		referenceArticle.setText(Integer.toString(n.getReference()));		//Affiche la référence de l'article.
    		if(n instanceof ArticleCat1 ac1) {
    			String messageC = "Capacite de Article : ";
    			if(Integer.toString(ac1.getCapacite()) != null)
    				messageC += ac1.getCapacite();
    			capaciteOuPoidArticle.setText(messageC);
    		}
    		if(n instanceof ArticleCat2 ac2) {
    			String messageP = "Capacite de Article";
    			if(Double.toString(ac2.getPoids()) != null)
    				messageP += ac2.getPoids();
    			capaciteOuPoidArticle.setText(messageP);
    			capaciteOuPoidArticle.setText("Poid de Article : "+ac2.getPoids());
    		}
    	});
       	listArticles.setCellFactory(list -> {
    		return new ListCell<>() {
    			/**
    			 * permet d'afficher les articles par leur designation uniquement.
    			 * 
    			 * @param article l'article
    			 * @param empty
    			 */
    			@Override
    			public void updateItem(Article article, boolean empty) {
    				super.updateItem(article, empty);
    				if(empty || (article == null)) {
    					setText(null);
    				} else {
    					setText(article.getDesignation());
    				}
    			}
    		};
    	});
    }
    
    /**
     * Permet de changer d'ecran pour, en l'occurence aller à la page qui permet d'ajouter un article
     * ou de modifier un article.
     * 
     * @param modifier
     * @throws IOException
     */
    void modifArticle(boolean modifier) throws IOException {
    	// Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/new-article.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene ajoutArticleScene = new Scene(viewContent);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(ajoutArticleScene);

        // On lie le modèle au nouveau contrôleur.
        NewArticleController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setMainScene(scene);
        controller.bind(stock);
        if(modifier) {
        	Article article = listArticles.getSelectionModel().getSelectedItem();
        	controller.setArticle(article,stock);
        }
        listArticles.refresh();	
    }
    
    /**
     * Ajoute un article.
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    void ajouterArticle(ActionEvent event) throws IOException {
    	boolean modifier = false;
    	modifArticle(modifier);
    }

    /**
     * Modifie l'article séléctioné
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    void editerArticle(ActionEvent event) throws IOException{
    	if(listArticles.getSelectionModel().getSelectedItem() != null) {
        	boolean modifier = true;
        	modifArticle(modifier);
    	}
    }

    /**
     * Supprime l'article séléctioné.
     * 
     * @param event
     */
    @FXML
    void supprimerArticle(ActionEvent event) {
    	if(listArticles.getSelectionModel().getSelectedItem() != null)
    		stock.supprimerArticle(listArticles.getSelectionModel().getSelectedItem());
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
     * @return Le Stock d'articles.
     */
    public Stock getStock() {
    	return stock;
    }
}
