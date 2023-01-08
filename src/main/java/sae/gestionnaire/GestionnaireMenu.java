package sae.gestionnaire;

import util.Util;

/**
 * Un objet de type GestionnaireMenu permet d'associer un menu avec les actions à réaliser pour chaque entrée du menu.
 * Un menu est simplement représenté par un tableau de chaîne de caractères.
 * Chaque objet de type GestionnaireMenu est associé à un seul menu.
 * Un titre de menu est également associé à chaque objet de type GestionnaireMenu (ce titre est simplement affiché avant l'affichage du menu).
 * 
 * @author Jean-François Condotta
 * @version 15/03/22
 */
abstract public class GestionnaireMenu {
	
	/**
	 * Un tableau de chaîne de caractères correspondant aux entrées du menu associé au gestionnaire.
	 */
	private String[] menu;
	
	/**
	 * Le titre du menu (une simple chaîne de caractères affichée avant le menu).
	 */
	private String titreMenu;
	
	/**
	 * Booléen indiquant la fin du traitement du gestionnaire.
	 */
	private boolean finTraitement;
	
	/**
	 * Constructeur permettant de construire un gestionnaire de menu à partir d'un menu (un tableau de chaîne de caractères).
	 * @param menu Un tableau de chaîne de caractères correspondant au menu.
	 * @param titreMenu Le titre du menu
	 */
	protected GestionnaireMenu(String[] menu,String titreMenu) {
		this.menu=menu;
		this.titreMenu=titreMenu;
		finTraitement=true;
	}
	/**
	 * Méthode permettant d'associer les entrées du menu avec les traitements associés.
	 * @param numEntree Un numéro d'entrée du menu (un entier compris entre 0 et menu.length-1.
	 */
	abstract protected void traiterEntreeMenu(int numEntree);
	
	/**
	 * Méthode permettant d'afficher le menu et de lancer son traitement.
	 * Tant que le traitement du menu n'est pas terminé une boucle est réalisée où le menu est affiché, l'utilisateur saisi une entrée
	 * et le traitement de l'entrée correspondant est réalisée.
	 */
	public void afficherGererMenu() {
		finTraitement=false;
		int saisie;
		while (! finTraitement) {
			System.out.println();
			System.out.println("****************************************************************************************");
			System.out.println(titreMenu);
			System.out.println("****************************************************************************************");
			System.out.println();
			saisie=Util.saisirMenu(menu);
			traiterEntreeMenu(saisie);
		}
	}
	
	/**
	 * Méthode permettant d'arrêter l'affichage et le traitement du menu.
	 */
	protected void terminerTraitementMenu() {
		finTraitement=true;
	}

}
