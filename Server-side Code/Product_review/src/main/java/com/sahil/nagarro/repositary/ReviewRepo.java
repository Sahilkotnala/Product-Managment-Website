package com.sahil.nagarro.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sahil.nagarro.models.Review;
public interface ReviewRepo extends JpaRepository<Review,Integer>{
	
	@Query("from Review where productCode=?1")
	List<Review> findByReview(int productCode);

	
	
	@Query("select COUNT(*) from Review")
	int countReview();
}

