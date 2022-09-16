package com.cisco.training.dal;

import java.util.List;

import com.cisco.training.domain.Review;



public interface ReviewDAO {

	Review save(Review toBeSaved);
	Review findById(int id);
	List<Review> findAll();
	void deleteById(int id);
	List<Review> findByPid(int pid);
}
