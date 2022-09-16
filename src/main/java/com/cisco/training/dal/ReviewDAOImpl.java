package com.cisco.training.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cisco.training.domain.Review;

@Transactional
@Repository
public class ReviewDAOImpl implements ReviewDAO {

	@Autowired
	EntityManager em;
	
	@Override
	public Review save(Review toBeSaved) {
		em.persist(toBeSaved);
		return toBeSaved;
	}

	@Override
	public Review findById(int id) {
		return em.find(Review.class, id);
	}

	@Override
	public List<Review> findAll() {
		
		return em.createQuery("select r from Review r").getResultList();
	}

	@Override
	public void deleteById(int id) {
		em.createQuery("delete from Review r where r.id=:x")
			.setParameter("x", id)
			.executeUpdate();
		
	}

	@Override
	public List<Review> findByPid(int pid) {
		
		return em.createQuery("select r from Review r where r.pid=:x")
				.setParameter("x", pid)
				.getResultList();
	}

}
