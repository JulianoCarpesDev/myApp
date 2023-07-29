package com.julianocarpes.services;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.julianocarpes.exceptions.ResourceNotFaundExceptions;
import com.julianocarpes.models.Client;
import com.julianocarpes.models.ModelAnswer;
import com.julianocarpes.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ModelAnswer message;
	
	private Logger logger = Logger.getLogger(ClientService.class.getName());
	
	@Autowired
	private ClientRepository repository;
	
	public Iterable<Client>findAll(){
		logger.info("Finding a Client");
		return repository.findAll();
	}
	public ResponseEntity<Client> findById(Long id) {
	    Optional<Client> optionalClient = repository.findById(id);
	    if (optionalClient.isPresent()) {
	        Client client = optionalClient.get();
	        return ResponseEntity.ok(client); // Retorna o clientuto com status HTTP 200 OK
	    } else {
	        return ResponseEntity.notFound().build(); // Retorna 404 Not Found caso não encontre o clientuto
	    }
	}
	
	public ResponseEntity<?> created(Client client) {
		logger.info("Created a client");
		if(client.getName().equals("")) {
			message.setMessage("Name field cannot be empty");
			return new ResponseEntity<ModelAnswer>(message,HttpStatus.BAD_REQUEST);
		}else if(client.getEmail().equals("")) {
			message.setMessage("E-mail field cannot be empty");
			return new ResponseEntity<ModelAnswer>(message,HttpStatus.BAD_REQUEST);
		}else if(client.getPhone().equals("")) {
			message.setMessage("Phone field cannot be empty");
			return new ResponseEntity<ModelAnswer>(message,HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Client>(repository.save(client),HttpStatus.CREATED);
		}
	}
	
	public ResponseEntity<Client> update(Client client) {
	    Client entity = repository.findById(client.getId()).orElseThrow(() -> new ResourceNotFaundExceptions("No Records found for this ID"));
	    
	    // Atualizar os atributos do objeto entity com os valores do objeto client
	    entity.setName(client.getName());
	    entity.setEmail(client.getEmail());
	    entity.setPhone(client.getPhone());
	    
	    
	    // Salvar o objeto entity atualizado no repositório
	    Client updatedClient = repository.save(entity);
	    
	    // Retornar o objeto atualizado com o status HTTP 200 OK
	    return ResponseEntity.ok(updatedClient);
	}
	public ResponseEntity<ModelAnswer> delete(Long id) {
		logger.info("Delete a client");
		repository.deleteById(id);
		message.setMessage("Customer has been removed");
		return new ResponseEntity<ModelAnswer>(message,HttpStatus.OK);
	}

}
