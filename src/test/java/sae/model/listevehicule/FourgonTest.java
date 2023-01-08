package sae.model.listevehicule;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sae.model.listeconducteur.Livreurs;

@ExtendWith(MockitoExtension.class)
class FourgonTest {
	
	@Mock
	Livreurs l;

	@Test
	@DisplayName("Test du constructeur.")
	void testConstructeur() {
		Fourgon f = new Fourgon(10, 10, "45", "modele test", "marque test", 10000, 2010, l);
		assertThat(f).isInstanceOf(Fourgon.class);
		assertThat(f.getVolumeMaximalKilogramme()).isEqualTo(10);
		assertThat(f.getVolumeMaximalMetreCube()).isEqualTo(10);
		assertThat(f.getNumImmatriculationVehicule()).isEqualTo("45");
		assertThat(f.getModeleVehicule()).isEqualTo("modele test");
		assertThat(f.getMarqueVehicule()).isEqualTo("marque test");
		assertThat(f.getKilometrageVehicule()).isEqualTo(10000);
		assertThat(f.getAnneeMiseCirculationVehicule()).isEqualTo(2010);
		assertThat(f.getLivreur()).isEqualTo(l);
	}

}
