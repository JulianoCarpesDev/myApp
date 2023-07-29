package com.julianocarpes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julianocarpes.models.Client;
import com.julianocarpes.services.ClientService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping
	private Iterable<Client>findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<Client> findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	@PostMapping("/save")
	private ResponseEntity<?> created(@RequestBody Client client) {
		return service.created(client);
	}

	@PutMapping(value = "/update")
	private ResponseEntity<?> update(@RequestBody Client client) {
		return service.update(client);
	}
	@DeleteMapping(value = "/remove/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id")Long id ) {
		return service.delete(id);
		
	}

}
