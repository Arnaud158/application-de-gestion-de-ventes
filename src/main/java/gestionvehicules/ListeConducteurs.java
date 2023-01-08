package gestionvehicules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Permet de créer la liste de conducteurs.
 *
 * @author Vincent Da Silva
 *
 */
public class ListeConducteurs {
	
	/**
     * L'attribut de liste conducteurs.
     */
    private ObservableList<Conducteur> conducteurs;

    /**
     * Constructeur pour initialiser l'observable liste des conducteurs.
     */
    public ListeConducteurs() {
    	conducteurs = FXCollections.observableList(new LinkedList<>());
    }
    
    /**
     * Getter qui retourne la liste des conducteurs.
     * 
     * @return liste des conducteurs
     */
	public ObservableList<Conducteur> getConducteur(){
		return conducteurs;
	}
    
    /**
     * Ajoute le véhicule passer en paramêtre.
     * 
     * @param vehicule Le véhicule voulant être ajouter.
     * @return un boolean si l'ajout à était réaliser.
     */
    public boolean ajouterConducteur(Conducteur conducteur) {
    	Iterator<Conducteur> it = conducteurs.iterator();
    	boolean dejaPresent = false;
    	while(it.hasNext()) {
    		if (it.next().equals(conducteur)) {
    			dejaPresent = true;
    			break;
    		}
    	}
    	if (!dejaPresent) {
    		conducteurs.add(conducteur);
    		return true;
    	}
    	return false;
    }

    /**
     * Supprime le conducteur passer en paramêtre.
     * 
     * @param conducteur Conducteur voulant être supprimer.
     * @return un boolean si la suppression à était réaliser.
     */
    public boolean supprimerConducteur(Conducteur conducteur) {
    	Iterator<Conducteur> it = conducteurs.listIterator();
    	int index = 0;
    	while(it.hasNext()) {
    		if (it.next().equals(conducteur)) {
    			conducteurs.remove(index);
    			return true;
    		}
    		else 
    			index+=1;
    	}
    	return false;
    }

    /**
     * Permer de trier la liste de conducteur avec le type de trie souhaité.
     *
     * @param typeTrie Type enum.
     */
    public void afficherConducteurTries(TypeTrieConducteur typeTrie) {
    	if (TypeTrieConducteur.ALPHABETIQUE == typeTrie)
    		Collections.sort(conducteurs, new ComparateurAlphabetique());
    	else
    		Collections.sort(conducteurs, new ComparateurTypeConducteur());
    }

    /**
     * Renvoie sous forme de message tout les informations de chaque conducteurs.
     */
    public String toString() {
       	String message = "";
    	for (int i = 0; i < conducteurs.size(); i++) {
    		if (conducteurs.get(i) instanceof Commerciaux) 
    			message += conducteurs.get(i).getNomConducteur() + " " + conducteurs.get(i).getPrenomConducteur() + " " + conducteurs.get(i).getNumPermisConduire() + " " + conducteurs.get(i).getTypePermisConduire() + " " + ((Commerciaux) conducteurs.get(i)).getNbVisitesEffectuees() + "      ";
    		else
    			message += conducteurs.get(i).getNomConducteur() + " " + conducteurs.get(i).getPrenomConducteur() + " " + conducteurs.get(i).getNumPermisConduire() + " " + conducteurs.get(i).getTypePermisConduire() + " " + ((Livreurs) conducteurs.get(i)).getNbHeuresConduiteEffectuees() + "      ";
    	}
    	return message;
    }

    /**
     * Renvoie la liste des commerciaux disponible.
     * 
     * @return liste des commerciaux disponoble
     */
	public List<Conducteur> commerciauxDispo() {
		List<Conducteur> liste = new ArrayList<Conducteur>();
		for(Conducteur actuel : conducteurs) {
			if ((actuel instanceof Commerciaux)&&((Commerciaux) actuel).getVoiture()==null) {
				liste.add(actuel);
			}
		}
		return liste;
	}
	
    /**
     * Renvoie la liste des livreurs disponible.
     * 
     * @return liste des livreurs disponible
     */
	public List<Conducteur> livreurDispo() {
		List<Conducteur> liste = new ArrayList<Conducteur>();
		for(Conducteur actuel : conducteurs) {
			if ((actuel instanceof Livreurs)&&((Livreurs) actuel).getFourgon()==null) {
				liste.add(actuel);
			}
		}
		return liste;
	}
    
	/**
	 * Méthode statique qui créer des conducteurs par défauts.
	 * 
	 * @return liste des conducteurs.
	 * @throws HeuresConduitesNegativeException
	 */
    public static ListeConducteurs defautConducteur() throws HeuresConduitesNegativeException {
        ListeConducteurs lst1 = new ListeConducteurs();
        Livreurs l1 = new Livreurs(1200, "Da Silva", "Vincent", "n6", TypePermis.B1);
		Livreurs l2 = new Livreurs(1, "Martin", "Dylan", "n7", TypePermis.AM);
		lst1.ajouterConducteur(l1);
		lst1.ajouterConducteur(l2);
		return lst1;
    }

}