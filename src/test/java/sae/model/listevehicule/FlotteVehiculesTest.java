package sae.model.listevehicule;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FlotteVehiculesTest {
	
	FlotteVehicules flotte;
	
	@Mock
	Voiture v1;
	
	@Mock
	Voiture v2;
	
	@BeforeEach
	void init() {
		flotte = new FlotteVehicules();
	}
	
	@AfterEach
	public void nettoyage() {
		flotte = null;
	}

	@Test
	@DisplayName("Test la méthode ajouteVehicule permettant d'ajouter un véhicule à la liste.")
	void testAjouteVehicule() {
		boolean ajout;
		
		ajout = flotte.ajouteVehicule(v1);
		assertThat(ajout).isTrue();
		
		// Ajout d'un véhicule déjà ajouté
		ajout = flotte.ajouteVehicule(v1);
		assertThat(ajout).isFalse();
	}
	
	@Test
	@DisplayName("Test la méthode supprimerVehicule permettant de retirer un véhicule à la liste.")
	void testSupprimerVehicule() {
		boolean supression;
		flotte.ajouteVehicule(v1);
		flotte.ajouteVehicule(v2);
		
		supression = flotte.supprimerVehicule(v1);
		
		assertThat(supression).isTrue();
		
		// Retirer un véhicule non ajouté
		supression = flotte.supprimerVehicule(v1);
		assertThat(supression).isFalse();
	}

}
