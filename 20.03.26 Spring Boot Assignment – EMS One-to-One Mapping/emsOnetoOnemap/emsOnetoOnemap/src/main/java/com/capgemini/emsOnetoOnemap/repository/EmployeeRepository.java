package com.capgemini.emsOnetoOnemap.repository;

import com.capgemini.emsOnetoOnemap.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}