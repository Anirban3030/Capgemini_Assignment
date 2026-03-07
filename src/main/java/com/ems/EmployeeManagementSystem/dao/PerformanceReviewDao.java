package com.ems.EmployeeManagementSystem.dao;

import java.util.List;
import javax.persistence.*;

import com.ems.EmployeeManagementSystem.entity.PerformanceReview;

public class PerformanceReviewDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EMP02");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void insert(PerformanceReview p) {

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(p);

        entityTransaction.commit();
    }

    public void update(int id, int rating, String comments) {

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        PerformanceReview performanceReview = entityManager.find(PerformanceReview.class, id);

        performanceReview.setRating(rating);
        performanceReview.setComments(comments);

        entityTransaction.commit();
    }

    public void delete(int id) {

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        PerformanceReview performanceReview = entityManager.find(PerformanceReview.class, id);

        entityManager.remove(performanceReview);

        entityTransaction.commit();
    }

    public List<PerformanceReview> getByEmployee(String code) {

        String query = "select p from PerformanceReview p where p.employeeCode = :c";

        return entityManager.createQuery(query, PerformanceReview.class)
                .setParameter("c", code)
                .getResultList();
    }
}