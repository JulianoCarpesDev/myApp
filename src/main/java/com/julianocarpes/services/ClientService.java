package com.julianocarpes.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julianocarpes.exceptions.ResourceNotFaundExceptions;
import com.julianocarpes.models.Client;
import com.julianocarpes.repositories.ClientRepository;

@Service
public class ClientService {
	
	private Logger logger = Logger.getLogger(ClientService.class.getName());
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client>findAll(){
		logger.info("Finding a Porducts");
		return repository.findAll();
	
	}
	
	public Client findById(Long id) {
		logger.info("Finding a Client for id");
		return repository.findById(id).orElseThrow(()-> new ResourceNotFaundExceptions("No Records found for this ID"));
	}
	
	public Client created(Client client) {
		logger.info("Created a person");
		return repository.save(client);
	}
	
	public Client update(Client client) {
		Client entity = repository.findById(client.getId()).orElseThrow(()-> new ResourceNotFaundExceptions("No Records found for this ID"));
		entity.setName(client.getName());
		entity.setEmail(client.getEmail());
		entity.setPhone(client.getPhone());
		return repository.save(client);
		
	}
	public void delete(Long id) {
		logger.info("Delete a person");
		Client entity = repository.findById(id).orElseThrow(()-> new ResourceNotFaundExceptions("No Records found for this ID"));
		repository.delete(entity);
	}

}
