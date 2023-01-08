package gestionvehicules;

/**
 * Classe Commerciaux héritant de la classe Conducteur permettant de créer un conducteur avec d'autre attributs.
 *
 * @author Vincent Da Silva
 *
 */
public class Commerciaux extends Conducteur {
	
	/**
     * Attribut nbVisitesEffectuees de type int.
     */
    private int nbVisitesEffectuees;
    
    /**
     * Attribut voiture du Commercial.
     */
    private Voiture voiture;

    /**
     * Constructeur de Commerciaux initialisant les attributs et les attributs de la classe conducteur.
     * 
     * @param nbVisitesEffectuees Type integer.
     * @param nomConducteur Type String.
     * @param prenomConducteur Type String.
     * @param numPermisConduire Type String.
     * @param typePermisConduire Type TypePermis.
     * @param voiture Type Voiture.
     * @throws VisitesNegatifException
     */
    public Commerciaux(int nbVisitesEffectuees, String nomConducteur, String prenomConducteur, String numPermisConduire, TypePermis typePermisConduire, Voiture voiture) throws VisitesNegatifException {
    	super(nomConducteur, prenomConducteur, numPermisConduire, typePermisConduire);
    	this.voiture = voiture;
    	if (nbVisitesEffectuees >= 0)
    		this.nbVisitesEffectuees = nbVisitesEffectuees;
    	else throw new VisitesNegatifException();
    }

    /**
     * Constructeur de Commerciaux initialisant les attributs et les attributs de la classe conducteur sans avoir de voiture.
     * 
     * @param nbVisitesEffectuees Type integer.
     * @param nomConducteur Type String.
     * @param prenomConducteur Type String.
     * @param numPermisConduire Type String.
     * @param typePermisConduire Type TypePermis.
     * @throws VisitesNegatifException
     */
    public Commerciaux(int nbVisitesEffectuees, String nomConducteur, String prenomConducteur, String numPermisConduire, TypePermis typePermisConduire) throws VisitesNegatifException {
    	super(nomConducteur, prenomConducteur, numPermisConduire, typePermisConduire);
    	if (nbVisitesEffectuees >= 0)
    		this.nbVisitesEffectuees = nbVisitesEffectuees;
    	else throw new VisitesNegatifException();
    }
    
	/**
	 * Getter du nombre de visites éffectuées.
	 *
	 * @return le nombre de visites totale.
	 */
	public int getNbVisitesEffectuees() {
		return nbVisitesEffectuees;
	}
    
	/**
	 * Getter de la voiture.
	 * 
	 * @return la voiture
	 */
	public Voiture getVoiture() {
		return voiture;
	}
	
	/**
	 * Setter de la voiture.
	 * 
	 * @param la voiture
	 */
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
    
}
