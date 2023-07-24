package com.julianocarpes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julianocarpes.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
