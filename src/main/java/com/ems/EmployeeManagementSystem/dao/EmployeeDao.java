package com.ems.EmployeeManagementSystem.dao;

import java.util.List;
import javax.persistence.*;

import com.ems.EmployeeManagementSystem.entity.Employee;

public class EmployeeDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EMP02");
    EntityManager entitymanager = entityManagerFactory.createEntityManager();

    public void insert(Employee e) {

        EntityTransaction transaction = entitymanager.getTransaction();
        transaction.begin();
        entitymanager.persist(e);
        transaction.commit();
    }

    public Employee getById(int id) {

        return entitymanager.find(Employee.class, id);
    }

    public Employee getByCode(String code) {

        String jpql = "select e from Employee e where e.employeeCode = :c";

        return entitymanager.createQuery(jpql, Employee.class)
                .setParameter("c", code)
                .getSingleResult();
    }

    public void updateByCode(String code, String email, String designation) {

        EntityTransaction transaction = entitymanager.getTransaction();
        transaction.begin();

        String query = "select e from Employee e where e.employeeCode = :c";

        Employee e = entitymanager.createQuery(query, Employee.class)
                .setParameter("c", code)
                .getSingleResult();

        e.setEmail(email);
        e.setDesignation(designation);

        transaction.commit();
    }

    public void softDelete(String code) {

        EntityTransaction transaction = entitymanager.getTransaction();
        transaction.begin();

        String query = "select e from Employee e where e.employeeCode = :c";

        Employee e = entitymanager.createQuery(query, Employee.class)
                .setParameter("c", code)
                .getSingleResult();

        e.setActive(false);

        transaction.commit();
    }

    public List<Employee> getAllActive() {

        String query = "select e from Employee e where e.active = true";

        return entitymanager.createQuery(query, Employee.class).getResultList();
    }
}