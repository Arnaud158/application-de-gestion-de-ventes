package util;

import java.util.Scanner;

/**
 * Classe contenant quelques méthodes utiles notamment des méthodes de saisie.
 *  
 * @author Jean-François Condotta
 * @version 15/03/22
 *
 */
public class Util {

	public static final Scanner scannerClavier=new Scanner(System.in); // Un scanner associé au clavier.

	/**
	 * Méthode permettant d'effectuer la saisie au clavier d'un nombre entier compris (au sens large) entre deux valeurs (min et max).
	 * Un message (si non null) est affiché à l'écran avant d'effectuer la saisie. 
	 * @param min La valeur minimale.
	 * @param max La valeur maximale (max doit être supérieure ou égal à min).
	 * @param message Le message affiché avant la saisie (si null rien n'est affiché).
	 * @return Un entier saisi au clavier compris entre min et max (au sens large).
	 */
	public static int saisirEntier(int min,int max,String message) {
		int resultat;
		String saisie;
		while (true) {
			if (message!=null) 
				System.out.println(message);
			saisie=scannerClavier.nextLine();
			try {
				resultat=Integer.parseInt(saisie);
				if ((resultat>=min)&&(resultat<=max))
					return resultat;
				System.out.println("Saisie non valide !");
			}catch(Exception e){
				System.out.println("Saisie non valide !");
			}
		}
	}


	/**
	 * Méthode permettant d'effectuer la saisie au clavier d'un nombre entier positif (possiblement 0).
	 * Un message (si non null) est affiché à l'écran avant d'effectuer la saisie. 
	 * @param message Le message affiché avant la saisie (si null rien n'est affiché).
	 * @return Un entier saisi au clavier compris entre min et max (au sens large).
	 */
	public static int saisirEntierPositif(String message) {
		return saisirEntier(0,Integer.MAX_VALUE,message);
	}

	/**
	 * Méthode permettant d'effectuer la saisie au clavier d'un nombre entier compris (au sens large) entre deux valeurs (min et max).
	 * @param min La valeur minimale.
	 * @param max La valeur maximale (max doit être supérieure ou égal à min).
	 * @return Un entier saisi au clavier compris entre min et max (au sens large).
	 */
	public static int saisirEntier(int min,int max) {
		return saisirEntier(min,max,null);
	}


	/**
	 * Méthode permettant d'effectuer la saisie au clavier d'un nombre de type double (possiblement 0.0).
	 * Un message (si non null) est affiché à l'écran avant d'effectuer la saisie. 
	 * @param message Le message affiché avant la saisie (si null rien n'est affiché).
	 * @return Un double saisi au clavier (supérieur ou égal à 0.0).
	 */
	public static double saisirDoublePositif(String message) {
		double resultat;
		String saisie;
		while (true) {
			if (message!=null) 
				System.out.println(message);
			saisie=scannerClavier.nextLine();
			try {
				resultat=Double.parseDouble(saisie);
				if (resultat>=0.0)
					return resultat;
				System.out.println("Saisie non valide !");
			}catch(Exception e){
				System.out.println("Saisie non valide !");
			}
		}
	}

	/**
	 * Méthode permettant de saisir une chaîne de caractères contenant au moins un caractère.
	 * Un message (si non null) est affiché à l'écran avant d'effectuer la saisie. 
	 * @param message Le message affiché avant la saisie (si null rien n'est affiché).
	 * @return La chaîne de caractères saisie.
	 */
	public static String saisirChaine(String message) {
		String saisie;
		while (true) {
			if (message!=null) 
				System.out.println(message);
			saisie=scannerClavier.nextLine();
			if (saisie.length()>0)
				return saisie;
		}
	}

	/**
	 * Méthode permettant de saisir une chaîne de caractères contenant au moins un caractère.
	 * @return La chaîne de caractères saisie.
	 */
	public static String saisirChaine() {
		String saisie;
		while (true) {
			saisie=scannerClavier.nextLine();
			if (saisie.length()>0)
				return saisie;
		}
	}

	/**
	 * Méthode affichant un menu donné en paramètre et demandant à l'utilisateur une des entrées de ce menu.
	 * La méthode affiche le menu et oblige une saisie de l'utilisateur. 
	 * @param menu Un tableau de chaîne de caractères représentant les entrées du menu.
	 * @return Un entier compris entre 0 et menu.length-1.
	 */
	public static int saisirMenu(String[] menu) {
		for (int i=0;i<menu.length;i++)
			System.out.println(""+i+" : "+menu[i]);
		return saisirEntier(0,menu.length-1,"\nVotre choix >>> ");
	}

	/**
	 * Méthode permettant de poser une question binaire à l'utilisateur. L'utilisateur doit saisir une réponse parmi deux choix.
	 * @param question La question posée (doit être non null). 
	 * @param choix1 Le premier choix de réponse (doit être non null et contenir au moins un caractère).
	 * @param choix2 Le second choix de réponse (doit être non null et contenir au moins un caractère).
	 * @return true si et seulement si le premier choix a été saisi par l'utilisateur.
	 */
	public static boolean questionBinaire(String question,String choix1,String choix2) {
		String saisie;
		while (true) {
			saisie=saisirChaine(question);
			if (saisie.equals(choix1))
				return true;
			if (saisie.equals(choix2))
				return false;
		}
	}

	public static void main(String[] args) {
		int i=saisirEntier(3,10,"Veuillez saisir un entier compris entre 3 et 10 :");
		System.out.println("Entier saisi : "+i);
		System.out.println("Veuillez saisir un entier compris entre 3 et 10 :");
		i=saisirEntier(3,10);
		System.out.println("Entier saisi : "+i);
		String s=saisirChaine("Veuillez saisir une chaîne de caractère non vide :");
		System.out.println("Chaîne de caractères saisie : "+s);
		System.out.println("Veuillez saisir une chaîne de caractère non vide :");
		s=saisirChaine();
		System.out.println("Chaîne de caractères saisie : "+s);
		boolean b=questionBinaire("Allez-vous bien ? (Oui/Non)","Oui","Non");
		if (b)
			System.out.println("Vous allez bien ...");
		else
			System.out.println("Vous n'allez pas bien ... J'espère que cela ira mieux !");

	}

}
