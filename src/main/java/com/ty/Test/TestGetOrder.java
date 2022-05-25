package com.ty.Test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.dao.Item;

public class TestGetOrder {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Item item = entityManager.find(Item.class, 1);

		if (item != null) {
			System.out.println("item name  : " + item.getName());
			System.out.println("item price : " + item.getPrice());
			System.out.println("item qty   : " + item.getQuantity());

			if (item.getAmazonOrder() != null) {
				
				System.out.println("order name : "+item.getAmazonOrder().getName());
				System.out.println("order address : "+item.getAmazonOrder().getAddress());
				System.out.println("order status : "+item.getAmazonOrder().getStatus());
			}
		}else {
			System.out.println("item not found");
		}

	}
}
