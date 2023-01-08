package reseau;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AreteTest {

	@Test
	@DisplayName("Test du constructeur.")
	void testConstructeur() {
		Arete a = new Arete(4, 5, 8.0);
		assertThat(a).isInstanceOf(Arete.class);
		assertThat(a.getIdP1()).isEqualTo(4);
		assertThat(a.getIdP2()).isEqualTo(5);
		assertThat(a.getPoids()).isEqualTo(8.0);
	}
	
	@Test
	@DisplayName("Test de la méthode setIdP1 qui permet de changer l'id du premier point.")
	void testSetIdP1() {
		Arete a = new Arete(4, 5, 8.0);
		assertThat(a.getIdP1()).isEqualTo(4);
		a.setIdP1(10);
		assertThat(a.getIdP1()).isEqualTo(10);
	}
	
	@Test
	@DisplayName("Test de la méthode setIdP2 qui permet de changer l'id du deuxième point.")
	void testSetIdP2() {
		Arete a = new Arete(4, 5, 8.0);
		assertThat(a.getIdP2()).isEqualTo(5);
		a.setIdP2(10);
		assertThat(a.getIdP2()).isEqualTo(10);
	}
}
