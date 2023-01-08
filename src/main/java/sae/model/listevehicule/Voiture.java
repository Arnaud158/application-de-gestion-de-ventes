package sae.model.listevehicule;

import sae.model.listeconducteur.Commerciaux;

/**
 * Classe Voiture héritant de Véhicule permettant de créer un véhicule de type voiture assignée à un commercial.
 *
 * @author Vincent Da Silva
 *
 */
public class Voiture extends Vehicule {
	
    /**
     * Atribut commercial de type commerciaux 
     */
    private Commerciaux commercial;

    /**
     * Constructeur de Voiture utilisant le super de vehicule et en initialisant le commercial assigner.
     *
     * @param numImmatriculationVehicule Type String.
     * @param modeleVehicule Type String.
     * @param marqueVehicule Type String.
     * @param kilometrageVehicule Type double.
     * @param anneeMiseCirculationVehicule Type integer.
     * @param commercial Type Commerciaux.
     */
    public Voiture(String numImmatriculationVehicule, String modeleVehicule, String marqueVehicule, double kilometrageVehicule, int anneeMiseCirculationVehicule, Commerciaux commercial) {
    	super(numImmatriculationVehicule, modeleVehicule, marqueVehicule, kilometrageVehicule, anneeMiseCirculationVehicule);
    	this.commercial = commercial;
    }
    
    /**
     * Constructeur de Voiture utilisant le super de vehicule sans commercial.
     * 
     * @param numImmatriculationVehicule Type String.
     * @param modeleVehicule Type String.
     * @param marqueVehicule Type String.
     * @param kilometrageVehicule Type double.
     * @param anneeMiseCirculationVehicule Type integer.
     */
    public Voiture(String numImmatriculationVehicule, String modeleVehicule, String marqueVehicule, double kilometrageVehicule, int anneeMiseCirculationVehicule) {
    	super(numImmatriculationVehicule, modeleVehicule, marqueVehicule, kilometrageVehicule, anneeMiseCirculationVehicule);
    }

	/**
	 * Un getter pour récuperer le commercial assigner à la voiture.
	 *
	 * @return Le commercial assigner à la voiture.
	 */
	public Commerciaux getCommercial() {
		return commercial;
	}
    
}
