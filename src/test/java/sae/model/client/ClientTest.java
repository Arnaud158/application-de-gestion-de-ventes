package sae.model.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@ExtendWith(MockitoExtension.class)
class ClientTest {
	
	@Mock
	ClientEntreprise ce1;
	
	@Mock
	ClientEntreprise ce2;
	
	@Mock
	ClientParticulier cp1;
	
	@Mock
	ClientParticulier cp2;
	
	@Test
	@DisplayName("Test de la méthode static trierTabClients.")
	void testTrierTabClients() {
		when(ce1.getNom()).thenReturn("AAA");
		when(ce2.getNom()).thenReturn("ZZZ");
		when(cp1.getNom()).thenReturn("ABA");
		when(cp2.getNom()).thenReturn("BBB");
		
		
		ObservableList<Client> clients = FXCollections.observableArrayList();
		clients.addAll(ce1, ce2, cp1, cp2);

		Client.trierTabClients(clients);
		assertThat(clients.get(0)).isEqualTo(ce1);
		assertThat(clients.get(1)).isEqualTo(cp1);
		assertThat(clients.get(2)).isEqualTo(cp2);
		assertThat(clients.get(3)).isEqualTo(ce2);
	}

}
