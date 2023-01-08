package sae.model.client;

import javafx.collections.ObservableList;
import util.Util;

/**
 * Un objet de la classe Client correspond à un client.
 * Chaque client a une référence (un entier) permettant de l'identifier, un nom (une chaîne de caractères), une adresse (une chaîne de caractères) et un nombre de points de fidélité (un entier). 
 * @author Jean-François Condotta
 * @version 13/03/22
 */
abstract public class Client {

	/**
	 * Le nombre de clients créés (à initialiser avec 0).
	 */
	static private int nbClients=0;

	/**
	 * La référence du client.
	 * Le premier client aura la référence 0, le deuxième la référence 1, le troisième la référence 2 ...
	 */
	private int reference;

	/**
	 * Le nom du client.
	 */
	private String nom;

	/**
	 * L'adresse du client.
	 */
	private String adresse;

	/**
	 * Le nombre de points de fidélité.
	 */
	private int pointsFidelite;

	/**
	 * Constructeur permettant d'initialiser un nouveau client avec son nom, son adresse et ses points de fidélité.
	 * Son numéro de référence est généré automatiquement.
	 * @param nom Le nom du client.
	 * @param adresse L'adresse du client.
	 * @param pointsFidelite Les points de fidélité initiaux du client.
	 */
	protected Client(String nom, String adresse,int pointsFidelite) {
		this.nom = nom;
		this.adresse = adresse;
		reference=nbClients++;
		this.pointsFidelite=pointsFidelite;
	}

	/**
	 * Constructeur permettant d'initialiser un nouveau client en effectuant la saisie au clavier de son nom, son adresse et ses points de fidélité (en utilisant la méthode saisirInfos()).
	 * Son numéro de référence est généré automatiquement.
	 */
	protected Client() {
		reference=nbClients++;
		saisirInfos();
	}
	/**
	 * Méthode permettant de saisir le nom et l'adresse du client.
	 */
	public void saisirInfos() {
		nom=Util.saisirChaine("Nom : ");
		adresse=Util.saisirChaine("Adresse : ");
		pointsFidelite=Util.saisirEntierPositif("Points de fidélité : ");
	}

	/**
	 * Méthode retournant le nombre de points de fidélité du client.
	 * @return Le nombre de points de fidélité.
	 */
	public int getPointsFidelite() {
		return pointsFidelite;
	}
	/**
	 * Les points de fidélité donnent droit à une ristourne sur le montant total d'une commande.
	 * Cette ristourne est calculé de la manière suivante :
	 * Un client ayant entre 100 et 499 points de fidelité a droit à une ristourne de 5% sur le montant total.
	 * Un client ayant entre 500 et 999 points de fidelité a droit à une ristourne de 10% sur le montant total.
	 * Un client ayant 1000 points ou plus de fidelité a droit à une ristourne de 15% sur le montant total.
	 * @return L'entier correspondant à la ristourne à laquelle a droit le client.
	 */
	public int getRistourne() {
		if (pointsFidelite>999)
			return 15;
		if (pointsFidelite>499)
			return 10;
		if (pointsFidelite>100)
			return 5;
		return 0;
	}
	
	/**
	 * Méthode permettant de modifier le nombre de points de fidélité du client.
	 * @param pointsFidelite Le nouveau nombre de points de fidélité (supposé supérieur ou égal à 0).
	 */
	public void setPointsFidelite(int pointsFidelite) {
		this.pointsFidelite = pointsFidelite;
	}

	/**
	 * Méthode retournant le numéro de référence du client.
	 * @return Le numéro de référence.
	 */
	public int getReference() {
		return reference;
	}

	/**
	 * Méthode retournant le nom du client.
	 * @return Le nom du client.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Méthode retournant l'adresse du client.
	 * @return L'adresse du client.
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Méthode permettant de modifier le nom du client.
	 * @param nom Le nouveau du client (doit être non null).
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Méthode permettant de modifier l'adresse du client.
	 * @param adresse La nouvelle adresse du client (doit être non null).
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * Méthode (redéfinition de toString()) retournant une représentation textuelle d'un client.
	 */
	@Override
	public String toString() {
		return "R�f�rence :\t\t"	+ reference + "\nNom :\t\t\t" + nom + "\nAdresse :\t\t" + adresse + "\nPoints Fid�lit�:\t"+ pointsFidelite+ "\nRistourne (%) :\t\t"+ getRistourne();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return reference == other.reference;
	}

	/**
	 * Méthode permettant d'afficher les clients d'un tableau de clients.
	 * @param clients Le tableau contenant les clients à afficher, chaque case du tableau contient une référence non null d'un Client.
	 */
	static public void afficherTabClients(ObservableList<Client> clients) {
		System.out.println("----------------------------------------------------------------------------------------");
		for (int i=0;i<clients.size();i++) {
			System.out.println(clients.get(i));
			System.out.println("----------------------------------------------------------------------------------------");
		}
			
	}
	
	/**
	 * Méthode permettant de trier un tableau de clients selon l'ordre alphabétique des noms des clients.
	 * @param clients Le tableau de clients à trier.
	 */
	static public void trierTabClients(ObservableList<Client> clients) {
		int indiceMax;
		Client temp;
		for (int i=clients.size()-1;i>0;i--) {
			indiceMax=0;
			for (int j=1;j<=i;j++)
				if ((clients.get(j).getNom().compareTo(clients.get(indiceMax).getNom()))>0)
					indiceMax=j;
			temp=clients.get(i);
			clients.set(i, clients.get(indiceMax));
			clients.set(indiceMax, temp);
		}
	}
}
