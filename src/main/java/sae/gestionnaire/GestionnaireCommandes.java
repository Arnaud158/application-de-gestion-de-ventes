package sae.gestionnaire;

import javafx.collections.ObservableList;
import sae.gestionnaire.GestionnaireMenu;
import sae.model.article.Article;
import sae.model.article.Stock;
import sae.model.client.CarnetClients;
import sae.model.client.Client;
import sae.model.commande.Commande;
import sae.model.commande.EnsembleCommandes;
import util.Util;

/**
 * Un objet de type GestionnaireCommandes permet de gérer un ensemble de commandes à travers un menu. Il est associé
 * à un carnet de clients et à un stock d'articles.
 * 
 * 
 * @author Jean-François Condotta
 * @version 17/03/22
 */
final public class GestionnaireCommandes extends GestionnaireMenu {

	/**
	 * L'ensemble de commandes devant être géré.
	 */
	private EnsembleCommandes commandes;

	/**
	 * Le carnet de clients utilisée par le gestionnaire de commandes.
	 */
	private CarnetClients carnetClients;

	/**
	 * Le stock d'articles utilisé pour l'édition des commandes.
	 */
	private Stock stock;
	/**
	 * Le menu qui sera utilisé par un gestionnaire de commande.
	 */
	static final private String[] menu= {
			"Afficher les commandes",
			"Afficher les clients du carnet de clients utilisé",
			"Afficher les articles du stock utilisé",
			"Créer et éditer une nouvelle commande",
			"Editer une commande",
			"Supprimer une commande",
			"Quitter"
	};

	/**
	 * Constructeur permettant de créer un gestionnaire de commandes.
	 * @param commandes L'ensemble des commandes géré par le gestionnaire de commandes.
	 * @param carnetClients Le carnet de clients utilisé par le gestionnaire de commandes.
	 * @param stock Le stock d'articles utilisé par le gestionnaire de commandes.
	 */
	public GestionnaireCommandes(EnsembleCommandes commandes,CarnetClients carnetClients, Stock stock) {
		super(menu,"Gestion des commandes");
		this.commandes=commandes;
		this.stock=stock;
		this.carnetClients=carnetClients;
	}
	/**
	 * Méthode permettant d'associer les entrées du menu d'un gestionnaire de commande avec les traitements correspondants.
	 * @param numEntree Un numéro d'entrée du menu (un entier compris entre 0 et menu.length-1).
	 */
	protected void traiterEntreeMenu(int numEntree) {
		ObservableList<Article> articles;
		Client client;
		ObservableList<Client> clients;
		Commande commande;
		int saisieEntier;
		GestionnaireCommande gestionnaireCommande;
		switch (numEntree) {
		case 0 : 
			if (commandes.estVide()) {
				System.out.println("L'ensemble des commandes est vide !");
				break;
			}
			commandes.afficher();
			break;
		case 1 : 
			if (carnetClients.estVide()) {
				System.out.println("Le carnet de clients est vide !");
				break;
			}
			clients=carnetClients.clientsDansCarnet();
			Client.afficherTabClients(clients);
			break;
		case 2 : 
			if (stock.estVide()) {
				System.out.println("Le stock est vide !");
				break;
			}
			articles=stock.articlesDansStock();
			Article.afficherTabArticles(articles);
			break;
		case 3 :
			if (commandes.estPlein()) {
				System.out.println("L'ensemble des commandes est plein !");
				break;
			}
			if (carnetClients.estVide()) {
				System.out.println("Le carnet de clients est vide !");
				break;
			}
			if (stock.estVide()) {
				System.out.println("Le stock est vide !");
				break;
			}
			saisieEntier=Util.saisirEntierPositif("Entrez un numéro de client : ");
			if ((client=carnetClients.rechercherClientParReference(saisieEntier))==null) {
				System.out.println("Ce numéro de référence ne correspond pas à un client !");
				break;
			}
			commande=new Commande(client);
			commandes.ajouterCommande(commande);
			gestionnaireCommande=new GestionnaireCommande(commande,stock);
			gestionnaireCommande.afficherGererMenu();
			gestionnaireCommande=null;
			break;
		case 4 : 
			if (commandes.estVide()) {
				System.out.println("L'ensemble des commandes est vide !");
				break;
			}
			if (stock.estVide()) {
				System.out.println("Le stock est vide !");
				break;
			}
			saisieEntier=Util.saisirEntierPositif("Entrez un numéro de commande : ");
			commande=commandes.chercherCommande(saisieEntier);
			if (commande==null){
				System.out.println("Aucune commande avec ce numéro de référence a été trouvée !");
				break;
			}
			if (commande.estCloturee()) {
				System.out.println("Commande clôturée !");
				break;
			}
			gestionnaireCommande=new GestionnaireCommande(commande,stock);
			gestionnaireCommande.afficherGererMenu();
			gestionnaireCommande=null;
			break;
		case 5 : 
			if (commandes.estVide()) {
				System.out.println("L'ensemble des commandes est vide !");
				break;
			}
			saisieEntier=Util.saisirEntierPositif("Entrez un numéro de commande : ");
			commande=commandes.chercherCommande(saisieEntier);
			if (commande==null){
				System.out.println("Aucune commande avec ce numéro de référence a été trouvée !");
				break;
			}
			if (! commande.estCloturee()) {
				System.out.println("La commande n'a pas été clôturée !");
				break;
			}
			if (commandes.supprimerCommande(commande.getReference()))
				System.out.println("La commande a été supprimée !");
			else
				System.out.println("La commande n'a pas été supprimée !");
			break;
		case 6 : 
			terminerTraitementMenu();
			break;

		}
	}

}
