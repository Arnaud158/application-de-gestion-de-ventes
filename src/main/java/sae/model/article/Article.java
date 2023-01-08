package sae.model.article;

import javafx.collections.ObservableList;
import util.Util;

/**
 * Un objet de la classe Article correspond à un article/produit vendu par l'entreprise.
 * Chaque article considéré se vend à l'unité (il ne se vend pas par exemple au kilo).
 * Chaque article a un numéro de référence (un entier) qui lui est propre et qui permet de l'identifier, une catégorie (une chaîne de caractères), une désignation (une chaîne de caractères),
 * un prix à l'unité en euros (un double) et une quantité en stock (un entier). 
 * 
 * @author Jean-François Condotta
 * @version 16/03/22
 */
public class Article {

	/**
	 * Le nombre d'articles créés (qui sera notamment utilisé pour la génération du numéro de référence de chaque article). Il sera initialisé à 0.
	 */
	static private int nbArticles=0;

	/**
	 * Le numéro de référence de l'article.
	 * Le premier article aura la référence 0, le deuxième la référence 1, le troisième la référence 2 ...
	 */
	private int reference;


	/**
	 * La catégorie de l'article.
	 */
	private String categorie;

	/**
	 * La désignation de l'article.
	 */
	private String designation;

	/**
	 * Le prix à l'unité.
	 */
	private double prix;

	/**
	 * La quantité en stock.
	 */
	private int quantiteStock;


	/**
	 * Constructeur permettant de créer un nouvel article.
	 * Son numéro de référence est généré automatiquement.
	 * @param categorie La catégorie de l'article.
	 * @param designation La désignation de l'article.
	 * @param prix Le prix de l'article (si strictement inférieur à 0.0 alors 0.0 est mis comme prix).
	 * @param quantiteStock La quantité initiale en stock de l'article (si strictement inférieure à 0 alors 0 est mis comme quantité).
	 */
	protected Article(String categorie, String designation, double prix, int quantiteStock) {
		this.reference = nbArticles++;
		this.categorie = categorie;
		this.designation = designation;
		setPrix(prix);
		setQuantiteStock(quantiteStock);
	}

	/**
	 * Constructeur permettant de créer un nouvel article avec comme catégorie "Aucune".
	 * Son numéro de référence est généré automatiquement.
	 * @param designation La désignation de l'article.
	 * @param prix Le prix de l'article (si strictement inférieur à 0.0 alors 0.0 est mis comme prix).
	 * @param quantiteStock La quantité initiale en stock de l'article (si strictement inférieure à 0 alors 0 est mis comme quantité).
	 */
	public Article(String designation, double prix, int quantiteStock) {
		this("Aucune",designation,prix,quantiteStock);
	}

	/**
	 * Constructeur permettant de créer un nouvel article avec comme catégorie "Aucune".
	 * Son numéro de référence est généré automatiquement.
	 * Les autres informations sont saisies au clavier avec la méthode saisirInfos().
	 */
	public Article() {
		this("Aucune","",0.0,0);
		saisirInfos();
	}

	/**
	 * Méthode permettant de saisir la désignation, le prix et la quantité en stock d'un article.
	 * La catégorie n'est pas saisie. Il faut qu'elle soit initialisée par ailleurs.
	 */
	public void saisirInfos() {
		designation=Util.saisirChaine("Désignation : ");
		setPrix(Util.saisirDoublePositif("Prix Unitaire : "));
		setQuantiteStock(Util.saisirEntierPositif("Quantité stock : "));
	}

	/**
	 * Méthode retournant le prix de l'article.
	 * @return Le prix de l'article.
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * Méthode permettant de modifier le prix d'un article.
	 * Dans le cas où le prix donné en paramètre est strictement inférieur à 0.0, la valeur 0.0 est mise comme prix.
	 * @param prix Le nouveau prix de l'article.
	 */
	public void setPrix(double prix) {
		if (prix<0.0)
			prix=0.0;
		this.prix = prix;
	}

	/**
	 * Méthode retournant la quantité en stock de l'article.
	 * @return La quantité en stock de l'article.
	 */
	public int getQuantiteStock() {
		return quantiteStock;
	}

	/**
	 * Méthode retournant si le produit est disponible (i.e. si sa quantité en stock est strictement supérieure à 0).
	 * @return true si et seulement si sa quantité en stock est strictement supérieure à 0.
	 */
	public boolean estDisponible() {
		return quantiteStock>0;
	}
	/**
	 * Méthode permettant de modifier la quantité en stock de l'article.
	 * Dans le cas où la quantité en stock donnée en paramètre est strictement inférieure à 0 alors 0 est mis à la place.
	 * @param quantiteStock La nouvelle quantité en stock de l'article.
	 */
	public void setQuantiteStock(int quantiteStock) {
		if (quantiteStock<0)
			quantiteStock=0;
		this.quantiteStock = quantiteStock;
	}

	/**
	 * Méthode permettant d'ajouter une quantité à la quantité en stock de l'article.
	 * Dans le cas où la quantité à ajouter est strictement inférieure à 0 alors la quantité en stock n'est pas modifiée.
	 * @param quantite La quantité à ajouter à la quantité en stock de l'article.
	 */
	public void ajouterQuantiteStock(int quantite) {
		if (quantite<0)
			quantite=0;
		quantiteStock = quantiteStock+quantite;
	}

	/**
	 * Méthode permettant de supprimer une quantité à la quantité en stock de l'article.
	 * Dans le cas où la quantité à enlever est strictement inférieure à 0 alors la quantité en stock n'est pas modifiée.
	 * Dans le cas où la quantité à enlever est supérieure à la quantité en stock alors
	 * la quantité en stock devient 0.
	 * @param quantite La quantité à enlever.
	 */
	public void enleverQuantiteStock(int quantite) {
		if (quantite<0)
			quantite=0;
		if (quantite>quantiteStock)
			quantite=quantiteStock;
		quantiteStock = quantiteStock-quantite;
	}

	/**
	 * Méthode retournant le numéro de référence de l'article.
	 * @return La référence de l'article.
	 */
	public int getReference() {
		return reference;
	}

	/**
	 * Méthode retournant la catégorie de l'article.
	 * @return La catégorie de l'article.
	 */
	public String getCategorie() {
		return categorie;
	}

	/**
	 * Méthode retournant la désignation de l'article.
	 * @return La désignation de l'article.
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Méthode (redéfinition de toString()) retournant une représentation textuelle.
	 * Cette représentation contient la référence, la désignation, la catégorie, le prix unitaire et la quantité en stock de l'article.
	 * @return Représentation textuelle de l'article.
	 */
	public String toString() {
		return "Référence :\t\t"+ reference + "\nDésignation :\t\t" + designation + "\nCatégorie :\t\t" + categorie + "\nPrix Unitaire :\t\t"+ prix+ "\nQuantité en Stock :\t"+ quantiteStock;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return reference == other.reference;
	}

	/**
	 * Méthode permettant d'afficher les articles d'un tableau d'articles.
	 * @param articles Le tableau contenant les articles à afficher, chaque élément du tableau contient une référence non null.
	 */
	static public void afficherTabArticles(ObservableList<Article> articles) {
		System.out.println("----------------------------------------------------------------------------------------");
		for (int i=0;i<articles.size();i++) {
			System.out.println(articles.get(i));
			System.out.println("----------------------------------------------------------------------------------------");
		}

	}
}
