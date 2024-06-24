package com.sahil.nagarro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.nagarro.models.Product;
import com.sahil.nagarro.repositary.Productrepository;



@Service
public class Productservice {
	

	@Autowired
	private Productrepository prodrepo;
	
	
	public Product saveProduct(Product p)
	{
		return this.prodrepo.save(p);
	}
	
	public List<Product> getProducts()
	{
		return this.prodrepo.findAll();
	}

	public List<Product> searchOperation(String name, String code, String brand) {
		
	  return this.prodrepo.searchByFields(name, code,brand);
	}
	public int countProduct()
	{
		
		return prodrepo.countProduct();
		
		
	}
	
	
	

	public Product getProductbyCode(String productCode) {
		Product products = this.prodrepo.findByProductCode(productCode);
		return products;
	}
	
	public Product getByproductCode(Product product)
	{
		Product result;
		Product p=prodrepo.getByproductCode(product.getProductCode());
		if(p!=null)
		{
			result=p;
		}
		else
		{
			this.prodrepo.save(product);
			result=null;
		}
		return result;
		
	}

}
