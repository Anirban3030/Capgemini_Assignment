package com.capgemini.emsOnetoOnemap.service;

import com.capgemini.emsOnetoOnemap.dto.EmployeeDTO;
import com.capgemini.emsOnetoOnemap.entity.Employee;

import java.util.List;

public interface EmployeeService {
    String saveEmployee(EmployeeDTO employeeDTO);

    List<Employee> getallEmployeeswAddress();

    Employee getEmployeebyId(int id);

    EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO);

    String deleteEmployee(int id);

}
