package com.julianocarpes.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julianocarpes.exceptions.ResourceNotFaundExceptions;
import com.julianocarpes.models.Product;
import com.julianocarpes.repositories.ProductRepository;

@Service
public class ProductService {
	
	private Logger logger = Logger.getLogger(ProductService.class.getName());
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product>findAll(){
		logger.info("Finding a Porducts");
		return repository.findAll();
	
	}
	
	public Product findById(Long id) {
		logger.info("Finding a Product for id");
		return repository.findById(id).orElseThrow(()-> new ResourceNotFaundExceptions("No Records found for this ID"));
	}
	
	public Product created(Product product) {
		logger.info("Created a person");
		return repository.save(product);
	}
	
	public Product update(Product prod) {
		Product entity = repository.findById(prod.getId()).orElseThrow(()-> new ResourceNotFaundExceptions("No Records found for this ID"));
		entity.setName(prod.getName());
		entity.setQuantity(prod.getQuantity());
		entity.setPrice(prod.getPrice());
		entity.setAmount(prod.getAmount());
		entity.setDescription(prod.getDescription());
		return repository.save(prod);
		
	}
	public void delete(Long id) {
		logger.info("Delete a person");
		Product entity = repository.findById(id).orElseThrow(()-> new ResourceNotFaundExceptions("No Records found for this ID"));
		repository.delete(entity);
	}

}
