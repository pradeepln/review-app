package com.cisco.training.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-app")
public interface RemoteProductService {
	
	@GetMapping("/products/{id}")
	public String getProductById(@PathVariable("id") int productId);

}
