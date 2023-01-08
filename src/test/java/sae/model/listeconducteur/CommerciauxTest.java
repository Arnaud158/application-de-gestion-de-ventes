package sae.model.listeconducteur;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import sae.model.exception.VisitesNegatifException;
import sae.model.listevehicule.TypePermis;

@ExtendWith(MockitoExtension.class)
class CommerciauxTest {

	@Test
	@DisplayName("Test du constructeur.")
	void testConstructeur() {
		Commerciaux c;
		try {
			c = new Commerciaux(5, "nom conducteur", "prénom conducteur", "n1", TypePermis.A1);
			assertThat(c).isInstanceOf(Commerciaux.class);
			assertThat(c.getNbVisitesEffectuees()).isEqualTo(5);
			assertThat(c.getNomConducteur()).isEqualTo("nom conducteur");
			assertThat(c.getPrenomConducteur()).isEqualTo("prénom conducteur");
			assertThat(c.getNumPermisConduire()).isEqualTo("n1");
			assertThat(c.getTypePermisConduire()).isEqualTo(TypePermis.A1);
		} catch (VisitesNegatifException e) {
			e.getMessage();
		}
	}
	
	@Test
	@DisplayName("Test du constructeur qui renvoie une exception si le nombre de visites effectués est négatif.")
	void testConstructeurException() {
		assertThatThrownBy(() -> new Commerciaux(-5, "nom conducteur", "prénom conducteur", "n1", TypePermis.A1)).isInstanceOf(VisitesNegatifException.class);
	}

}
