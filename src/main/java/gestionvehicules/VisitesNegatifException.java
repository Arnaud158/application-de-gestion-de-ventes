package gestionvehicules;

/**
 * Permet de renvoyer une exception si le nombre de visites indiquer est négatif.
 *
 * @author Vincent Da Silva
 *
 */
public class VisitesNegatifException extends Exception{
	
	/**
	 * Constructeur de l'exception permettant de renvoyer un message.
	 */
	public VisitesNegatifException() {
		super("Nombre de visites n�gative");
	}
}
