package gestionvehicules;

import java.util.Comparator;

/**
 * Classe permettant de donner le type de comparateur dans le .sort pour trier par ordre alphabetique des conducteurs.
 *
 * @author Vincent Da Silva
 *
 */
public class ComparateurAlphabetique implements Comparator<Conducteur> {

	/**
	 * Compare le nom de deux conducteurs donnés en paramètre.
	 */
	public int compare(Conducteur o1, Conducteur o2) {
		return o1.getNomConducteur().compareTo(o2.getNomConducteur());
	}


}
