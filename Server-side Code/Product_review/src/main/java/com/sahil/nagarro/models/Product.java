package com.sahil.nagarro.models;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	int productCode;
	String productName;
	String brand;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Product()
	{
		
	}
	public Product(Long id, int productCode, String productName, String brand) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.productName = productName;
		this.brand = brand;
	}
	
	
	
	
	
	
}
