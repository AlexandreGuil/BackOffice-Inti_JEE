package com.inti.formation.services.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.inti.formation.entities.Client;
import com.inti.formation.services.IClientService;

public class ClientServiceTest {

	IClientService service;
	
	@Before
	public void init() {
		service = new ClientService();
	}
	
	//On compare l'id du Client qu'on a récupéré grâce à la méthode getById avec l'id qu'on lui a donné
	@Test
	public void testGetById() {
		Client c = service.getById(2l);
		Long id = c.getIdClient();
		Long nb = 2l;
		assertNotNull(c);
		assertEquals(nb, id);
	}
	
	//On compare la taille de la liste une fois un nouveau client ajouté
	@Test
	public void testSave() {
		List<Client> clients = service.findAll();
		int size = clients.size();
		Client c = new Client();
		c.setIdClient(null);
		c.setAdresse("test");
		c.setCommandes(null);
		c.setEmail("test");
		c.setMotDePasse("mdp");
		c.setNomClient("nouveau");
		c.setPrenomClient("client");
		c.setTel("0202020202");
		service.saveOrUpdate(c);
		clients = service.findAll();
		assertEquals(size+1, clients.size());
	}
	
	//On compare le nom du client modifié avec le nouveau nom qu'on lui a donné
	@Test
	public void testUpdate() {
		Client c = service.getById(2l);
		c.setNomClient("nomUpdate");
		service.saveOrUpdate(c);
		Client c1 = service.getById(2l);
		assertEquals(c.getNomClient(), c1.getNomClient());
	}
	
	//On compare la taille de la liste récupérée avec la méthode findAll avec la taille réelle de la base de données
	@Test
	public void testFindAll() {
		List<Client> clients = service.findAll();
		int size = clients.size();
		int taille = 5; //taille de la base de données
		assertNotNull(clients);
		assertEquals(taille, size);
	}
	
	//On vérifie que l'id d'un client supprimé n'existe plus
	@Test
	public void testDelete() {
		Client c = service.getById(3l);
		assertNotNull(c);
		service.delete(c.getIdClient());
		Client c1 = service.getById(3l);
		assertNull(c1);
	}


}
