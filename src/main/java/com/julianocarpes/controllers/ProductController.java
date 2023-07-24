package com.julianocarpes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julianocarpes.models.Product;
import com.julianocarpes.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	@GetMapping
	private List<Product> findAll(){
		return service.findAll();
	}
	@GetMapping(value = "/{id}")
	private Product findById(@PathVariable(value = "id")Long id) {
		return service.findById(id);
	}

}
