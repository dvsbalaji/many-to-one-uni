package com.ty.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dao.AmazonOrder;
import com.ty.dao.Item;

public class TsetSaveItemOrder {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		AmazonOrder amazonOrder = new AmazonOrder() ;
		amazonOrder.setName("office items");
		amazonOrder.setAddress("basawanna gudi");
		amazonOrder.setStatus("order placesd");
		
		Item item = new Item() ;
		item.setName("white board");
		item.setPrice(1500);
		item.setQuantity(1);
		item.setAmazonOrder(amazonOrder);
		
		Item item1 = new Item() ;
		item1.setName("marker");
		item1.setPrice(30);
		item1.setQuantity(1);
		item1.setAmazonOrder(amazonOrder);
		
		Item item2 = new Item() ;
		item2.setName("tissue papers");
		item2.setPrice(800);
		item2.setQuantity(1);
		item2.setAmazonOrder(amazonOrder);
		
		entityTransaction.begin();
		entityManager.persist(amazonOrder);
		entityManager.persist(item);
		entityManager.persist(item1);
		entityManager.persist(item2);
		entityTransaction.commit();
		
	}
}
