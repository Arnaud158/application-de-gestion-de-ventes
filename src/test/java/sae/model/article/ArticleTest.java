package sae.model.article;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ArticleTest {
	
	Article article;
	
	@BeforeEach
	public void init() {
		article = new Article("catégorie test", "désignation test", 12, 14);
	}

	@AfterEach
	public void nettoyage() {
	  article = null;
	}
	
	@Test
	@DisplayName("Test du constructeur permettant de créer un nouvel article.")
	void testConstructeur() {
		Article a = new Article("catégorie test", "désignation test", 12, 14);
		assertThat(a).isInstanceOf(Article.class);
		assertThat(a.getCategorie()).isEqualTo("catégorie test");
		assertThat(a.getDesignation()).isEqualTo("désignation test");
		assertThat(a.getPrix()).isEqualTo(12);
		assertThat(a.getQuantiteStock()).isEqualTo(14);
	}
	
	@Test
	@DisplayName("Test de la méthode setPrix avec une valeur négatif")
	void testSetPrixNegatif() {
		article.setPrix(-4);
		assertThat(article.getPrix()).isZero();
	}
	
	@Test
	@DisplayName("Test de la méthode setPrix avec une valeur possible")
	void testSetPrix() {
		article.setPrix(4);
		assertThat(article.getPrix()).isEqualTo(4);
	}
	
	@Test
	@DisplayName("Test de la méthode setQuantiteStock avec une valeur négatif")
	void testSetQuantiteStockNegatif() {
		article.setQuantiteStock(-4);
		assertThat(article.getQuantiteStock()).isZero();
	}
	
	@Test
	@DisplayName("Test de la méthode setQuantiteStock avec une valeur possible")
	void testSetQuantiteStock() {
		article.setQuantiteStock(4);
		assertThat(article.getQuantiteStock()).isEqualTo(4);
	}
	
	@Test
	@DisplayName("Test de la méthode ajouterQuantiteStock avec une valeur négatif")
	void testAjouterQuantiteStockNegatif() {
		article.ajouterQuantiteStock(-4);
		assertThat(article.getQuantiteStock()).isEqualTo(14);
	}
	
	@Test
	@DisplayName("Test de la méthode ajouterQuantiteStock avec une valeur possible")
	void testAjouterQuantiteStock() {
		article.ajouterQuantiteStock(4);
		assertThat(article.getQuantiteStock()).isEqualTo(18);
	}
	
	@Test
	@DisplayName("Test de la méthode enleverQuantiteStock avec une valeur négatif")
	void testEnleverQuantiteStockNegatif() {
		article.enleverQuantiteStock(-4);
		assertThat(article.getQuantiteStock()).isEqualTo(14);
	}
	
	@Test
	@DisplayName("Test de la méthode enleverQuantiteStock avec une valeur supérieur au stock")
	void testEnleverQuantiteStockSuperieur() {
		article.enleverQuantiteStock(20);
		assertThat(article.getQuantiteStock()).isZero();
	}
	
	@Test
	@DisplayName("Test de la méthode enleverQuantiteStock avec une valeur possible")
	void testEnleverQuantiteStock() {
		article.enleverQuantiteStock(4);
		assertThat(article.getQuantiteStock()).isEqualTo(10);
	}

}
