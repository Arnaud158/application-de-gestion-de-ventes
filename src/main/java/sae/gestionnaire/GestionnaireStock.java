package sae.gestionnaire;


import javafx.collections.ObservableList;
import sae.model.article.Article;
import sae.model.article.ArticleCat1;
import sae.model.article.ArticleCat2;
import sae.model.article.Stock;
import util.Util;

/**
 * Un objet de type GestionnaireStock permet de gérer un stock d'articles à travers un menu. Il est donc associé
 * à un stock.
 * 
 * 
 * @author Jean-François Condotta
 * @version 16/03/22
 */
final public class GestionnaireStock extends GestionnaireMenu {

	/**
	 * Le stock devant être géré.
	 */
	private Stock stock;

	/**
	 * Le menu qui sera utilisé par un gestionnaire de stock.
	 */
	static final private String[] menu= {
			"Afficher tous les articles",
			"Afficher les articles d'une certaine catégorie",
			"Afficher les informations d'un article",
			"Ajouter un nouvel article (\"catégorie Aucune\")",
			"Ajouter un nouvel article de type ArticleCat1",
			"Ajouter un nouvel article de type ArticleCat2",
			"Supprimer un article",
			"Modifier un article",
			"Changer la quantité en stock d'un article",
			"Quitter"
	};
	/**
	 * Constructeur permettant de construire un gestionnaire de menu permettant de gérer un stock.
	 * @param stock Le stock devant être géré par le gestionnaire de menu.
	 */
	public GestionnaireStock(Stock stock) {
		super(menu,"Gestion du stock ("+stock.getNom()+")");
		this.stock=stock;
	}
	/**
	 * Méthode permettant d'associer les entrées du menu d'un gestionnaire de stock avec les traitements correspondants.
	 * @param numEntree Un numéro d'entrée du menu (un entier compris entre 0 et menu.length-1).
	 */
	protected void traiterEntreeMenu(int numEntree) {
		Article article;
		ObservableList<Article> tabArticles;
		int saisieEntier;
		String saisieString;
		switch (numEntree) {
		case 0 : 
			if (stock.estVide()) {
				System.out.println("Le stock ne contient pas d'articles !");
				break;
			}
			Article.afficherTabArticles(stock.articlesDansStock());
			break;
		case 1 : 
			saisieString=Util.saisirChaine("Veuillez saisir une catégorie : ");
			tabArticles=stock.rechercherArticlesCategorie(saisieString);
			if (tabArticles.size()==0)
				System.out.println("Pas d'article de cette catégorie !");
			else
				Article.afficherTabArticles(tabArticles);
			break;
		case 2 : 
			saisieEntier=Util.saisirEntierPositif("Tapez le numéro de l'article :");
			article=stock.rechercherArticleParReference(saisieEntier);
			if (article==null) 
				System.out.println("Article non trouvé !");
			else
				System.out.println(article);
			break;
		case 3 :
			if (stock.estPlein()) {
				System.out.println("Le stock est plein ! Il n'est pas possible d'ajouter un nouvel article !");
				break;
			}
			article=new Article();
			stock.ajouterArticle(article);
			System.out.println("Nouvel article inséré !");
			break;
		case 4 :
			if (stock.estPlein()) {
				System.out.println("Le stock est plein ! Il n'est pas possible d'ajouter un nouvel article !");
				break;
			}
			article=new ArticleCat1();
			stock.ajouterArticle(article);
			System.out.println("Nouvel article inséré !");
			break;
		case 5 :
			if (stock.estPlein()) {
				System.out.println("Le stock est plein ! Il n'est pas possible d'ajouter un nouvel article !");
				break;
			}
			article=new ArticleCat2();
			stock.ajouterArticle(article);
			System.out.println("Nouvel article inséré !");
			break;

		case 6 : 
			if (stock.estVide()) {
				System.out.println("Le stock ne contient pas d'articles !");
				break;
			}
			saisieEntier=Util.saisirEntierPositif("Tapez le numéro de l'article à supprimer :");
			article=stock.rechercherArticleParReference(saisieEntier);
			if (article==null) 
				System.out.println("Article non trouvé !");
			else
				stock.supprimerArticle(article);
			System.out.println("Article supprimé !");
			break;
		case 7 : 
			if (stock.estVide()) {
				System.out.println("Le stock ne contient pas d'articles !");
				break;
			}
			saisieEntier=Util.saisirEntierPositif("Tapez le numéro de l'article à modifier :");
			article=stock.rechercherArticleParReference(saisieEntier);
			if (article==null) 
				System.out.println("Article non trouvé !");
			else {
				article.saisirInfos();;
				System.out.println("Article modifié !");
			}
			break;
		case 8 : 
			if (stock.estVide()) {
				System.out.println("Le stock ne contient pas d'articles !");
				break;
			}
			saisieEntier=Util.saisirEntierPositif("Tapez le numéro de l'article à modifier :");
			article=stock.rechercherArticleParReference(saisieEntier);
			if (article==null) {
				System.out.println("Article non trouvé !");
				break;
			}
			System.out.println(article);
			System.out.println();
			saisieEntier=Util.saisirEntierPositif("Tapez la nouvelle quantité en stock : ");
			article.setQuantiteStock(saisieEntier);
			break;
		case 9 : 
			terminerTraitementMenu();
			break;
		}
	}

}
