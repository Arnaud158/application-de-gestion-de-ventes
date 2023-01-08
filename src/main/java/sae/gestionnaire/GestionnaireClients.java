package sae.gestionnaire;

import util.Util;

import javafx.collections.ObservableList;
import sae.gestionnaire.GestionnaireMenu;
import sae.model.client.CarnetClients;
import sae.model.client.Client;
import sae.model.client.ClientEntreprise;
import sae.model.client.ClientParticulier;

/**
 * Un objet de type GestionnaireClients permet de gérer un carnet de clients à travers un menu. Il est donc associé
 * à un carnet de clients.
 * 
 * 
 * @author Jean-François Condotta
 * @version 15/03/22
 */
final public class GestionnaireClients extends GestionnaireMenu {
	
	/**
	 * Le carnet de clients devant être géré.
	 */
	private CarnetClients carnetClients;
	
	/**
	 * Le menu qui sera utilisé par un gestionnaire de carnet de clients.
	 */
	static final private String[] menu= {
			"Afficher tous les clients",
			"Afficher tous les clients par ordre alphabétique des noms",
			"Afficher les clients de type Particulier",
			"Afficher les clients de type Entreprise",
			"Afficher les informations d'un client",
			"Ajouter un nouveau client de type Particulier",
			"Ajouter un nouveau client de type Entreprise",
			"Supprimer un client",
			"Modifier un client",
			"Rechercher des clients par un mot clé",
			"Quitter"
			};
	/**
	 * Constructeur permettant de construire un gestionnaire de menu permettant de gérer un carnet de clients.
	 * @param carnetClients Le carnet de clients devant être géré par le gestionnaire de menu.
	 */
	public GestionnaireClients(CarnetClients carnetClients) {
		super(menu,"Gestion du carnet de clients ("+carnetClients.getNom()+")");
		this.carnetClients=carnetClients;
	}
	/**
	 * Méthode permettant d'associer les entrées du menu d'un gestionnaire de carnet de clients avec les traitements correspondants.
	 * @param numEntree Un numéro d'entrée du menu (un entier compris entre 0 et menu.length-1).
	 */
	protected void traiterEntreeMenu(int numEntree) {
		Client client;
		ObservableList<Client> tabClients;
		int saisieEntier;
		String saisieString;
		switch (numEntree) {
		case 0 : 
			if (carnetClients.estVide()) {
				System.out.println("Le carnet est vide !");
				break;
			}
			Client.afficherTabClients(carnetClients.clientsDansCarnet());
			break;
		case 1 : 
			if (carnetClients.estVide()) {
				System.out.println("Le carnet est vide !");
				break;
			}
			tabClients=carnetClients.clientsDansCarnet();
			Client.trierTabClients(tabClients);
			Client.afficherTabClients(tabClients);
			break;
		case 2 : 
			tabClients=carnetClients.clientsParticulierDansCarnet();
			if (tabClients.size()==0)
				System.out.println("Pas de client de type Particulier !");
			else
				Client.afficherTabClients(tabClients);
			break;
		case 3 : 
			tabClients=carnetClients.clientsEntrepriseDansCarnet();
			if (tabClients.size()==0)
				System.out.println("Pas de client de type Entreprise !");
			else
				Client.afficherTabClients(tabClients);
			break;
		case 4 : 
			saisieEntier=Util.saisirEntierPositif("Tapez le numéro du client :");
			client=carnetClients.rechercherClientParReference(saisieEntier);
			if (client==null) 
				System.out.println("Client non trouvé !");
			else
				System.out.println(client);
			break;
		case 5 :
			if (carnetClients.estPlein()) {
				System.out.println("Le carnet est plein !");
				break;
			}
			client=new ClientParticulier();
			carnetClients.ajouterClient(client);
			System.out.println("Nouveau client inséré !");
			break;
		case 6 :
			if (carnetClients.estPlein()) {
				System.out.println("Le carnet est plein !");
				break;
			}
			client=new ClientEntreprise();
			carnetClients.ajouterClient(client);
			System.out.println("Nouveau client inséré !");
			break;
		case 7 : 
			if (carnetClients.estVide()) {
				System.out.println("Le carnet est vide !");
				break;
			}
			saisieEntier=Util.saisirEntierPositif("Tapez le numéro du client à supprimer :");
			client=carnetClients.rechercherClientParReference(saisieEntier);
			if (client==null) 
				System.out.println("Client non trouvé !");
			else {
				carnetClients.supprimerClient(client);
				System.out.println("Client supprimé !");
			}
			break;
		case 8 : 
			if (carnetClients.estVide()) {
				System.out.println("Le carnet est vide !");
				break;
			}
			saisieEntier=Util.saisirEntierPositif("Tapez le numéro du client à modifier :");
			client=carnetClients.rechercherClientParReference(saisieEntier);
			if (client==null) 
				System.out.println("Client non trouvé !");
			else {
				client.saisirInfos();
				System.out.println("Client modifié !");
			}
			break;
		case 9 : 
			if (carnetClients.estVide()) {
				System.out.println("Le carnet est vide !");
				break;
			}
			saisieString=Util.saisirChaine("Tapez un mot clé :");
			tabClients=carnetClients.rechercherClientsParMotCle(saisieString);
			if (tabClients.size()==0)
				System.out.println("Pas de client avec ce mot clé dans le nom ou l'adresse !");
			else 
				Client.afficherTabClients(tabClients);
			break;
		case 10 : 
			terminerTraitementMenu();
			break;
		
		}
	}

}
