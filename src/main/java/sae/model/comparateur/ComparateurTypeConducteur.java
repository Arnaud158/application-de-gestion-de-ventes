package sae.model.comparateur;

import java.util.Comparator;

import sae.model.listeconducteur.Commerciaux;
import sae.model.listeconducteur.Conducteur;
import sae.model.listeconducteur.Livreurs;

/**
 * Classe permettant de donner le type de comparateur dans le .sort pour trier par type de conducteur.
 *
 * @author Vincent Da Silva
 *
 */
public class ComparateurTypeConducteur implements Comparator<Conducteur>{
    
	/**
	 * Compare le type de deux conducteurs donnés en parametre.
	 */
	public int compare(Conducteur a, Conducteur b){
		if (a instanceof Livreurs && b instanceof Livreurs || a instanceof Commerciaux && b instanceof Commerciaux)
			return 0;
		if (a instanceof Livreurs && b instanceof Commerciaux)
			return -1;
		else
			return 1;
    }
}
