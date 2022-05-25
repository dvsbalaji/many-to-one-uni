package com.ty.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.dao.Review;

public class TestGetProductReview {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Review review = entityManager.find(Review.class, 2);
		if (review != null) {
			System.out.println("rating       : "+review.getRating());
			System.out.println("comment      : "+review.getComment());
			System.out.println("product name : "+review.getProduct().getName());
			System.out.println("product type : "+review.getProduct().getType());
			System.out.println("product cost : "+review.getProduct().getCost());
		}else {
			System.out.println("no review found");
		}
	}
}
