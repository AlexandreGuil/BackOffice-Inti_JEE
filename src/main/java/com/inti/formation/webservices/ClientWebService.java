package com.inti.formation.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Client;
import com.inti.formation.services.IClientService;

@RestController
@RequestMapping("/client")
@CrossOrigin("*") //autorise toutes les entêtes de requêtes
public class ClientWebService {
	
	@Autowired
	public IClientService service;
	
	@RequestMapping(value="/ajout", method=RequestMethod.POST)
	public Client ajout(@RequestBody Client c) {
		return service.saveOrUpdate(c);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Client update(@RequestBody Client c) {
		return service.saveOrUpdate(c);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		service.delete(id);
	}
	
	@RequestMapping(value="/client/{id}", method=RequestMethod.GET)
	public Client getById(@PathVariable long id) {
		return service.getById(id);
	}
	
	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public List<Client> findAll() {
		return service.findAll();
	}
	
}



