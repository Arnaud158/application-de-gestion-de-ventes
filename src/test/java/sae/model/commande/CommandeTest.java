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
import sae.model.client.Client;

@ExtendWith(MockitoExtension.class)
class CommandeTest {
	@Mock
	Article a1;
	@Mock
	Article a2;
	@Mock
	Article a3;
	@Mock
	Article a4;
	@Mock
	Article a5;
	@Mock
	Article a6;
	@Mock
	Article a7;
	@Mock
	Article a8;
	@Mock
	Article a9;
	@Mock
	Article a10;
	@Mock
	Article a11;

	@Mock
	Client client;

	Commande commande;

	@BeforeEach
	public void init() {
		commande = new Commande(client);
	}

	@AfterEach
	public void nettoyage() {
		commande = null;
	}

	@Test
	@DisplayName("Test de la méthode supprimerLigneCommande permettant de supprimer une ligne de commande grâce à la référence de l'article contenu dans cette ligne.")
	void testSupprimerLigneCommande() {
		when(a1.getReference()).thenReturn(1);
		when(a2.getReference()).thenReturn(2);
		
		when(a1.getQuantiteStock()).thenReturn(10);
		when(a2.getQuantiteStock()).thenReturn(10);

		commande.commander(a1, 5);
		commande.commander(a2, 5);

		assertThat(commande.getNbLignesCommande()).isEqualTo(2);

		// Suppression d'une ligne qui n'existe pas
		commande.supprimerLigneCommande(10);

		assertThat(commande.getNbLignesCommande()).isEqualTo(2);

		commande.supprimerLigneCommande(2);

		assertThat(commande.getNbLignesCommande()).isEqualTo(1);

		// On ne peux pas enlever un article d'une commande cloturée
		commande.cloturer(true);

		commande.supprimerLigneCommande(2);

		assertThat(commande.getNbLignesCommande()).isEqualTo(1);
	}

	@Test
	@DisplayName("Test de la méthode commander pour tester si commander un article déjà commandé augmente la quantité sur la ligne existante")
	void testCommanderArticleDejaPresent() {
		when(a1.getReference()).thenReturn(1);
		when(a1.getQuantiteStock()).thenReturn(10);
		commande.commander(a1, 5);
		
		assertThat(commande.getQuantite(0)).isEqualTo(5);
		assertThat(commande.getNbLignesCommande()).isEqualTo(1);
		
		commande.commander(a1, 2);
		
		assertThat(commande.getQuantite(0)).isEqualTo(7);
		assertThat(commande.getNbLignesCommande()).isEqualTo(1);
	}
	
	@Test
	@DisplayName("Test de la méthode commander quand la commande est pleine")
	void testCommanderCommandePleine() {
		when(a1.getReference()).thenReturn(1);
		when(a2.getReference()).thenReturn(2);
		when(a3.getReference()).thenReturn(3);
		when(a4.getReference()).thenReturn(4);
		when(a5.getReference()).thenReturn(5);
		when(a6.getReference()).thenReturn(6);
		when(a7.getReference()).thenReturn(7);
		when(a8.getReference()).thenReturn(8);
		when(a9.getReference()).thenReturn(9);
		when(a10.getReference()).thenReturn(10);
		
		when(a1.getQuantiteStock()).thenReturn(10);
		when(a2.getQuantiteStock()).thenReturn(10);
		when(a3.getQuantiteStock()).thenReturn(10);
		when(a4.getQuantiteStock()).thenReturn(10);
		when(a5.getQuantiteStock()).thenReturn(10);
		when(a6.getQuantiteStock()).thenReturn(10);
		when(a7.getQuantiteStock()).thenReturn(10);
		when(a8.getQuantiteStock()).thenReturn(10);
		when(a9.getQuantiteStock()).thenReturn(10);
		when(a10.getQuantiteStock()).thenReturn(10);
		
		commande.commander(a1, 5);
		commande.commander(a2, 5);
		commande.commander(a3, 5);
		commande.commander(a4, 5);
		commande.commander(a5, 5);
		commande.commander(a6, 5);
		commande.commander(a7, 5);
		commande.commander(a8, 5);
		commande.commander(a9, 5);
		commande.commander(a10, 5);
		
		assertThat(commande.getNbLignesCommande()).isEqualTo(10);
		assertThat(commande.estPleine()).isTrue();
		
		commande.commander(a11, 5);
		
		assertThat(commande.getNbLignesCommande()).isEqualTo(10);
	}
	@Test
	@DisplayName("Test de la méthode getMontant permettant de récupérer le montant total de la commande")
	void testGetMontant() {
		when(a1.getReference()).thenReturn(1);
		when(a1.getQuantiteStock()).thenReturn(10);
		when(a1.getPrix()).thenReturn(2.50);
		when(a2.getReference()).thenReturn(2);
		when(a2.getQuantiteStock()).thenReturn(10);
		when(a2.getPrix()).thenReturn(5.0);
		commande.commander(a1, 5);
		commande.commander(a2, 3);
		
		Double totalAttendu = 2.5*5 + 5*3;
		
		assertThat(commande.getMontant()).isEqualTo(totalAttendu);
	}
	
	@Test
	@DisplayName("Test de la méthode getArticle permettant de renvoyer un article en fonction du numéro de la ligne de commande.")
	void testGetArticle() {
		when(a1.getReference()).thenReturn(1);
		when(a1.getQuantiteStock()).thenReturn(10);
		when(a2.getReference()).thenReturn(2);
		when(a2.getQuantiteStock()).thenReturn(10);
		commande.commander(a1, 10);
		commande.commander(a2, 5);
		
		Article articleObtenu = commande.getArticle(0);
		
		assertThat(articleObtenu).isEqualTo(a1);
		
		// Article non existant
		articleObtenu = commande.getArticle(50);
		
		assertThat(articleObtenu).isNull();
		
		articleObtenu = commande.getArticle(-2);
		
		assertThat(articleObtenu).isNull();
	}

}
