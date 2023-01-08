package sae.model.client;

import util.Util;

/**
 * Un objet de la classe ClientEntreprise représente un client correspondant à une entreprise.
 * Un client qui est une entreprise a un nom de contact (une chaîne de caractères) comme caractéristique supplémentaire.
 * @author Jean-François Condotta
 * @version 13/03/22
 */
public class ClientEntreprise extends Client {

	/**
	 * Le nom du contact de l'entreprise. 
	 */
	private String contact;

	/**
	 * Constructeur permettant d'initialiser un nouveau client de type entreprise avec son nom, son adresse et le nom du contact.
	 * Son numéro de référence est généré automatiquement.
	 * @param nom Le nom du client de type entreprise.
	 * @param adresse L'adresse du client de type entreprise.
	 * @param pointsFidelite Les points de fidélité initiaux du client.
	 * @param contact Le nom du contact du client de type entreprise.
	 */
	public ClientEntreprise(String nom, String adresse,int pointsFidelite,String contact) {
		super(nom,adresse,pointsFidelite);
		this.contact=contact;
	}

	/**
	 * Constructeur permettant d'initialiser un nouveau client de type entreprise en effectuant la saisie au clavier de son nom, son adresse et le nom de son contact (en utilisant la méthode saisirInfos()).
	 * Son numéro de référence est généré automatiquement.
	 */
	public ClientEntreprise() {
	}

	/**
	 * Méthode permettant de saisir le nom, l'adresse et le contact d'un client de type entreprise.
	 */
	public void saisirInfos() {
		super.saisirInfos();
		contact=Util.saisirChaine("Contact : ");
	}

	/**
	 * Méthode (redéfinition de toString()) retournant une représentation textuelle du client de type entreprise.
	 */
	@Override
	public String toString() {
		return super.toString()+ "\nContact :\t\t"+ contact;
	}

	/**
	 * Méthode retournant le contact de l'entreprise.
	 * @return Le contact de l'entreprise.
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * Méthode permettant de modifier le contact de l'entreprise.
	 * @param contact Le nouveau contact de l'entreprise.
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
