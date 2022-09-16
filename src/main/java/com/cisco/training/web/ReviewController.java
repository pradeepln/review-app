package com.cisco.training.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.cisco.training.dal.ReviewDAO;
import com.cisco.training.domain.Review;

@RestController
public class ReviewController {
	
	@Autowired
	ReviewDAO dao;
	
	@Autowired
	RemoteProductService productService;
	
	@PostMapping("/reviews")
	public ResponseEntity<Review> addReview(@RequestBody Review toBeAdded){
		int pid = toBeAdded.getPid();
		
		try {
			String json = productService.getProductById(pid);
			Review added = dao.save(toBeAdded);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/reviews/"+added.getId()));
			return new ResponseEntity<Review>(added, headers, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);			
		}
	}
	
	@GetMapping("/reviews") // ?pid=1
	public List<Review> getReviewsForProduct(@RequestParam("pid") int pid){
		return dao.findByPid(pid);
	}

}
