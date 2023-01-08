package sae.model.article;

import util.Util;

/**
 * Chaque objet de cette classe correspond à un article de type sacoches de vélo.
 * 
 * @author Jean-François Condotta
 * @version 16/03/22
 */
public class ArticleCat1 extends Article {
	/**
	 * Le volume utile des sacoches en litres.
	 */
	private int capacite;

	/**
	 * Constructeur permettant de créer un nouvel article de type sacoches de vélo.
	 * Son numéro de référence est généré automatiquement.
	 * Sa catégorie est toujours "Sacoches Vélo".
	 * @param designation La désignation de l'article.
	 * @param prix Le prix de l'article (si strictement inférieur à 0.0 alors 0.0 est mis comme prix).
	 * @param quantiteStock La quantité initiale en stock de l'article (si strictement inférieure à 0 alors 0 est mis comme quantité).
	 * @param capacite La capcité en litre des sacoches (si strictement inférieure à 0 alors 0 est mis).
	 */
	public ArticleCat1(String designation, double prix, int quantiteStock,int capacite) {
		super("Sacoches V�lo",designation,prix,quantiteStock);
		setCapacite(capacite);
	}

	/**
	 * Constructeur permettant de créer un nouvel article de catégorie "Sacoches Vélo".
	 * Son numéro de référence est généré automatiquement.
	 * Sa catégorie est toujours "Sacoches Vélo".
	 * Les autres informations sont saisies au clavier avec la méthode saisirInfos().
	 */
	public ArticleCat1() {
	}

	/**
	 * Méthode permettant de saisir la désignation, le prix, la quantité en stock et la capacité d'un article de catégorie "Sacoches Vélo".
	 */
	public void saisirInfos() {
		super.saisirInfos();
		setCapacite(Util.saisirEntierPositif("Capacité (en l) : "));
	}

	/**
	 * Méthode retournant la capacité en litre des sacoches.
	 * @return La capacité en litre des sacoches.
	 */
	public int getCapacite() {
		return capacite;
	}

	/**
	 * Méthode permettant de modifier la capacité des sacoches.
	 * @param capacite La nouvelle capacité en litre (si strictement inférieure à 0 alors 0 est mis).
	 */
	public void setCapacite(int capacite) {
		if (capacite<0)
			capacite=0;
		this.capacite = capacite;
	}
	/**
	 * Méthode (redéfinition de toString()) retournant une représentation textuelle d'un article.
	 * @return Une représentation textuelle de l'article.
	 */
	public String toString() {
		return super.toString()+"\nCapacité (en l) :\t"+ capacite;
	}

}
