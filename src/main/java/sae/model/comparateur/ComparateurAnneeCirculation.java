package sae.model.comparateur;

import java.util.Comparator;

import sae.model.listevehicule.Vehicule;

/**
 * Classe permettant de donner le type de comparateur dans le .sort pour trier par année de circulation des vehciules.
 *
 * @author Vincent Da Silva
 *
 */
public class ComparateurAnneeCirculation implements Comparator<Vehicule> {

	/**
	 * Compare l'année de circulation de deux vehicules donnés en parametre.
	 */
	public int compare(Vehicule o1, Vehicule o2) {
		return o1.getAnneeMiseCirculationVehicule() - o2.getAnneeMiseCirculationVehicule();
	}
	
}
