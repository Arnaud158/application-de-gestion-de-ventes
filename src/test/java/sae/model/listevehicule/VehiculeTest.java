package sae.model.listevehicule;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class VehiculeTest {
	
	@Test
	@DisplayName("Test du constructeur.")
	void testConstructeur() {
		Vehicule v = new Vehicule("42", "modele test", "marque test", 12000, 2010);
		assertThat(v).isInstanceOf(Vehicule.class);
		assertThat(v.getNumImmatriculationVehicule()).isEqualTo("42");
		assertThat(v.getModeleVehicule()).isEqualTo("modele test");
		assertThat(v.getMarqueVehicule()).isEqualTo("marque test");
		assertThat(v.getKilometrageVehicule()).isEqualTo(12000);
		assertThat(v.getAnneeMiseCirculationVehicule()).isEqualTo(2010);
	}

}
