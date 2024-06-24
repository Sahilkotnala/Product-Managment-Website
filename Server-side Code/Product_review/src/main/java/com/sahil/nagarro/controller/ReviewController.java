package com.sahil.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.nagarro.models.Review;
import com.sahil.nagarro.services.*;

@RestController
@CrossOrigin("*")
public class ReviewController {
	@Autowired
	private ReviewService service;
	
	
//	This function will let us get all reviews from particular productCode
	@GetMapping("/review/{productCode}")
	public List<Review> getReview(@PathVariable int productCode) {
		return service.getReview(productCode);
	}
	
	
//	This function will let us add new review
	@PostMapping("/addreview")
	public String addReview(@RequestBody Review review) {
		service.saveProduct(review);
		return "Thanks for your contribution..your review got successfully submitted !! ";
		

	}
	@GetMapping("/reviewcount")
	public long count() {
		return service.count();
	}
	
	@GetMapping("/loginuser")
	public int logincount()
	{
		return service.countReview();
		
		
	}
}

