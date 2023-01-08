package sae.model.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@ExtendWith(MockitoExtension.class)
class CarnetClientsTest {
	
	@Mock
	ClientEntreprise ce1;
	@Mock
	ClientEntreprise ce2;
	@Mock
	ClientParticulier cp1;
	@Mock
	ClientParticulier cp2;
	@Mock
	ClientParticulier cp3;
	@Mock
	ClientParticulier cp4;
	@Mock
	ClientParticulier cp5;
	@Mock
	ClientParticulier cp6;
	@Mock
	ClientParticulier cp7;
	@Mock
	ClientParticulier cp8;
	@Mock
	ClientParticulier cp9;
	@Mock
	ClientParticulier cp10;
	
	
	CarnetClients carnet;
	
	@BeforeEach
	public void init() {
		carnet = new CarnetClients("Carnet test");
		carnet.ajouterClient(ce1);
		carnet.ajouterClient(ce2);
		carnet.ajouterClient(cp1);
		carnet.ajouterClient(cp2);
		carnet.ajouterClient(cp3);
		carnet.ajouterClient(cp4);
		carnet.ajouterClient(cp5);
		carnet.ajouterClient(cp6);
	}

	@AfterEach
	public void nettoyage() {
	  carnet = null;
	}
	
	@Test
	@DisplayName("Test de la méthode ajouterClient permettant d'ajouter un client au carnet jusqu'à une limite fixé à 10.")
	void testAjouterClient() {
		
		// Taille actuelle de carnet = 8
		
		carnet.ajouterClient(cp7);
		carnet.ajouterClient(cp8);
		carnet.ajouterClient(cp9);
		carnet.ajouterClient(cp10);
		
		assertThat(carnet.clientsDansCarnet()).hasSize(10);
	}
	
	@Test
	@DisplayName("Test de la méthode supprimerClient permettant d'ajouter un client au carnet jusqu'à une limite fixé à 10.")
	void testSupprimerClient() {
		
		// Taille actuelle de carnet = 8
		
		// Retrait d'un élément non présent
		
		assertThat(carnet.clientsDansCarnet()).hasSize(8);
		
		carnet.supprimerClient(cp10);
		
		assertThat(carnet.clientsDansCarnet()).hasSize(8);
		
		// Retrait d'un élément présent
		
		carnet.supprimerClient(ce1);
		
		assertThat(carnet.clientsDansCarnet()).hasSize(7);
	}
	
	@Test
	@DisplayName("Test de la méthode rechercherClientParReference permettant de rechercher un client grâce à sa référence.")
	void testRechercherClientParReference() {
		
		// Taille actuelle de carnet = 8
		
		when(ce1.getReference()).thenReturn(0);
		when(ce2.getReference()).thenReturn(1);
		
		Client clientObtenu = carnet.rechercherClientParReference(1);
		
		assertThat(clientObtenu).isEqualTo(ce2);
		
		// Client non existant

		clientObtenu = carnet.rechercherClientParReference(50);
		
		assertThat(clientObtenu).isNull();
		
		
	}
	
	@Test
	@DisplayName("Test de la méthode clientsParticulierDansCarnet qui retourne la liste des clients particuliers.")
	void testClientsParticulierDansCarnet() {
		
		// Taille actuelle de carnet = 8
		// 6 clients particuliers
		// 2 clients entreprise
		
		ObservableList<Client> listeAttendu = FXCollections.observableArrayList();
		listeAttendu.addAll(cp1, cp2, cp3, cp4, cp5, cp6);
		
		ObservableList<Client> listeObtenu = carnet.clientsParticulierDansCarnet();
		
		assertThat(listeAttendu).isEqualTo(listeObtenu);
	}
	
	@Test
	@DisplayName("Test de la méthode clientsEntrepriseDansCarnet qui retourne la liste des clients entreprises.")
	void testClientsEntrepriseDansCarnet() {
		
		// Taille actuelle de carnet = 8
		
		
		ObservableList<Client> listeAttendu = FXCollections.observableArrayList();
		listeAttendu.addAll(ce1, ce2);
		
		ObservableList<Client> listeObtenu = carnet.clientsEntrepriseDansCarnet();
		
		assertThat(listeAttendu).isEqualTo(listeObtenu);
	}
	
	@Test
	@DisplayName("Test de la méthode rechercherClientsParMotCle qui retourne la liste des clients entreprises.")
	void testRechercherClientsParMotCle() {
		
		// Taille actuelle de carnet = 8
		
		when(ce1.getNom()).thenReturn("ce1");
		when(ce1.getAdresse()).thenReturn("ce1");
		
		when(ce2.getNom()).thenReturn("ce2");
		when(ce2.getAdresse()).thenReturn("ce2");
		
		when(cp1.getNom()).thenReturn("TEST");
		when(cp1.getAdresse()).thenReturn("cp1");
		
		when(cp2.getNom()).thenReturn("cp2");
		when(cp2.getAdresse()).thenReturn("cp2");
		
		when(cp3.getNom()).thenReturn("cp3");
		when(cp3.getAdresse()).thenReturn("cp3");
		
//		when(cp4.getNom()).thenReturn("cp4");
		when(cp4.getAdresse()).thenReturn("TEST");
		
		when(cp5.getNom()).thenReturn("cp5");
		when(cp5.getAdresse()).thenReturn("cp5");
		
		when(cp6.getNom()).thenReturn("TEST");
		when(cp6.getAdresse()).thenReturn("cp6");
		
		ObservableList<Client> listeAttendu = FXCollections.observableArrayList();
		listeAttendu.addAll(cp1, cp4, cp6);
		
		ObservableList<Client> listeObtenu = carnet.rechercherClientsParMotCle("TEST");
		
		assertThat(listeAttendu).isEqualTo(listeObtenu);
	}

}
