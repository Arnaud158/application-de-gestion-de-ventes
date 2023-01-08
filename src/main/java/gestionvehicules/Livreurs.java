package gestionvehicules;

/**
 * La classe Livreurs heritant de la classe Conducteur, permettant de cr�er un conducteur de type livreur.
 *
 * @author Vincent Da Silva
 *
 */
public class Livreurs extends Conducteur {
	
	/**
     * attribut nbHeuresConduite de type int.
     */
    private int nbHeuresConduiteEffectuees;

    /**
     * Le fourgon assigné au livrueur.
     */
    private Fourgon fourgon;
    
    /**
     * Constructeur de Livreurs permettant d'initialiser les attributs avec le super de conducteur.
     * 
     * @param nbHeuresConduiteEffectuees Type int.
     * @param nomConducteur Type String.
     * @param prenomConducteur Type String.
     * @param numPermisConduire Type String.
     * @param typePermisConduire Type TypePermis.
     * @param fourgon
     * @throws HeuresConduitesNegativeException
     */
    public Livreurs(int nbHeuresConduiteEffectuees, String nomConducteur, String prenomConducteur, String numPermisConduire, TypePermis typePermisConduire, Fourgon fourgon) throws HeuresConduitesNegativeException{
    	super(nomConducteur, prenomConducteur, numPermisConduire, typePermisConduire);
    	this.fourgon = fourgon;
    	if (nbHeuresConduiteEffectuees >= 0) 
    		this.nbHeuresConduiteEffectuees = nbHeuresConduiteEffectuees;
    	else throw new HeuresConduitesNegativeException();
    }

    /**
     * Constructeur de Livreurs permettant d'initialiser les attributs avec le super de conducteur sans fourgon.
     *
     * @param nbHeuresConduiteEffectuees Type int.
     * @param nomConducteur Type String.
     * @param prenomConducteur Type String.
     * @param numPermisConduire Type String.
     * @param typePermisConduire Type TypePermis.
     * @throws HeuresConduitesNegativeException
     */
    public Livreurs(int nbHeuresConduiteEffectuees, String nomConducteur, String prenomConducteur, String numPermisConduire, TypePermis typePermisConduire) throws HeuresConduitesNegativeException{
    	super(nomConducteur, prenomConducteur, numPermisConduire, typePermisConduire);
    	if (nbHeuresConduiteEffectuees >= 0) 
    		this.nbHeuresConduiteEffectuees = nbHeuresConduiteEffectuees;
    	else throw new HeuresConduitesNegativeException();
    }
    
	/**
	 * Getter permettant de récuperer le nombre d'heures de conduite effectuées.
	 *
	 * @return Le nombre d'heure de conduite effectuees.
	 */
	public int getNbHeuresConduiteEffectuees() {
		return nbHeuresConduiteEffectuees;
	}

	/**
	 * Getter du fourgon
	 * 
	 * @return Le fourgon
	 */
	public Fourgon getFourgon() {
		return fourgon;
	}

	/**
	 * Setter du fourgon.
	 * 
	 * @param fourgon
	 */
	public void setFourgon(Fourgon fourgon) {
		this.fourgon = fourgon;
	}


}
