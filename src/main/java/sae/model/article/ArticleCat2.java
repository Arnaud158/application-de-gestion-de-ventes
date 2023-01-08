package sae.model.article;

import util.Util;

/**
 * Chaque objet de cette classe correspond à un article de type vélo.
 * Ce type d'article peut être livré.
 * 
 * @author Jean-François Condotta
 * @version 16/03/22
 */
public class ArticleCat2 extends Article implements Livrable {
	/**
	 * Le poids du vélo en kg.
	 */
	private double poids;

	/**
	 * Constructeur permettant de créer un nouvel article de type vélo.
	 * Son numéro de référence est généré automatiquement.
	 * Sa catégorie est toujours "Vélos".
	 * @param designation La désignation de l'article.
	 * @param prix Le prix de l'article (si strictement inférieur à 0.0 alors 0.0 est mis comme prix).
	 * @param quantiteStock La quantité initiale en stock de l'article (si strictement inférieure à 0 alors 0 est mis comme quantité).
	 * @param poids Le poids du vélo en kg (si strictement inférieur à 0.0 alors 15 est mis par défaut).
	 */
	public ArticleCat2(String designation, double prix, int quantiteStock,double poids) {
		super("V�los",designation,prix,quantiteStock);
		setPoids(poids);
	}

	/**
	 * Constructeur permettant de créer un nouvel article de catégorie "Vélos".
	 * Son numéro de référence est généré automatiquement.
	 * Sa catégorie est toujours "Vélos".
	 * Les autres informations sont saisies au clavier avec la méthode saisirInfos().
	 */
	public ArticleCat2() {
	}

	/**
	 * Méthode permettant de saisir la désignation, le prix, la quantité en stock et le poids d'un article de catégorie "Vélos".
	 */
	public void saisirInfos() {
		super.saisirInfos();
		setPoids(Util.saisirDoublePositif("Poids (en kg) : "));
	}

	/**
	 * Méthode retournant le poids en kg du vélo.
	 * @return Le poids en kg du vélo.
	 */
	public double getPoids() {
		return poids;
	}

	/**
	 * Méthode permettant de modifier le poids du vélo.
	 * @param poids Le nouveau poids du vélo en kg (si strictement inférieur à 0.0 alors 15.0 est mis par défaut).
	 */
	public void setPoids(double poids) {
		if (poids<0.0)
			poids=15.0;
		this.poids = poids;
	}

	/**
	 * Méthode (redéfinition de toString()) retournant une représentation textuelle de l'article.
	 * @return Une représentation textuelle de l'article.
	 */
	public String toString() {
		return super.toString()+"\nPoids (en kg) :\t\t"+ poids+"\n"+infosLivrable();
	}

	/**
	 * Méthode indiquant la hauteur du colis de l'article en cm.
	 * @return La hauteur du colis en cm.
	 */
	public int getHauteurColis() {
		return 90;
	}

	/**
	 * Méthode indiquant la largeur du colis de l'article en cm.
	 * @return La largeur du colis en cm.
	 */
	public int getLargeurColis() {
		return 170;
	}

	/**
	 * Méthode indiquant la profondeur du colis de l'article en cm.
	 * @return La profondeur du colis en cm.
	 */
	public int getProfondeurColis() {
		return 40;
	}

	/**
	 * Méthode retournant le poids du colis en Kg.
	 * @return Le poids du colis en Kg.
	 */
	public double getPoidsKgColis() {
		return poids+1;
	}

}
