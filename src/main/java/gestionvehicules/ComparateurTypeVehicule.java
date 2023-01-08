package gestionvehicules;

import java.util.Comparator;

/**
 * Classe permettant de donner le type de comparateur dans le .sort pour trier par type de vehicule.
 *
 * @author Vincent Da Silva
 *
 */
public class ComparateurTypeVehicule implements Comparator<Vehicule> {

	/**
	 * Compare le type de deux vehicules donnés en parametre.
	 */
	@Override
	public int compare(Vehicule o1, Vehicule o2) {
		if (o1 instanceof Fourgon && o2 instanceof Fourgon || o1 instanceof Voiture && o2 instanceof Voiture)
			return 0;
		if (o1 instanceof Fourgon && o2 instanceof Voiture)
			return -1;
		else
			return 1;
	}


}
