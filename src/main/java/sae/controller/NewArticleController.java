package sae.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sae.model.article.Article;
import sae.model.article.ArticleCat1;
import sae.model.article.ArticleCat2;
import sae.model.article.Stock;

/**
 * La classe NewArticleController illustre le fonctionnement du contrôleur associé à la vue new-article.
 * 
 * @author Thimothée Lepetz
 */
public class NewArticleController {

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
     * Enumération du type d'articles soit de Catégorie 1 ou 2.
     */
    private enum TypeArticles {ARTICLECAT1,ARTICLECAT2};
    
    /**
     * Le champ de texte pour mettre la capacité de l'article.
     */
    @FXML
    private TextField capaciteArticle;

    /**
     * Menu déroulant les types d'articles.
     */
    @FXML
    private ComboBox<TypeArticles> categorieArticle;

    /**
     * Le champ de texte pour mettre la désignation de l'article.
     */
    @FXML
    private TextField designationArticle;

    /**
     * Le champ de texte pour mettre le poid de l'article.
     */
    @FXML
    private TextField poidArticle;

    /**
     * Le champ de texte pour mettre le prix de l'article.
     */
    @FXML
    private TextField prixArticle;

    /**
     * Le champ de texte pour mettre la quantite de l'article.
     */
    @FXML
    private TextField quantiteArticle;

    /**
     * Le champ de texte pour mettre la référence de l'article.
     */
    @FXML
    private TextField referenceArticle;
    
    /**
     * Le stock d'articles affiché par l'application
     */
    private Stock stock;
    
    /**
     * L'article.
     */
    private Article article;
    
    /**
     * Variable permetant de savoir si on modifie ou non l'article.
     */
    private boolean edit = false;
    
    /**
     * Initialise les combo-boxes avec les diffÃ©rents types possibles.
     */
    @FXML
    void initialize() {
    	categorieArticle.setItems(FXCollections.observableArrayList(TypeArticles.values()));
    }
	
    /**
     * Stocke la fenÃªtre de l'application.
     *
     * @param stage La fenÃªtre de l'application.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Stocke la scÃ¨ne de l'application.
     *
     * @param scene La scÃ¨ne de l'application.
     */
	public void setMainScene(Scene mainScene) {
		this.mainScene= mainScene;
		
	}
	
	/**
	 * Définit le stock.
	 * 
	 * @param stock
	 */
	public void bind(Stock stock) {
		this.stock = stock;
	}

	/**
	 * Permet de mettre les informations de l'article que l'on veut modifier.
	 * 
	 * @param article L'article à modifier.
	 * @param stock Le stock des articles.
	 */
	public void setArticle(Article article, Stock stock) {
		this.article = article;
		this.stock = stock;
		edit = true;
		if(article != null) {
			designationArticle.setText(article.getDesignation());
			prixArticle.setText(Double.toString(article.getPrix()));
			quantiteArticle.setText(Integer.toString(article.getQuantiteStock()));
			referenceArticle.setText(Integer.toString(article.getReference()));
			if(article instanceof ArticleCat1 ac1) {
				capaciteArticle.setText(Integer.toString(ac1.getCapacite()));
				categorieArticle.getSelectionModel().select(TypeArticles.ARTICLECAT1);
			}
			if(article instanceof ArticleCat2 ac2) {
				poidArticle.setText(Double.toString(ac2.getPoids()));
				categorieArticle.getSelectionModel().select(TypeArticles.ARTICLECAT2);
			}
		}
		
	}
	
	/**
	 * Annule l'ajout de l'article.
	 * 
	 * @param event
	 */
    @FXML
    void annulerAjout(ActionEvent event) {
    	stage.setScene(mainScene);
    }

    
    /**
     * Valide l'ajout de l'article.
     * 
     * @param event
     */
    @FXML
    void validerAjout(ActionEvent event) {
    	if(categorieArticle.getValue().equals(TypeArticles.ARTICLECAT1)) {
    		stock.ajouterArticle(new ArticleCat1(designationArticle.getText(),Integer.parseInt(prixArticle.getText()),
    			Integer.parseInt(quantiteArticle.getText()),Integer.parseInt(capaciteArticle.getText())));
    	}
    	if(categorieArticle.getValue().equals(TypeArticles.ARTICLECAT2)) {
    		stock.ajouterArticle(new ArticleCat2(designationArticle.getText(),Integer.parseInt(prixArticle.getText()),
        			Integer.parseInt(quantiteArticle.getText()),Integer.parseInt(poidArticle.getText())));
    	}
        if(edit)
        	stock.supprimerArticle(article);
        stage.setScene(mainScene);
    }

}
