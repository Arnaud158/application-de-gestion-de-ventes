package sae.principal;

import sae.gestionnaire.GestionnairePrincipal;
import sae.model.article.Article;
import sae.model.article.Stock;
import sae.model.client.CarnetClients;
import sae.model.client.ClientEntreprise;
import sae.model.client.ClientParticulier;
import sae.model.client.Genre;
import sae.model.commande.EnsembleCommandes;

/**
 * Le programme principal de l'application de gestion de ventes.
 * @author Jean-François Condotta
 * @version 17/03/22
 *
 */
public class GestionVentes {
	/**
	 * Le nom de l'entreprise réalisant les ventes d'articles.
	 */
	static final public String nomEntreprise="Vélo Lens ;-)";
	/**
	 * Les prénoms et noms des gérants.
	 */
	static final public String nomsGerants="Hector & Cure";
	
	/**
	 * Le programme principal de l'application de gestion des ventes.
	 * @param args Pas d'arguments.
	 */
	public static void main(String[] args) {
		Stock stock=new Stock("Stock 2022");
		stock.ajouterArticle(new Article("Super Article",15.0,5));
		stock.ajouterArticle(new Article("Article Sympa",10.0,123));
		stock.ajouterArticle(new Article("Article Super Cool",4.0,1));
		stock.ajouterArticle(new Article("Article Génial",4.0,10));
		CarnetClients carnetClients=new CarnetClients("Carnet Clients 2022");
		carnetClients.ajouterClient(new ClientParticulier("Cure","30 rue des Tulipes, 62300 Lens, France",0,"Hector",Genre.Homme));
		carnetClients.ajouterClient(new ClientEntreprise("Peuplier and Co.","42 boulevard des Marguerites, 62300 Lens, France",10,"Francis Chêne"));
		carnetClients.ajouterClient(new ClientEntreprise("Charme and Co.","22 impasse des Lilas, 62300 Lille, France",500,"René Tilleul"));
		carnetClients.ajouterClient(new ClientParticulier("Tournesol","123 rue des narcisses, 62300 Lens, France",2000,"Jonquille",Genre.Femme));
		EnsembleCommandes ensembleCommandes=new EnsembleCommandes();
		GestionnairePrincipal gestionnairePrincipal=new GestionnairePrincipal("Gestion des ventes - "+nomEntreprise+"\n"+nomsGerants,ensembleCommandes,carnetClients,stock);
		gestionnairePrincipal.afficherGererMenu();

	}

}
