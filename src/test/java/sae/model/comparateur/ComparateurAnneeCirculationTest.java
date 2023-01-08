package sae.model.comparateur;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sae.model.listevehicule.Vehicule;

@ExtendWith(MockitoExtension.class)
class ComparateurAnneeCirculationTest {

	@Mock
	Vehicule v1;
	
	@Mock
	Vehicule v2;
	
	ComparateurAnneeCirculation comp;
	
	@BeforeEach
	void init() {
		comp = new ComparateurAnneeCirculation();
	}
	
	@AfterEach
	public void nettoyage() {
		comp = null;
	}

	@Test
	@DisplayName("Compare que c1 < c2.")
	void testC1PlusPetit() {
		when(v1.getAnneeMiseCirculationVehicule()).thenReturn(2000);
		when(v2.getAnneeMiseCirculationVehicule()).thenReturn(2010);
		
		int comparaison = comp.compare(v1, v2);
		
		assertThat(comparaison).isNegative();
	}
	
	@Test
	@DisplayName("Compare que c1 > c2.")
	void testC1PlusGrand() {
		when(v1.getAnneeMiseCirculationVehicule()).thenReturn(2010);
		when(v2.getAnneeMiseCirculationVehicule()).thenReturn(2000);
		
		int comparaison = comp.compare(v1, v2);
		
		assertThat(comparaison).isPositive();
	}
	
	@Test
	@DisplayName("Compare que c1 = c2.")
	void testC1Egalite() {
		when(v1.getAnneeMiseCirculationVehicule()).thenReturn(2000);
		when(v2.getAnneeMiseCirculationVehicule()).thenReturn(2000);
		
		int comparaison = comp.compare(v1, v2);
		
		assertThat(comparaison).isZero();
	}

}
