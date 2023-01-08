package sae.test;

import sae.model.exception.HeuresConduitesNegativeException;
import sae.model.exception.VisitesNegatifException;
import sae.model.listeconducteur.Commerciaux;
import sae.model.listeconducteur.ListeConducteurs;
import sae.model.listeconducteur.Livreurs;
import sae.model.listeconducteur.TypeTrieConducteur;
import sae.model.listevehicule.FlotteVehicules;
import sae.model.listevehicule.Fourgon;
import sae.model.listevehicule.TypePermis;
import sae.model.listevehicule.TypeTrieVehicule;
import sae.model.listevehicule.Voiture;

public class TestGestionVehicules {
	
	public static void main(String[]args) throws HeuresConduitesNegativeException, VisitesNegatifException {
		
		ListeConducteurs lst1 = new ListeConducteurs();
		FlotteVehicules lst2 = new FlotteVehicules();
		
		Commerciaux c1 = new Commerciaux(5, "Lepetz", "Thimoth�e", "n1", TypePermis.A2);
		Commerciaux c2 = new Commerciaux(15, "Fievet", "Arnaud", "n2", TypePermis.AM);
		Commerciaux c3 = new Commerciaux(25, "Logier", "Elsa", "n3", TypePermis.B1);
		Commerciaux c4 = new Commerciaux(35, "Facon", "Nicolas", "n4", TypePermis.C);
		Commerciaux c5 = new Commerciaux(45, "Sontag", "Maxime", "n5", TypePermis.T);
		
		Livreurs l1 = new Livreurs(1200, "Da Silva", "Vincent", "n6", TypePermis.B1);
		Livreurs l2 = new Livreurs(1, "Martin", "Dylan", "n7", TypePermis.AM);
		Livreurs l3 = new Livreurs(50, "Grebert", "Pierre", "n8", TypePermis.A2);
		Livreurs l4 = new Livreurs(100, "Dewadder", "Maxence", "n9", TypePermis.C);
		Livreurs l5 = new Livreurs(225, "Cure", "Hector", "n10", TypePermis.L);
		
		Voiture v1 = new Voiture("mn-128-bk", "c5", "citroen", 12000, 2020, c1);
		Voiture v2 = new Voiture("ah-256-oi", "e", "tesla", 12, 2014, c2);
		Voiture v3 = new Voiture("bl-514-me", "i3", "bmw", 152, 2005, c3);
		Voiture v4 = new Voiture("ir-128-kr", "i4", "bmw", 1, 2022, c4);
		Voiture v5 = new Voiture("lp-874-hr", "chiron", "bugatti", 1586, 2018, c5);
		
		Fourgon f1 = new Fourgon(12, 12, "cc-212-lk", "zoe", "renault", 2000, 2015, l1);
		Fourgon f2 = new Fourgon(24, 24, "ok-873-tf", "chiron", "bugatti", 5000, 2018, l2);
		Fourgon f3 = new Fourgon(48, 48, "mp-598-le", "fiat500", "fiat", 1000, 2010, l3);
		Fourgon f4 = new Fourgon(96, 96, "jp-004-og", "kayenne", "porsche", 200, 2022, l4);
		Fourgon f5 = new Fourgon(191, 192, "fr-007-ms", "aventador", "lamborghini", 1, 2022, l5);
		
		lst1.ajouterConducteur(l1);
		lst1.ajouterConducteur(c1);
		lst1.ajouterConducteur(l2);
		lst1.ajouterConducteur(c2);
		lst1.ajouterConducteur(l3);
		lst1.ajouterConducteur(c3);
		lst1.ajouterConducteur(l4);
		lst1.ajouterConducteur(c4);
		lst1.ajouterConducteur(l5);
		lst1.ajouterConducteur(c5);
		
		lst2.ajouteVehicule(f1);
		lst2.ajouteVehicule(v1);
		lst2.ajouteVehicule(f2);
		lst2.ajouteVehicule(v2);
		lst2.ajouteVehicule(f3);
		lst2.ajouteVehicule(v3);
		lst2.ajouteVehicule(f4);
		lst2.ajouteVehicule(v4);
		lst2.ajouteVehicule(f5);
		lst2.ajouteVehicule(v5);
		
		System.out.println(lst1.toString());
		System.out.println(lst2.toString());
		
		lst1.afficherConducteurTries(TypeTrieConducteur.ALPHABETIQUE);
		System.out.println(lst1.toString());
		
		lst1.afficherConducteurTries(TypeTrieConducteur.TYPE);
		System.out.println(lst1.toString());
		
		lst2.afficherVehiculeTries(TypeTrieVehicule.ANNEE);
		System.out.println(lst2.toString());
		
		lst2.afficherVehiculeTries(TypeTrieVehicule.TYPE);
		System.out.println(lst2.toString());
	}
}
