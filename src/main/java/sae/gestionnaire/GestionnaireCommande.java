package sae.gestionnaire;

import javafx.collections.ObservableList;
import sae.gestionnaire.GestionnaireMenu;
import sae.model.article.Article;
import sae.model.article.Stock;
import sae.model.commande.Commande;
import util.Util;

/**
 * Un objet de type GestionnaireCommande permet d'éditer une commande à travers un menu. Il est associé
 * à une commande et à un stock d'articles.
 * 
 * 
 * @author Jean-François Condotta
 * @version 17/03/22
 */
final public class GestionnaireCommande extends GestionnaireMenu {

	/**
	 * La commande devant être géré.
	 */
	private Commande commande;

	/**
	 * Le stock d'articles utilisé pour l'édition de la commande.
	 */
	private Stock stock;
	/**
	 * Le menu qui sera utilisé par un gestionnaire de commande.
	 */
	static final private String[] menu= {
			"Afficher la commande",
			"Afficher les articles du stock utilisé",
			"Ajouter un produit dans la commande",
			"Supprimer un article de la commande",
			"Clôturer la commande",
			"Quitter"
	};

	/**
	 * Constructeur permettant de créer un gestionnaire de commande.
	 * @param commande La commande à éditer.
	 * @param stock Le stock d'articles utilisé lors de l'édition de la commande.
	 */
	public GestionnaireCommande(Commande commande,Stock stock) {
		super(menu,"Edition d'une commande");
		this.commande=commande;
		this.stock=stock;
		System.out.println(commande);
	}
	/**
	 * Méthode permettant d'associer les entrées du menu d'un gestionnaire de commande avec les traitements correspondants.
	 * @param numEntree Un numéro d'entrée du menu (un entier compris entre 0 et menu.length-1).
	 */
	protected void traiterEntreeMenu(int numEntree) {
		Article article;
		ObservableList<Article> articles;
		int saisieEntier;
		switch (numEntree) {
		case 0 : 
			System.out.println(commande);
			break;
		case 1 : 
			if (stock.estVide()) {
				System.out.println("Le stock est vide !");
				break;
			}
			articles=stock.articlesDansStock();
			Article.afficherTabArticles(articles);
			System.out.println(commande);
			break;
		case 2 :
			if (commande.estCloturee()) {
				System.out.println("Commande clôturée !");
				break;
			}
			if (stock.estVide()) {
				System.out.println("Le stock est vide !");
				break;
			}
			saisieEntier=Util.saisirEntierPositif("Entrez un numéro d'article : ");
			if ((article=stock.rechercherArticleParReference(saisieEntier))==null) {
				System.out.println("Aucun article avec ce numéro de référence !");
				break;
			}
			saisieEntier=Util.saisirEntierPositif("Entrez une quantité : ");
			if (commande.commander(article,saisieEntier))
				System.out.println("Commande prise en compte !");
			else 
				System.out.println("Commande non prise en compte !");
			System.out.println(commande);
			break;
		case 3 : 
			if (commande.estCloturee()) {
				System.out.println("Commande clôturée !");
				break;
			}
			saisieEntier=Util.saisirEntierPositif("Entrez un numéro d'article : ");
			if (commande.supprimerLigneCommande(saisieEntier))
				System.out.println("Suppression réalisée !");
			else 
				System.out.println("Suppression non réalisée !");
			System.out.println(commande);
			break;
		case 4 : 
			if (commande.estCloturee()) {
				System.out.println("Commande déjà clôturée !");
				break;
			}
			commande.cloturer(Util.questionBinaire("Les articles livrables de la commande seront livrés (o/n) ?","o","n"));
			System.out.println("Commande clôturée !");
			System.out.println(commande);
			break;
		case 5 : 
			terminerTraitementMenu();
			break;

		}
	}

}
