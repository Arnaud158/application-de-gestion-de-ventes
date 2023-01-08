package sae.model.commande;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sae.model.article.Article;
import sae.model.article.ArticleCat2;

@ExtendWith(MockitoExtension.class)
class LigneCommandeTest {
	
	@Mock
	Article article;
	
	@Mock
	ArticleCat2 articleLivrable;
	
	LigneCommande ligne;
	
	LigneCommande ligneLivrable;

	@BeforeEach
	public void init() {
		when(article.getQuantiteStock()).thenReturn(10);
		ligne = new LigneCommande(article, 5);
		
		when(articleLivrable.getQuantiteStock()).thenReturn(10);
		ligneLivrable = new LigneCommande(articleLivrable, 5);
	}
	
	@AfterEach
	public void nettoyage() {
		ligne = null;
	}
	
	@Test
	@DisplayName("Test de la méthode ajouterQuantite permettant d'augmenter la quantité d'articles achetés si le stock le permet")
	void testAjouterQuantite() {
		// L'article a 10 éléments en stock
		// La ligne de commande demande déjà 5 articles
		when(article.getQuantiteStock()).thenReturn(5);
		assertThat(ligne.getQuantite()).isEqualTo(5);
		
		ligne.ajouterQuantite(3);
		
		when(article.getQuantiteStock()).thenReturn(2);
		
		assertThat(ligne.getQuantite()).isEqualTo(8);
		
		ligne.ajouterQuantite(50);
		
		assertThat(ligne.getQuantite()).isEqualTo(10);
	}
	
	@Test
	@DisplayName("Test de la méthode getMontantAvecLivraison permettant d'augmenter la quantité d'articles achetés si le stock le permet")
	void testGetMontantAvecLivraison() {
		// Article non livrable
		when(article.getPrix()).thenReturn(10.0);
		// 5 articles sont achetés
		assertThat(ligne.getMontantAvecLivraison()).isEqualTo(50.0);
		
		// 5 articles sont achetés
		when(articleLivrable.getPrix()).thenReturn(10.0);
		when(articleLivrable.coutLivraison()).thenReturn(4.99);
		
		double coutAttendu = 74.95;
		
		assertThat(ligneLivrable.getMontantAvecLivraison()).isEqualTo(coutAttendu);
		
	}
}
