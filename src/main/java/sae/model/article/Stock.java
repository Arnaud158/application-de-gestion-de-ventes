package sae.model.article;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Un objet de la classe Stock correspond à un stock d'articles.
 * Chaque stock a un nom ("Stock 2022" par exemple) et permet de gérer le stock d'un ensemble d'articles.
 * Un stock ne peut pas contenir plus de Stock.MAX_ARTICLES articles.
 * 
 * @author Jean-François Condotta
 * @version 16/03/22
 */
public class Stock {
	/**
	 * Le nombre maximal d'articles pouvant être dans un stock (valué à 10).
	 */
	static final public int MAX_ARTICLES=10;
	
	/**
	 * Les articles se trouvant dans le stock.
	 */
	private ObservableList<Article> articles;
	
	/**
	 * Le nombre d'articles dans le stock. Les articles sont toujours placés en début du tableau articles.
	 */
	private int nbArticles;

	/**
	 * Le nom du stock.
	 */
	private String nom;
	
	/**
	 * Constructeur permettant de construire un nouveau stock.
	 * 
	 * @param nom Le nom du stock.
	 */
	public Stock(String nom) {
		this.nom=nom;
		articles= FXCollections.observableArrayList();
		nbArticles=0;
	}
	
	/**
	 * Cr��e un stock d'articles contenant des articles par d�faut.
	 * 
	 * @return Le stock d'articles par d�faut.
	 */
	public static Stock defautStock() {
		Stock stock = new Stock("MonStock");
		stock.ajouterArticle(new ArticleCat1("Le meilleur article de categorie 1",15,12,100));
		stock.ajouterArticle(new ArticleCat2("Le plus incroyable article de categorie 2",25,4,79));
		return stock;
	}
	
	/**
	 * Méthode testant si le stock est plein (si on ne peut pas ajouter de nouveaux articles).
	 * @return true si et seulement si le stock est plein.
	 */
	public boolean estPlein() {
		return nbArticles==MAX_ARTICLES;
	}
	/**
	 * Méthode testant si le stock est vide (il n'y a aucun article dans le stock, i.e. nbArticles vaut 0).
	 * @return true si et seulement si le stock est vide.
	 */
	public boolean estVide() {
		return nbArticles==0;
	}
	
	/**
	 * Méthode cherchant un article dans le tableau articles correspondant (ayant même référence) à l'article passé en parmaètre. 
	 * @param article Un article (supposé non null).
	 * @return L'indice où se trouve cet article dans le tableau articles. Dans le cas où l'article n'est pas présent -1 est retourné.
	 */
	private int chercherIndiceArticle(Article article) {
		for (int i=0;i<nbArticles;i++)
			if (article.equals(articles.get(i)))
				return i;
		return -1;
	}
	
	/**
	 * Méthode permettant d'ajouter un article dans le stock.
	 * Dans le cas où le stock est plein ou bien l'article est déjà présent dans le stock, rien est fait.
	 * Dans le cas contraire l'article est inséré dans le stock.
	 * @param article Un article (supposé non null).
	 */
	public void ajouterArticle(Article article) {
		if ((estPlein())||(chercherIndiceArticle(article)!=-1))
			return;
		articles.add(nbArticles++,article);
	}
	
	/**
	 * Méthode permettant de supprimer un article du stock.
	 * Rien est fait dans le cas où l'article n'est pas présent dans le stock.
	 * @param article Un article (supposé non null).
	 */
	public void supprimerArticle(Article article) {
		int indice=chercherIndiceArticle(article);
		if (indice==-1)
			return;
		articles.remove(indice);
		nbArticles--;
	}
	
	/**
	 * Méthode permettant de chercher un article dans le stock avec son numéro de référence.
	 * @param refArticle La référence de l'article recherché.
	 * @return L'article dans le stock ayant refArticle comme référence ou null si un tel article n'existe pas.
	 */
	public Article rechercherArticleParReference(int refArticle) {
		for (int i=0;i<nbArticles;i++)
			if (articles.get(i).getReference()==refArticle)
				return articles.get(i);
		return null;
	}

	/**
	 * Méthode retournant un nouveau tableau contenant les articles du stock.
	 * Le tableau retourné a pour taille getNbArticles().
	 * @return Un nouveau tableau non null contenant les articles du stock.
	 */
	public ObservableList<Article> articlesDansStock() {
		ObservableList<Article> list=FXCollections.observableArrayList();
		for (int i=0;i<nbArticles;i++)
			list.add(i,articles.get(i));
		return list;
	}
	
	/**
	 * Méthode permettant de chercher les articles du stock d'une certaine catégorie.
	 * La méthode retourne un tableau d'articles (toujours non null et pouvant contenir aucun élément si aucun article a été sélectionné).
	 * 
	 * @param categorie La catégorie pour laquelle nous souhaitons les articles.
	 * @return Un tableau contenant les articles trouvés dans le stock avec la catégorie passée en paramètre.
	 */
	public ObservableList<Article> rechercherArticlesCategorie(String categorie) {
		int nb=0;
		ObservableList<Article> selection=null;
		for (int i=0;i<nbArticles;i++)
			if (articles.get(i).getCategorie().equals(categorie))
				nb++;
		selection=FXCollections.observableArrayList();
		nb=0;
		for (int i=0;i<nbArticles;i++)
			if (articles.get(i).getCategorie().equals(categorie))
				selection.add(nb++, articles.get(i));
		return selection;
	}
	

	/**
	 * Méthode retournant le nom du stock.
	 * @return Le nom du stock.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Méthode permettant de modifier le nom du stock.
	 * @param nom Le nouveau nom du stock.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Méthode retournant le nombre d'articles du stock.
	 * @return Le nombre d'articles du stock.
	 */
	public int getNbArticles() {
		return nbArticles;
	}
	
	public ObservableList<Article> getArticles(){
		return articles;
	}
}
