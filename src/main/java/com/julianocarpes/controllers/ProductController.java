package com.julianocarpes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import com.julianocarpes.models.Product;
import com.julianocarpes.services.ProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping
	private Iterable<Product> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<Product> findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	@PostMapping("/register")
	private ResponseEntity<?> created(@RequestBody Product prod) {
		return service.created(prod);
	}

	//@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PutMapping(value = "/update")
	private ResponseEntity<Product> update(@RequestBody Product prod) {
		return service.update(prod);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id")Long id ) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
