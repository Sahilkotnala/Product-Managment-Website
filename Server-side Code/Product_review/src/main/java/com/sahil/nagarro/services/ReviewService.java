package com.sahil.nagarro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.nagarro.models.Review;
import com.sahil.nagarro.repositary.ReviewRepo;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepo repository;
	
	public List<Review> getReview(int productCode) {
		return repository.findByReview(productCode);
	}


	public Review saveProduct(Review review) {
		return repository.save(review);
	}
	public long count() {
		return repository.count();
	}
	public int countReview()
	{
		return repository.countReview();
	}

}

