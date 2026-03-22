package com.capgemini.emsOnetoOnemap.service;

import com.capgemini.emsOnetoOnemap.dto.AddressDTO;
import com.capgemini.emsOnetoOnemap.dto.EmployeeDTO;
import com.capgemini.emsOnetoOnemap.entity.Address;
import com.capgemini.emsOnetoOnemap.entity.Employee;
import com.capgemini.emsOnetoOnemap.exception.EmployeeNotFoundException;
import com.capgemini.emsOnetoOnemap.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee, "address");

        Address address = new Address();
        BeanUtils.copyProperties(employeeDTO.getAddress(), address);

        employee.setAddress(address);
        employeeRepository.save(employee);
        return "Employee Saved Successfully";
    }

    @Override
    public List<Employee> getallEmployeeswAddress() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeebyId(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        }
        throw new EmployeeNotFoundException("Employee not found with id: " + id);
    }

    @Override
    public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            if (employeeDTO.getName() != null) employee.setName(employeeDTO.getName());
            if (employeeDTO.getEmail() != null) employee.setEmail(employeeDTO.getEmail());
            if (employeeDTO.getPhone() != null) employee.setPhone(employeeDTO.getPhone());
            if (employeeDTO.getGender() != null) employee.setGender(employeeDTO.getGender());
            if (employeeDTO.getDesignation() != null) employee.setDesignation(employeeDTO.getDesignation());
            if (employeeDTO.getSalary() != 0) employee.setSalary(employeeDTO.getSalary());
            if (employeeDTO.getDateOfJoining() != null) employee.setDateOfJoining(employeeDTO.getDateOfJoining());

            if (employeeDTO.getAddress() != null && employee.getAddress() != null) {
                AddressDTO addressDTO = employeeDTO.getAddress();
                Address address = employee.getAddress();

                if (addressDTO.getStreet() != null) address.setStreet(addressDTO.getStreet());
                if (addressDTO.getCity() != null) address.setCity(addressDTO.getCity());
                if (addressDTO.getState() != null) address.setState(addressDTO.getState());
                if (addressDTO.getCountry() != null) address.setCountry(addressDTO.getCountry());
                if (addressDTO.getPincode() != null) address.setPincode(addressDTO.getPincode());
            }

            Employee updatedEmployee = employeeRepository.save(employee);

            EmployeeDTO updatedDTO = new EmployeeDTO();
            BeanUtils.copyProperties(updatedEmployee, updatedDTO, "address");

            AddressDTO addressDTO = new AddressDTO();
            BeanUtils.copyProperties(updatedEmployee.getAddress(), addressDTO);
            updatedDTO.setAddress(addressDTO);

            return updatedDTO;
        }
        throw new EmployeeNotFoundException("Employee not found with id: " + id);
    }

    @Override
    public String deleteEmployee(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee Deleted Successfully";
        }
        throw new EmployeeNotFoundException("Employee not found with id: " + id);
    }
}