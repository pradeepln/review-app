package com.cisco.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import com.cisco.training.dal.ReviewDAO;
import com.cisco.training.domain.Review;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ReviewAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ReviewAppApplication.class, args);
//		ReviewDAO dao = ctx.getBean(ReviewDAO.class);
//		
//		Review sample = new Review("self", "very good stuff", 5, 1);
//		
//		dao.save(sample);
	}

}
