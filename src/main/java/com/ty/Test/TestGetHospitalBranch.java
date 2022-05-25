package com.ty.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.dao.Branch;

public class TestGetHospitalBranch {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Branch branch = entityManager.find(Branch.class, 1);

		if (branch != null) {
			System.out.println("branch name : " + branch.getName());
			System.out.println("branch state : " + branch.getState());
			System.out.println("branch country : " + branch.getCountry());
			System.out.println("branch phone : " + branch.getPhoen());

			if (branch.getHospital() != null) {
				System.out.println("hospital name : "+branch.getHospital().getName());
				System.out.println("hospital web : "+branch.getHospital().getWebsite());
			}
		}
	}
}
