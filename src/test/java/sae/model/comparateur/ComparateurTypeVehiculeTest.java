package sae.model.comparateur;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sae.model.listevehicule.Fourgon;
import sae.model.listevehicule.Voiture;

@ExtendWith(MockitoExtension.class)
class ComparateurTypeVehiculeTest {

	@Mock
	Fourgon f1;
	
	@Mock
	Fourgon f2;
	
	@Mock
	Voiture v1;
	
	@Mock
	Voiture v2;
	
	ComparateurTypeVehicule comp;
	
	@BeforeEach
	void init() {
		comp = new ComparateurTypeVehicule();
	}
	
	@AfterEach
	public void nettoyage() {
		comp = null;
	}

	@Test
	@DisplayName("Compare que Fourgon = Fourgon.")
	void testFourgonFourgon() {
		int comparaison = comp.compare(f1, f2);
		
		assertThat(comparaison).isZero();
	}
	
	@Test
	@DisplayName("Compare que Voiture = Voiture.")
	void testVoitureVoiture() {
		int comparaison = comp.compare(v1, v2);
		
		assertThat(comparaison).isZero();
	}
	
	@Test
	@DisplayName("Compare que Fourgon < Voiture.")
	void testFourgonVoiture() {
		int comparaison = comp.compare(f1, v1);
		
		assertThat(comparaison).isNegative();
	}
	
	@Test
	@DisplayName("Compare que Fourgon > Voiture.")
	void testVoitureFourgon() {
		int comparaison = comp.compare(v1, f1);
		
		assertThat(comparaison).isPositive();
	}
}
