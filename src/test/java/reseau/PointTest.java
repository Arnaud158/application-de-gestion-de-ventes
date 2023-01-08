package reseau;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	@DisplayName("Test du constructeur sans paramètre.")
	void testConstructeurVide() {
		Point p = new Point();
		assertThat(p).isInstanceOf(Point.class);
		assertThat(p.getId()).isZero();
		assertThat(p.getX()).isZero();
		assertThat(p.getY()).isZero();
	}
	
	@Test
	@DisplayName("Test du constructeur non vide.")
	void testConstructeur() {
		Point p = new Point(4, -8, 3);
		assertThat(p).isInstanceOf(Point.class);
		assertThat(p.getId()).isEqualTo(4);
		assertThat(p.getX()).isEqualTo(-8);
		assertThat(p.getY()).isEqualTo(3);
	}
	
	@Test
	@DisplayName("Test de la méthode setX qui permet de changer l'emplacement du point.")
	void testSetX() {
		Point p = new Point();
		assertThat(p.getId()).isZero();
		assertThat(p.getX()).isZero();
		assertThat(p.getY()).isZero();
		
		p.setX(5);
		assertThat(p.getX()).isEqualTo(5);
	}
	
	@Test
	@DisplayName("Test de la méthode setY qui permet de changer l'emplacement du point.")
	void testSetY() {
		Point p = new Point();
		assertThat(p.getId()).isZero();
		assertThat(p.getX()).isZero();
		assertThat(p.getY()).isZero();
		
		p.setY(5);
		assertThat(p.getY()).isEqualTo(5);
	}
	
	@Test
	@DisplayName("Test de la méthode equals.")
	void testEquals() {
		Point p1 = new Point(4, -8, 3);
		Point p2 = new Point(4, -13, -8);
		Point p3 = new Point(2, -13, -8);
		// 2 points sont identiques si ils ont le même identifiant
		assertThat(p1.equals(p2)).isTrue();
		
		assertThat(p1.equals(p3)).isFalse();
	}

}
