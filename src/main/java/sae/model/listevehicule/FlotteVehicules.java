package sae.model.listevehicule;

import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sae.model.comparateur.ComparateurAnneeCirculation;
import sae.model.comparateur.ComparateurTypeVehicule;

/**
 * Permet de créer une liste de véhicules.
 *
 * @author Vincent Da Silva.
 *
 */
public class FlotteVehicules {
	
	/**
	 * l'attribut de la liste véhicules.
	 */
    private ObservableList<Vehicule> vehicules;

    /**
     * Constructeur pour initialiser l'observable liste des vehicules.
     */
    public FlotteVehicules() {
    	vehicules = FXCollections.observableList(new ArrayList<>());
    }
    
    /**
     * Getter de la liste de véhicules
     * 
     * @return la liste de véhicules.
     */
	public ObservableList<Vehicule> getVehicule() {
		return vehicules;
	}
    
    /**
     * Retourne l'index du véhicule passé en paramètre.
     * 
     * @param vehicule
     * @return L'index de véhicule dans la liste.
     */
    private int indexVehicule(Vehicule vehicule) {
    	for (int i = 0; i < vehicules.size(); i++) {
    		if (vehicules.get(i).equals(vehicule))
    			return i;
    	}
    	return -1;
    }
	
    /**
     * Ajoute le véhicule passé en paramètre.
     * 
     * @param vehicule Le véhicule voulant être ajouté.
     * @return un boolean si l'ajout à était réaliser.
     */
    public boolean ajouteVehicule(Vehicule vehicule) {
    	if (indexVehicule(vehicule) == -1) {
    		vehicules.add(vehicule);
    		return true;
    	}
    	else
    		return false;
    }

    /**
     * Supprime le véhicule passer en paramètre.
     * 
     * @param vehicule Le véhicule voulant être supprimé.
     * @return un boolean si la suppression à était réaliser.
     */
    public boolean supprimerVehicule(Vehicule vehicule) {
    	int index = indexVehicule(vehicule);
    	if(index == -1)
    		return false;
    	else {
    		vehicules.remove(index);
    		return true;
    	}
    }

    /**
     * Permet de trier la liste de véhicules avec le type de trie souhaité.
     *
     * @param typeTrieVehicule Type enum.
     */
    public void afficherVehiculeTries(TypeTrieVehicule typeTrie) {
    	if (TypeTrieVehicule.ANNEE == typeTrie)
    		Collections.sort(vehicules, new ComparateurAnneeCirculation());
    	else
    		Collections.sort(vehicules, new ComparateurTypeVehicule());
    }

    /**
     * Renvoie sous forme de message tout les informations de chaques vehicules.
     */
    public String toString() {
       	String message = "";
    	for (int i = 0; i < vehicules.size(); i++) {
    		if (vehicules.get(i) instanceof Fourgon) 
    			message += vehicules.get(i).getKilometrageVehicule() + " " + vehicules.get(i).getAnneeMiseCirculationVehicule() + " " + vehicules.get(i).getMarqueVehicule() + " " + vehicules.get(i).getModeleVehicule() + " " + vehicules.get(i).getNumImmatriculationVehicule() + " " + ((Fourgon) vehicules.get(i)).getVolumeMaximalKilogramme() + " " + ((Fourgon) vehicules.get(i)).getVolumeMaximalMetreCube() + "       ";
    		else
    			message += vehicules.get(i).getKilometrageVehicule() + " " + vehicules.get(i).getAnneeMiseCirculationVehicule() + " " + vehicules.get(i).getMarqueVehicule() + " " + vehicules.get(i).getModeleVehicule() + " " + vehicules.get(i).getNumImmatriculationVehicule() + "       ";
    	}
    	return message;
    }
    
    /**
     * Créer une liste de véhicules par défaut.
     * 
     * @return la liste des véhicules.
     */
    public static FlotteVehicules defautVehicule() {
    	FlotteVehicules lst2 = new FlotteVehicules();
    	Voiture v1 = new Voiture("mn-128-bk", "c5", "citroen", 12000, 2020);
		Voiture v2 = new Voiture("ah-256-oi", "e", "tesla", 12, 2014);
		Fourgon f1 = new Fourgon(12, 12, "cc-212-lk", "zoe", "renault", 2000, 2015);
		Fourgon f2 = new Fourgon(24, 24, "ok-873-tf", "chiron", "bugatti", 5000, 2018);
		lst2.ajouteVehicule(f1);
		lst2.ajouteVehicule(v1);
		lst2.ajouteVehicule(f2);
		lst2.ajouteVehicule(v2);
		return lst2;
    	
    }
    	
}