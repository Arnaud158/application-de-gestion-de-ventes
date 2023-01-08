package gestionvehicules;

/**
 * Classe Vehicule permettant de cr�er une vehicule avec diff�rents attributs.
 *
 * @author Vincent Da Silva
 *
 */
public class Vehicule {
	
	/**
     * Attribut numImmatriculationVehicule de type String.
     */
    private String numImmatriculationVehicule;

    /**
     * Attribut modele du véhicule de type String.
     */
    private String modeleVehicule;

    /**
     * Attribut marque du véhicule de type String.
     */
    private String marqueVehicule;

    /**
     * Attribut kilometrage du véhicule de type double.
     */
    private double kilometrageVehicule;

    /**
     * Attribut anneeMiseCirculation du véhicule de type integer.
     */
    private int anneeMiseCirculationVehicule;

    /**
     * Constructeur permettant d'initialiser les différents attributs.
     *
     * @param numImmatriculationVehicule Type String.
     * @param modeleVehicule Type String.
     * @param marqueVehicule Type String.
     * @param kilometrageVehicule Type double.
     * @param anneeMiseCirculationVehicule Type integer.
     */    
    public Vehicule(String numImmatriculationVehicule, String modeleVehicule, String marqueVehicule, double kilometrageVehicule, int anneeMiseCirculationVehicule) {
    	this.numImmatriculationVehicule = numImmatriculationVehicule;
    	this.modeleVehicule = modeleVehicule;
    	this.marqueVehicule = marqueVehicule;
    	this.kilometrageVehicule = kilometrageVehicule;
    	this.anneeMiseCirculationVehicule = anneeMiseCirculationVehicule;
    }

    /**
	 * Getter pour numImmatriculationVehicule.
	 *
	 * @return le numéro d'immatriculation du véhicule.
	 */
	public String getNumImmatriculationVehicule() {
		return numImmatriculationVehicule;
	}

	/**
	 * Getter pour modèle du véhicule.
	 *
	 * @return Le modèle du véhicule.
	 */
	public String getModeleVehicule() {
		return modeleVehicule;
	}

	/**
	 * Getter pour la marque du véhicule.
	 *
	 * @return La marque du véhicule.
	 */
	public String getMarqueVehicule() {
		return marqueVehicule;
	}

	/**
	 * Getter pour kilometrage du véhicule.
	 *
	 * @return le kilometrage du véhicule. 
	 */
	public double getKilometrageVehicule() {
		return kilometrageVehicule;
	}

	/**
	 * Getter pour l'année de mise circulation.
	 *
	 * @return l'année de mise en circulation du véhicule.
	 */
	public int getAnneeMiseCirculationVehicule() {
		return anneeMiseCirculationVehicule;
	}

}

