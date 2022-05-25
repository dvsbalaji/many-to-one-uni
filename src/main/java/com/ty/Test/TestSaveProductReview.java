package com.ty.Test; 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dao.Product;
import com.ty.dao.Review;

public class TestSaveProductReview {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		Product product = new Product() ;
		product.setName("MI");
		product.setType("Mobile");
		product.setCost(13900);
		
		Review review = new Review() ;
		review.setRating(3);
		review.setComment("camera not good");
		review.setProduct(product);
		
		Review review1 = new Review() ;
		review1.setRating(4);
		review1.setComment("very nice futures");
		review1.setProduct(product);
		
		Review review2 = new Review() ;
		review2.setRating(4);
		review2.setComment("budget friendly");
		review2.setProduct(product);
		
		entityTransaction.begin();
		entityManager.persist(product);
		entityManager.persist(review);
		entityManager.persist(review1);
		entityManager.persist(review2);
		entityTransaction.commit();
	}
}
