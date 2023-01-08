package sae.model.listeconducteur;

import java.util.Objects;

import sae.model.listevehicule.TypePermis;;

/**
 * Permet de créer un conducteur.
 *
 * @author Vincent Da Silva
 *
 */
public class Conducteur {
	
	/**
     * Attribut nom du conducteur de Type String.
     */
    private String nomConducteur;

    /**
     * Attribut prenom du conducteur de Type String.
     */
    private String prenomConducteur;

    /**
     * Attribut numero de permis de Type String.
     */
    private String numPermisConduire;

    /**
     * Attribut TypePermisConduire de Type TypePermis.
     */
    private TypePermis typePermisConduire;

    /**
     * Constructeur de conducteur qui initialise ses attributs.
     * 
     * @param nomConducteur
     * @param prenomConducteur
     * @param numPermisConduire
     * @param typePermisConduire
     */
    public Conducteur(String nomConducteur, String prenomConducteur, String numPermisConduire, TypePermis typePermisConduire) {
    	this.nomConducteur = nomConducteur;
    	this.prenomConducteur = prenomConducteur;
    	this.numPermisConduire = numPermisConduire;
    	this.typePermisConduire = typePermisConduire;
    }

    /**
     * Getter du nom.
     *
     * @return le nom.
     */
    public String getNomConducteur() {
		return nomConducteur;
	}

	/**
	 * Getter du prenom.
	 *
	 * @return le prenom.
	 */
	public String getPrenomConducteur() {
		return prenomConducteur;
	}

	/**
	 * Getter du numero de permis.
	 *
	 * @return le numero de permis.
	 */
	public String getNumPermisConduire() {
		return numPermisConduire;
	}

	/**
	 * Getteur du type de permis du conducteur.
	 *
	 * @return le type de permis.
	 */
	public TypePermis getTypePermisConduire() {
		return typePermisConduire;
	}
	/**
	 * Methode equals.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conducteur other = (Conducteur) obj;
		return Objects.equals(nomConducteur, other.nomConducteur)
				&& Objects.equals(prenomConducteur, other.prenomConducteur);
	}

}