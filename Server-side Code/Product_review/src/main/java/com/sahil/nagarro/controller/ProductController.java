package com.sahil.nagarro.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.sahil.nagarro.models.Product;
import com.sahil.nagarro.models.User;
import com.sahil.nagarro.services.Productservice;


@RestController
@CrossOrigin("*")
public class ProductController {

	
	@Autowired
	private Productservice prodservice;
	
	
		
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product products)
	{
		return this.prodservice.saveProduct(products);
	}
		
		
	@GetMapping("/getProducts")
	public List<Product> getAllProducts()
	{
		return this.prodservice.getProducts();
	}
	
	@GetMapping("/search")
	public List<Product> search(
			@RequestParam(name = "name",defaultValue = "") String name,
			@RequestParam(name = "code",defaultValue = "") String code,
			@RequestParam(name = "brand",defaultValue = "") String brand)
	{
		System.out.println(name + "   "+ code +"    " +brand);
		return this.prodservice.searchOperation(name, code,brand);
		

		
		
	}
	
	
	
	@GetMapping("getProduct/{productcode}")
	public Product getProductByCode(@PathVariable("productcode") String productCode)
	{

		return this.prodservice.getProductbyCode(productCode);
	}
	
	@GetMapping("/noproduct")
	public int usercount()
	{
		return this.prodservice.countProduct();
		
		
	}
	
	@PostMapping("/request")
	public Product requestproduct(@RequestBody Product product)
	{
		return prodservice.getByproductCode(product);
	
	}
}
