package sae.model.client;

import util.Util;

/**
 * Un objet de la classe ClientParticulier représente un client correspondant à un particulier.
 * Un client qui est un particulier a un nom de contact comme caractéristique supplémentaire.
 * @author Jean-François Condotta
 * @version 13/03/22
 */
public class ClientParticulier extends Client {

	/**
	 * Le genre du client de type particulier. 
	 */
	private Genre genre;

	/**
	 * Le prénom du client de type particulier.
	 */
	private String prenom;


	/**
	 * Constructeur permettant d'initialiser un nouveau client de type particulier avec son nom, son adresse, son prénom et son genre.
	 * Son numéro de référence est généré automatiquement.
	 * @param nom Le nom du client de type particulier.
	 * @param adresse L'adresse du client de type particulier.
	 * @param pointsFidelite Les points de fidélité initiaux du client.
	 * @param prenom Le prénom du client de type particulier.
	 * @param genre Le genre du client de type particulier.
	 */
	public ClientParticulier(String nom, String adresse,int pointsFidelite,String prenom, Genre genre) {
		super(nom,adresse,pointsFidelite);
		this.prenom=prenom;
		this.genre=genre;
	}

	/**
	 * Constructeur permettant d'initialiser un nouveau client de type particulier en effectuant la saisie au clavier de son nom, son adresse, son prénom et son genre (en utilisant la méthode saisirInfos()).
	 * Son numéro de référence est généré automatiquement.
	 */
	public ClientParticulier() {
	}

	/**
	 * Méthode permettant de saisir le nom, l'adresse, le prénom et le genre d'un client de type particulier.
	 */
	public void saisirInfos() {
		super.saisirInfos();
		prenom=Util.saisirChaine("Prenom : ");
		boolean genreF=Util.questionBinaire("Genre (F/H) : ","F","H");
		if (genreF)
			genre=Genre.Femme;
		else
			genre=Genre.Homme;
	}

	/**
	 * Méthode retournant le genre du client de type particulier.
	 * @return Le genre du client de type particulier.
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * Méthode permettant de modifier le genre du client de type particulier.
	 * @param genre Le nouveau genre (qui doit être non null).
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	/**
	 * Méthode retournant le prénom du client de type particulier.
	 * @return Le prénom du client de type particulier.
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Méthode permettant de modifier le prénom du client de type particulier.
	 * @param prenom Le nouveau prénom (qui doit être non null).
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Méthode (redéfinition de toString()) retournant une représentation textuelle du client de type particulier.
	 */
	@Override
	public String toString() {
		return super.toString()+ "\nPrénom :\t\t"+ prenom+"\nGenre :\t\t\t"+genre;
	}

	

}
