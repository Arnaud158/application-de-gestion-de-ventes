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

@ExtendWith(MockitoExtension.class)
class EnsembleCommandesTest {
	
	@Mock
	Commande c1;
	@Mock
	Commande c2;
	
	EnsembleCommandes ensemble;
	
	@BeforeEach
	public void init() {
		ensemble = new EnsembleCommandes();
	}

	@AfterEach
	public void nettoyage() {
		ensemble = null;
	}

	@Test
	@DisplayName("Test la méthode supprimerCommande qui supprime une commande de l'ensemble.")
	void testSupprimerCommande() {
		when(c1.getReference()).thenReturn(1);
		when(c1.estCloturee()).thenReturn(false);
		ensemble.ajouterCommande(c1);
		
		when(c2.getReference()).thenReturn(2);
		when(c2.estCloturee()).thenReturn(true);
		ensemble.ajouterCommande(c2);
		
		boolean suppression;
		
		// Suppression d'une commande inexistante
		suppression = ensemble.supprimerCommande(50);
		
		assertThat(suppression).isFalse();
		
		// Suppression d'une commande existante non cloture
		suppression = ensemble.supprimerCommande(1);
		
		assertThat(suppression).isFalse();
		
		// Suppression d'une commande existante cloturée
		suppression = ensemble.supprimerCommande(2);
		
		assertThat(suppression).isTrue();
	}
	
	@Test
	@DisplayName("Test la méthode getCommandes qui renvoie un tableau avec les commandes de l'ensemble.")
	void testGetCommandes() {
		ensemble.ajouterCommande(c1);
		ensemble.ajouterCommande(c2);
		
		Commande[] tableauAttendu = {c1, c2};
		Commande[] tableauObtenu = ensemble.getCommandes();
		
		assertThat(tableauObtenu).isEqualTo(tableauAttendu);
	}

}
