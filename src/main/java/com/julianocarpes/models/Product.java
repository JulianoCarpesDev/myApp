package com.julianocarpes.models;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.julianocarpes.utils.Calculation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
@JsonPropertyOrder({"id","name","quantity","price","amount","description"})
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "product_name")
	private String name;
	private Integer quantity;
	private Double price;
	private Double amount;
	private String description;
	
	
	public Product() {
		
	}


	public Product(Long id, String name, String description, Integer quantity, Double price, Double amount) {
	
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
		this.description = description;
	}


	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public Double getPrice() {
		return price;
	}


	public Double getAmount() {
		return amount = getPrice() * getQuantity();
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}
	


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity
				+ ", price=" + price + ", amount=" + amount + "]";
	}
	
	

}
