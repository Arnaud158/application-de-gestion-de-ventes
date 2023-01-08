package sae.model.comparateur;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sae.model.listeconducteur.Commerciaux;
import sae.model.listeconducteur.Livreurs;

@ExtendWith(MockitoExtension.class)
class ComparateurTypeConducteurTest {
	
	@Mock
	Livreurs l1;
	
	@Mock
	Livreurs l2;
	
	@Mock
	Commerciaux c1;
	
	@Mock
	Commerciaux c2;
	
	ComparateurTypeConducteur comp;
	
	@BeforeEach
	void init() {
		comp = new ComparateurTypeConducteur();
	}
	
	@AfterEach
	public void nettoyage() {
		comp = null;
	}

	@Test
	@DisplayName("Compare que livreurs = livreurs.")
	void testLivreursLivreurs() {
		int comparaison = comp.compare(l1, l2);
		
		assertThat(comparaison).isZero();
	}
	
	@Test
	@DisplayName("Compare que commerciaux = commerciaux.")
	void testCommerciauxCommerciaux() {
		int comparaison = comp.compare(c1, c2);
		
		assertThat(comparaison).isZero();
	}
	
	@Test
	@DisplayName("Compare que livreurs < commerciaux.")
	void testLivreurCommerciaux() {
		int comparaison = comp.compare(l1, c1);
		
		assertThat(comparaison).isNegative();
	}
	
	@Test
	@DisplayName("Compare que livreurs > commerciaux.")
	void testCommerciauxLivreur() {
		int comparaison = comp.compare(c1, l1);
		
		assertThat(comparaison).isPositive();
	}

}
