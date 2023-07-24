package com.julianocarpes.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julianocarpes.exceptions.MyExceptions;
import com.julianocarpes.models.Product;
import com.julianocarpes.repositories.ProductRepository;
import com.julianocarpes.utils.Calculation;

@Service
public class ProductService {
	
	private Logger logger = Logger.getLogger(ProductService.class.getName());
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product>findAll(){
		logger.info("Finding a Porducts");
		List<Product> products = repository.findAll();
		for (Product product : products) {
			product.setAmount(Calculation.calculateAmount(product.getPrice(), product.getQuantity()));
		}
		return products;
	}
	
	public Product findById(Long id) {
		logger.info("Finding a Product for id");
		return repository.findById(id).orElseThrow(()-> new MyExceptions("No Records found for this ID"));
	}

}
