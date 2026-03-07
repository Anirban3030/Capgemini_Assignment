package com.ems.EmployeeManagementSystem.entity;

import javax.persistence.*;

@Entity
@Table(name="salary_record")
public class SalaryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String employeeCode;

    private double baseSalary;
    private double bonus;
    private double tax;
    private double netSalary;

    private String salaryMonth;

    public int getId() {
        return id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setSalaryMonth(String salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    public String getSalaryMonth() {
        return salaryMonth;
    }

    public void calculateNetSalary() {
        netSalary = baseSalary + bonus - tax;
    }
}