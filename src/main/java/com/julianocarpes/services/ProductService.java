package com.julianocarpes.services;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.julianocarpes.exceptions.ResourceNotFaundExceptions;
import com.julianocarpes.models.ModelAnswer;
import com.julianocarpes.models.Product;
import com.julianocarpes.repositories.ProductRepository;

@Service
public class ProductService {
	
	private Logger logger = Logger.getLogger(ProductService.class.getName());
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private ModelAnswer message;
	
	public Iterable<Product>findAll(){
		logger.info("Finding a Porducts");
		return repository.findAll();
	
	}
	
	public ResponseEntity<Product> findById(Long id) {
	    Optional<Product> optionalProduct = repository.findById(id);
	    if (optionalProduct.isPresent()) {
	        Product product = optionalProduct.get();
	        return ResponseEntity.ok(product); // Retorna o produto com status HTTP 200 OK
	    } else {
	        return ResponseEntity.notFound().build(); // Retorna 404 Not Found caso não encontre o produto
	    }
	}

	
	public ResponseEntity<?> created(Product product) {
		logger.info("Created a product");
		if(product.getName().equals("")) {
			message.setMessage("Nome do produto vazio");
			return new ResponseEntity<ModelAnswer>(message,HttpStatus.BAD_REQUEST);
		}else if(product.getQuantity() < 1) {
			message.setMessage("Quantidade vazia");
			return new ResponseEntity<ModelAnswer>(message,HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Product>(repository.save(product),HttpStatus.CREATED);
		}
	}
	
	public ResponseEntity<Product> update(Product prod) {
	    Product entity = repository.findById(prod.getId()).orElseThrow(() -> new ResourceNotFaundExceptions("No Records found for this ID"));
	    
	    // Atualizar os atributos do objeto entity com os valores do objeto prod
	    entity.setName(prod.getName());
	    entity.setQuantity(prod.getQuantity());
	    entity.setPrice(prod.getPrice());
	    entity.setAmount(prod.getAmount());
	    entity.setDescription(prod.getDescription());
	    
	    // Salvar o objeto entity atualizado no repositório
	    Product updatedProduct = repository.save(entity);
	    
	    // Retornar o objeto atualizado com o status HTTP 200 OK
	    return ResponseEntity.ok(updatedProduct);
	}

	public ResponseEntity<ModelAnswer> delete(Long id) {
		logger.info("Delete a product");
		repository.deleteById(id);
		message.setMessage("product removed successfully");
		return new ResponseEntity<ModelAnswer>(message,HttpStatus.OK);
	}

}
