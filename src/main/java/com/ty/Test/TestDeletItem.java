package com.ty.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dao.Item;

public class TestDeletItem {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		Item item = entityManager.find(Item.class, 1);

		if (item != null) {
			entityTransaction.begin();
			if (item.getAmazonOrder() != null) {
				entityManager.remove(item.getAmazonOrder());
			}
			entityManager.remove(item);
			entityTransaction.commit();
		}else {
			System.out.println("item not found");
		}
		
	}
}
