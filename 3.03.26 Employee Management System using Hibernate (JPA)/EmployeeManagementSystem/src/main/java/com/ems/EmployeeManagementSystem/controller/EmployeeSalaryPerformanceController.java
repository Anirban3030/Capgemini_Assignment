package com.ems.EmployeeManagementSystem.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.ems.EmployeeManagementSystem.dao.EmployeeDao;
import com.ems.EmployeeManagementSystem.dao.SalaryRecodDao;
import com.ems.EmployeeManagementSystem.dao.PerformanceReviewDao;

import com.ems.EmployeeManagementSystem.entity.Employee;
import com.ems.EmployeeManagementSystem.entity.SalaryRecord;
import com.ems.EmployeeManagementSystem.entity.PerformanceReview;

public class EmployeeSalaryPerformanceController {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDao employeeDao = new EmployeeDao();
        SalaryRecodDao salaryDao = new SalaryRecodDao();
        PerformanceReviewDao reviewDao = new PerformanceReviewDao();

        while(true){

            System.out.println("\n Employee Management System ");

            System.out.println("\n Employee");
            System.out.println();
            System.out.println("1. Insert New Employee");
            System.out.println("2. Update Employee Details (using employeeCode)");
            System.out.println("3. Soft Delete Employee (set active = false)");
            System.out.println("4. Fetch Employee by ID");
            System.out.println("5. Fetch Employee by EmployeeCode");
            System.out.println("6. Show All Active Employees");

            System.out.println("\n Salary Record");
            System.out.println();
            System.out.println("7. Insert Salary Record");
            System.out.println("8. Update Salary Record");
            System.out.println("9. Delete Salary Record");
            System.out.println("10. Fetch Salary Record by EmployeeCode");
            System.out.println("11. Fetch Salary Record by Salary Month");
            System.out.println("12. Show All Salary Records of an Employee");

            System.out.println("\n Performance");
            System.out.println();
            System.out.println("13. Insert Performance Review");
            System.out.println("14. Update Performance Review");
            System.out.println("15. Delete Performance Review");
            System.out.println("16. Show All Reviews of an Employee");

            System.out.println("\n17. Exit Program");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1){

                Employee e = new Employee();

                System.out.print("Employee Code: ");
                e.setEmployeeCode(sc.nextLine());

                System.out.print("Name: ");
                e.setName(sc.nextLine());

                System.out.print("Email: ");
                e.setEmail(sc.nextLine());

                System.out.print("Designation: ");
                e.setDesignation(sc.nextLine());

                System.out.print("Department: ");
                e.setDepartment(sc.nextLine());

                e.setJoiningDate(LocalDate.now());
                e.setActive(true);

                employeeDao.insert(e);
                System.out.println("Employee inserted successfully");
            }

            else if(choice == 2){

                System.out.print("Employee Code: ");
                String code = sc.nextLine();

                System.out.print("New Email: ");
                String email = sc.nextLine();

                System.out.print("New Designation: ");
                String des = sc.nextLine();

                employeeDao.updateByCode(code, email, des);

                System.out.println("Employee updated");
            }

            else if(choice == 3){

                System.out.print("Employee Code: ");
                String code = sc.nextLine();

                employeeDao.softDelete(code);

                System.out.println("Employee soft deleted");
            }

            else if(choice == 4){

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();

                Employee e = employeeDao.getById(id);

                System.out.println(e.getEmployeeCode()+" "+e.getName()+" "+e.getDepartment());
            }

            else if(choice == 5){

                System.out.print("Employee Code: ");
                String code = sc.nextLine();

                Employee e = employeeDao.getByCode(code);

                System.out.println(e.getEmployeeCode()+" "+e.getName()+" "+e.getDepartment());
            }

            else if(choice == 6){

                List<Employee> list = employeeDao.getAllActive();

                for(Employee e : list){
                    System.out.println(e.getEmployeeCode()+" "+e.getName()+" "+e.getDepartment());
                }
            }

            else if(choice == 7){

                SalaryRecord s = new SalaryRecord();

                System.out.print("Employee Code: ");
                s.setEmployeeCode(sc.nextLine());

                System.out.print("Base Salary: ");
                s.setBaseSalary(sc.nextDouble());

                System.out.print("Bonus: ");
                s.setBonus(sc.nextDouble());

                System.out.print("Tax: ");
                s.setTax(sc.nextDouble());
                sc.nextLine();

                System.out.print("Salary Month (YYYY-MM): ");
                s.setSalaryMonth(sc.nextLine());

                salaryDao.insert(s);

                System.out.println("Salary record inserted");
            }

            else if(choice == 8){

                System.out.print("Salary Record ID: ");
                int id = sc.nextInt();

                System.out.print("New Bonus: ");
                double bonus = sc.nextDouble();

                System.out.print("New Tax: ");
                double tax = sc.nextDouble();

                salaryDao.update(id, bonus, tax);

                System.out.println("Salary updated");
            }

            else if(choice == 9){

                System.out.print("Salary Record ID: ");
                int id = sc.nextInt();

                salaryDao.delete(id);

                System.out.println("Salary deleted");
            }

            else if(choice == 13){

                PerformanceReview p = new PerformanceReview();

                System.out.print("Employee Code: ");
                p.setEmployeeCode(sc.nextLine());

                System.out.print("Rating (1-5): ");
                p.setRating(sc.nextInt());
                sc.nextLine();

                p.setReviewDate(LocalDate.now());

                System.out.print("Comments: ");
                p.setComments(sc.nextLine());

                reviewDao.insert(p);

                System.out.println("Review added");
            }

            else if(choice == 17){

                System.out.println("Program exited");
                break;
            }

            else{
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}