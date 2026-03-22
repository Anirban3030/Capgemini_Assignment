package com.ems.EmployeeManagementSystem.dao;

import java.util.List;
import javax.persistence.*;

import com.ems.EmployeeManagementSystem.entity.SalaryRecord;

public class SalaryRecodDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EMP02");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void insert(SalaryRecord s) {

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        s.calculateNetSalary();

        entityManager.persist(s);

        entityTransaction.commit();
    }

    public void update(int id, double bonus, double tax) {

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        SalaryRecord s = entityManager.find(SalaryRecord.class, id);

        s.setBonus(bonus);
        s.setTax(tax);

        s.calculateNetSalary();

        entityTransaction.commit();
    }

    public void delete(int id) {

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        SalaryRecord s = entityManager.find(SalaryRecord.class, id);

        entityManager.remove(s);

        entityTransaction.commit();
    }

    public List<SalaryRecord> getByEmployeeCode(String code) {

        String query = "select s from SalaryRecord s where s.employeeCode = :c";

        return entityManager.createQuery(query, SalaryRecord.class)
                .setParameter("c", code)
                .getResultList();
    }

    public SalaryRecord getByMonth(String month) {

        String query = "select s from SalaryRecord s where s.salaryMonth = :m";

        return entityManager.createQuery(query, SalaryRecord.class)
                .setParameter("m", month)
                .getSingleResult();
    }

    public List<SalaryRecord> getAllByEmployee(String code) {

        String query = "select s from SalaryRecord s where s.employeeCode = :c";

        return entityManager.createQuery(query, SalaryRecord.class)
                .setParameter("c", code)
                .getResultList();
    }
}