package gestionvehicules;

/**
 * Classe Fourgon héritant de la classe Véhicule permettant de créer un véhicule avec des attributs supplémentaires pour un fourgon.
 *
 * @author Vincent Da Silva
 *
 */
public class Fourgon extends Vehicule {
    
	/**
     * Attribut volume maximal en kilogramme du fourgon de type double.
     */
    private double volumeMaximalKilogramme;

    /**
     * Attribut volume maximal en mètre cube du fourgon de type double.
     */
    private double volumeMaximalMetreCube;

    /**
     * Attribut livreur du fougon de type Livreur.
     */
    private Livreurs livreur;

    /**
     * Constructeur de fourgon permettant de d'initialiser les attributs ainsi que les attributs de la classe véhicule.
     *
     * @param volumeMaximalKilogramme Type double.
     * @param volumeMaximalMetreCube Type double.
     * @param numImmatriculationVehicule Type String.
     * @param modeleVehicule Type String.
     * @param marqueVehicule Type String.
     * @param kilometrageVehicule Type double.
     * @param anneeMiseCirculationVehicule Type int.
     * @param livreur Type Livreur.
     */
    public Fourgon(double volumeMaximalKilogramme, double volumeMaximalMetreCube, String numImmatriculationVehicule, String modeleVehicule, String marqueVehicule, double kilometrageVehicule, int anneeMiseCirculationVehicule, Livreurs livreur) {
    	super(numImmatriculationVehicule, modeleVehicule, marqueVehicule, kilometrageVehicule, anneeMiseCirculationVehicule);
    	this.volumeMaximalKilogramme = volumeMaximalKilogramme;
    	this.volumeMaximalMetreCube = volumeMaximalMetreCube;
    	this.livreur = livreur;
    }

    /**
     * Constructeur de fourgon permettant de d'initialiser les attributs sans Livreur, ainsi que les attributs de la classe véhicule.
     * 
     * @param volumeMaximalKilogramme Type double.
     * @param volumeMaximalMetreCube Type double.
     * @param numImmatriculationVehicule Type String.
     * @param modeleVehicule Type String.
     * @param marqueVehicule Type String.
     * @param kilometrageVehicule Type double.
     * @param anneeMiseCirculationVehicule Type int.
     */
	public Fourgon(double volumeMaximalKilogramme, double volumeMaximalMetreCube, String numImmatriculationVehicule, String modeleVehicule, String marqueVehicule, double kilometrageVehicule, int anneeMiseCirculationVehicule) {
    	super(numImmatriculationVehicule, modeleVehicule, marqueVehicule, kilometrageVehicule, anneeMiseCirculationVehicule);
    	this.volumeMaximalKilogramme = volumeMaximalKilogramme;
    	this.volumeMaximalMetreCube = volumeMaximalMetreCube;
	}

	/**
	 * Getter de volume maximal en kilogramme du fourgon.
	 *
	 * @return le volume maximal en kilogramme.
	 */
	public double getVolumeMaximalKilogramme() {
		return volumeMaximalKilogramme;
	}

	/**
	 * Getter de volume maximal en metre cube du fourgon.
	 *
	 * @return le volume maximal en metre cube.
	 */
	public double getVolumeMaximalMetreCube() {
		return volumeMaximalMetreCube;
	}

	/**
	 * Getter du livreur assigner au fourgon.
	 * 
	 * @return le livreur du fourgon.
 	 */
	public Livreurs getLivreur() {
		return livreur;
	}


}