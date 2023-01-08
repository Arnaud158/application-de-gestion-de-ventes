package sae.model.article;
/**
 * Cette interface spécifie les méthodes nécessaires aux articles pouvant être livrés. 
 *
 * @author Jean-François Condotta
 * @version 16/03/22
 */
public interface Livrable {
	/**
	 * Méthode indiquant la hauteur du colis de l'article en cm.
	 * @return La hauteur du colis en cm.
	 */
	abstract public int getHauteurColis();

	/**
	 * Méthode indiquant la largeur du colis de l'article en cm.
	 * @return La largeur du colis en cm.
	 */
	abstract public int getLargeurColis();

	/**
	 * Méthode indiquant la profondeur du colis de l'article en cm.
	 * @return La profondeur du colis en cm.
	 */
	abstract public int getProfondeurColis();

	/**
	 * Méthode retournant le poids du colis en Kg.
	 * @return Le poids du colis en Kg.
	 */
	abstract public double getPoidsKgColis();

	/**
	 * Méthode retournant une chaîne de caractères représentant les informations sur l'article Livrable concernant les caractéristiques nécessaires à son transport.
	 * @return Les informations sur l'article livrable.
	 */
	default public String infosLivrable() {
		return "[Haut. : "+getHauteurColis()+" cm | Larg. : "+getLargeurColis()+" cm | Prof. : "+getProfondeurColis()+" cm | Poids : "+getPoidsKgColis()+" kg]";
	}

	/**
	 * Méthode retournant le coût de livraison de l'article livrable :
	 * 1.5 euros par m3 du volume du colis + 1.1 euro par kg du colis.
	 * @return Le coût de livraison de l'article livrable.
	 */
	default public double coutLivraison() {
		double volumeM3=(getHauteurColis()*getLargeurColis()*getProfondeurColis())/1000000.0;
		double poidsKg=getPoidsKgColis();
		return Math.round(1.5*volumeM3+1.1*poidsKg*100.0)/100.0;
	}
}
