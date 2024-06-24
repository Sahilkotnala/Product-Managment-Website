package com.sahil.nagarro.repositary;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sahil.nagarro.models.Product;



public interface Productrepository extends JpaRepository<Product, Long> {

Product findByProductCode(String productCode);
	
	@Query("Select c from Product c Where "
			+ "(:productName = '' OR c.productName LIKE concat('%', :productName ,'%')) "
			+ "AND (:brand = '' OR c.brand LIKE concat('%', :brand ,'%')) "
			+ "AND (:productCode = '' OR c.productCode LIKE concat('%', :productCode ,'%')) "
			
			)
	List<Product> searchByFields(@Param("productName") String productName ,@Param("productCode") String productCode ,@Param("brand") String brand);
	
	@Query("select COUNT(*) from Product")
	int countProduct();
	
	@Query("from Product where productCode=?1")
	Product getByproductCode(int code);
}
