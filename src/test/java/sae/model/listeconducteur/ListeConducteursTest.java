package sae.model.listeconducteur;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListeConducteursTest {
	
	@Mock
	Livreurs l1;
	
	@Mock
	Livreurs l2;
	
	ListeConducteurs liste;
	
	@BeforeEach
	void init() {
		liste = new ListeConducteurs();
	}
	
	@AfterEach
	public void nettoyage() {
		liste = null;
	}

	@Test
	@DisplayName("Test la méthode ajouterConducteur permettant d'ajouter un conducteur à la liste.")
	void testAjouteConducteur() {
		boolean ajout;
		
		ajout = liste.ajouterConducteur(l1);
		assertThat(ajout).isTrue();
		
		// Ajout d'un véhicule déjà ajouté
		ajout = liste.ajouterConducteur(l1);
		assertThat(ajout).isFalse();
	}
	
	@Test
	@DisplayName("Test la méthode supprimerConducteur permettant de retirer un conducteur à la liste.")
	void testSupprimerConducteur() {
		boolean supression;
		liste.ajouterConducteur(l1);
		liste.ajouterConducteur(l2);
		
		supression = liste.supprimerConducteur(l1);
		
		assertThat(supression).isTrue();
		
		// Retirer un véhicule non ajouté
		supression = liste.supprimerConducteur(l1);
		assertThat(supression).isFalse();
	}

}
