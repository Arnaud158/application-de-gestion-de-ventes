package sae.model.comparateur;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sae.model.listeconducteur.Conducteur;

@ExtendWith(MockitoExtension.class)
class ComparateurAlphabetiqueTest {
	
	@Mock
	Conducteur c1;
	
	@Mock
	Conducteur c2;
	
	ComparateurAlphabetique comp;
	
	@BeforeEach
	void init() {
		comp = new ComparateurAlphabetique();
	}
	
	@AfterEach
	public void nettoyage() {
		comp = null;
	}

	@Test
	@DisplayName("Compare que c1 < c2.")
	void testC1PlusPetit() {
		when(c1.getNomConducteur()).thenReturn("AAA");
		when(c2.getNomConducteur()).thenReturn("AZ");
		
		int comparaison = comp.compare(c1, c2);
		
		assertThat(comparaison).isNegative();
	}
	
	@Test
	@DisplayName("Compare que c1 > c2.")
	void testC1PlusGrand() {
		when(c1.getNomConducteur()).thenReturn("ZA");
		when(c2.getNomConducteur()).thenReturn("AZ");
		
		int comparaison = comp.compare(c1, c2);
		
		assertThat(comparaison).isPositive();
	}
	
	@Test
	@DisplayName("Compare que c1 = c2.")
	void testC1Egalite() {
		when(c1.getNomConducteur()).thenReturn("AA");
		when(c2.getNomConducteur()).thenReturn("AA");
		
		int comparaison = comp.compare(c1, c2);
		
		assertThat(comparaison).isZero();
	}

}
