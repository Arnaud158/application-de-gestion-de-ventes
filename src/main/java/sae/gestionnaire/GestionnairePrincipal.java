package sae.gestionnaire;

import sae.gestionnaire.GestionnaireStock;
import sae.model.article.Stock;
import sae.model.client.CarnetClients;
import sae.model.commande.EnsembleCommandes;
import util.Util;

/**
 * Un objet de type GestionnairePrincipal permet de gérer le menu principal de l'application de gestion des ventes.
 * Il est associé à un ensemble de commandes, à un carnet de clients et à un stock d'articles.
 * 
 * 
 * @author Jean-François Condotta
 * @version 17/03/22
 */
final public class GestionnairePrincipal extends GestionnaireMenu {

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
			"Gérer le carnet de clients",
			"Gérer le stock des articles",
			"Gérer les commandes",
			"Quitter"
	};

	/**
	 * Constructeur permettant de créer un gestionnaire principal.
	 * @param titreMenu Titre du menu principal.
	 * @param commandes L'ensemble des commandes géré par le gestionnaire principal.
	 * @param carnetClients Le carnet de clients utilisé par le gestionnaire principal.
	 * @param stock Le stock d'articles utilisé par le gestionnaire principal.
	 */
	public GestionnairePrincipal(String titreMenu,EnsembleCommandes commandes,CarnetClients carnetClients, Stock stock) {
		super(menu,titreMenu);
		this.commandes=commandes;
		this.stock=stock;
		this.carnetClients=carnetClients;
	}
	/**
	 * Méthode permettant d'associer les entrées du menu d'un gestionnaire de commande avec les traitements correspondants.
	 * @param numEntree Un numéro d'entrée du menu (un entier compris entre 0 et menu.length-1).
	 */
	protected void traiterEntreeMenu(int numEntree) {
		GestionnaireStock gestionnaireStock=new GestionnaireStock(stock);
		GestionnaireClients gestionnaireClients=new GestionnaireClients(carnetClients);
		GestionnaireCommandes gestionnaireCommandes=new GestionnaireCommandes(commandes,carnetClients,stock);
		switch (numEntree) {
		case 0 : 
			gestionnaireClients.afficherGererMenu();
			break;
		case 1 : 
			gestionnaireStock.afficherGererMenu();
			break;
		case 2 : 
			if (carnetClients.estVide()) {
				System.out.println("Le carnet de clients est vide !");
				break;
			}
			if (stock.estVide()) {
				System.out.println("Le stock est vide !");
				break;
			}
			gestionnaireCommandes.afficherGererMenu();
			break;
		case 3 : 
			if (Util.questionBinaire("Voulez-vous vraiment quitter l'application (o/n) ?","o","n")) {
				System.out.println("A Bientôt !");
				terminerTraitementMenu();
			}			
			break;

		}
	}

}
