package com.capgemini.emsOnetoOnemap.controller;

import com.capgemini.emsOnetoOnemap.dto.EmployeeDTO;
import com.capgemini.emsOnetoOnemap.entity.Employee;
import com.capgemini.emsOnetoOnemap.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/save")
    public String saveEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return employeeService.saveEmployee(employeeDTO);
    }

    @GetMapping("/find-all")
    public List<Employee> getAllEmployees() {
        return employeeService.getallEmployeeswAddress();
    }


    @GetMapping("/find-by-id/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeebyId(id);
    }

    @PutMapping("/update/{id}")
    public EmployeeDTO updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        return employeeService.deleteEmployee(id);
    }

}
