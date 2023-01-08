package sae.model.article;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@ExtendWith(MockitoExtension.class)
class StockTest {

	@Mock
	Article a1;

	@Mock
	Article a2;

	@Mock
	Article a3;

	Stock stock;

	@BeforeEach
	public void init() {
		stock = new Stock("Stock test");
		stock.ajouterArticle(a1);
		stock.ajouterArticle(a2);
	}

	@AfterEach
	public void nettoyage() {
		stock = null;
	}

	@Test
	@DisplayName("Test du constructeur permettant de créer un nouveau stock.")
	void testConstructeur() {
		Stock s = new Stock("Stock test");
		assertThat(s).isInstanceOf(Stock.class);
		assertThat(s.getNom()).isEqualTo("Stock test");
		assertThat(s.estVide()).isTrue();

	}

	@Test
	@DisplayName("Test de la méthode ajouterArticle permettant d'ajouter un objet au stock.")
	void testAjouterArticle() {
		Stock s = new Stock("Stock test");
		s.ajouterArticle(a1);
		s.ajouterArticle(a2);
		assertThat(s.getNbArticles()).isEqualTo(2);
		
		// Ajout d'un article déjà ajouté
		s.ajouterArticle(a2);
		assertThat(s.getNbArticles()).isEqualTo(2);
	}

	@Test
	@DisplayName("Test de la méthode supprimerArticle permettant d'enlever un objet du stock.")
	void testSupprimerArticle() {
		stock.supprimerArticle(a1);
		assertThat(stock.getNbArticles()).isEqualTo(1);
		
		// Suppression d'un article non présent dans le stock
		stock.supprimerArticle(a1);
		assertThat(stock.getNbArticles()).isEqualTo(1);
	}

	@Test
	@DisplayName("Test de la méthode rechercherArticleParReference permettant de trouver un article grâce à son id de référence.")
	void testRechercherArticleParReference() {
		when(a1.getReference()).thenReturn(0);
		when(a2.getReference()).thenReturn(1);

		Article articleObtenu = stock.rechercherArticleParReference(1);

		assertThat(articleObtenu).isEqualTo(a2);
		
		// Article non existant
		articleObtenu = stock.rechercherArticleParReference(50);

		assertThat(articleObtenu).isNull();
	}

	@Test
	@DisplayName("Test de la méthode rechercherArticlesCategorie qui retourne une liste des articles qui ont comme catégorie la catégorie mis en argument.")
	void testRechercherArticlesCategorie() {
		stock.ajouterArticle(a3);

		when(a1.getCategorie()).thenReturn("Test 1");
		when(a2.getCategorie()).thenReturn("Test 2");
		when(a3.getCategorie()).thenReturn("Test 1");

		ObservableList<Article> articles = stock.rechercherArticlesCategorie("Test 1");

		assertThat(articles).hasSize(2);
		assertThat(articles.get(0)).isEqualTo(a1);
		assertThat(articles.get(1)).isEqualTo(a3);
	}
	
	@Test
	@DisplayName("Test de la méthode articlesDansStock qui retourne la liste des articles dans le stock.")
	void testArticlesDansStock() {
		stock.ajouterArticle(a3);
		
		ObservableList<Article> tableauAttendu = FXCollections.observableArrayList();
		tableauAttendu.addAll(a1, a2, a3);
		
		ObservableList<Article> tableauObtenu = stock.articlesDansStock();

		assertThat(tableauObtenu).isEqualTo(tableauAttendu);
	}

}
