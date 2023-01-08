package sae.model.listeconducteur;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sae.model.exception.HeuresConduitesNegativeException;
import sae.model.listevehicule.TypePermis;

class LivreursTest {

	@Test
	@DisplayName("Test du constructeur.")
	void testConstructeur() {
		Livreurs l;
		try {
			l = new Livreurs(5, "nom conducteur", "prénom conducteur", "n1", TypePermis.A1);
			assertThat(l).isInstanceOf(Livreurs.class);
			assertThat(l.getNbHeuresConduiteEffectuees()).isEqualTo(5);
			assertThat(l.getNomConducteur()).isEqualTo("nom conducteur");
			assertThat(l.getPrenomConducteur()).isEqualTo("prénom conducteur");
			assertThat(l.getNumPermisConduire()).isEqualTo("n1");
			assertThat(l.getTypePermisConduire()).isEqualTo(TypePermis.A1);
		} catch (HeuresConduitesNegativeException e) {
			e.getMessage();
		}
	}
	
	@Test
	@DisplayName("Test du constructeur qui renvoie une exception si le nombre d'heure de conduite est négatif.")
	void testConstructeurException() {
		assertThatThrownBy(() -> new Livreurs(-5, "nom conducteur", "prénom conducteur", "n1", TypePermis.A1)).isInstanceOf(HeuresConduitesNegativeException.class);
	}

}
