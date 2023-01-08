package sae.model.exception;

/**
 * Créer une exception si le nombre d'heures de conduites est négatif.
 *
 * @author Vincent Da Silva
 *
 */
public class HeuresConduitesNegativeException extends Exception {
	
	/**
	 * Le constructeur de l'exception permettant de renvoyer un message.
	 */
	public HeuresConduitesNegativeException() {
		super("Nombre de kilometres n�gatif");
	}

}
