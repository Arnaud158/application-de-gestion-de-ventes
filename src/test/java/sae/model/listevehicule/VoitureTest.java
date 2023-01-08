package sae.model.listevehicule;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sae.model.listeconducteur.Commerciaux;

@ExtendWith(MockitoExtension.class)
class VoitureTest {

	@Mock
	Commerciaux c;
	
	
	@Test
	@DisplayName("Test du constructeur.")
	void testConstructeur() {
		Voiture v = new Voiture("42", "modele test", "marque test", 12000, 2010, c);
		assertThat(v).isInstanceOf(Vehicule.class);
		assertThat(v.getNumImmatriculationVehicule()).isEqualTo("42");
		assertThat(v.getModeleVehicule()).isEqualTo("modele test");
		assertThat(v.getMarqueVehicule()).isEqualTo("marque test");
		assertThat(v.getKilometrageVehicule()).isEqualTo(12000);
		assertThat(v.getAnneeMiseCirculationVehicule()).isEqualTo(2010);
		assertThat(v.getCommercial()).isEqualTo(c);
	}

}
