package com.paysquarePortal.DesignFactory;

import com.paysquarePortal.model.*;

public class EmployeeFactory {

    public Employee getEmployee(String designation, double salary){

        designation = designation.toUpperCase();
        Employee employee;

        switch(designation){

            case "MANAGER":
                employee = new Manager(salary);
                break;
            case "SDE_2":
                employee = new SeniorSoftwareDeveloper(salary);
                break;
            case "SDE_1":
                employee = new SoftwareDeveloper(salary);
                break;
            case "INTERN":
                employee = new Intern(salary);
                break;
            default:
                employee = new Employee() {
                    @Override
                    public double calculateSalaryPaid(int daysInMonth) {
                        return 0;
                    }
                };
        }

        return employee;
    }

    public Employee getEmployee(String designation){

        designation = designation.toUpperCase();
        Employee employee;

        switch(designation){

            case "MANAGER":
                employee = new Manager();
                break;
            case "SDE_2":
                employee = new SeniorSoftwareDeveloper();
                break;
            case "SDE_1":
                employee = new SoftwareDeveloper();
                break;
            case "INTERN":
                employee = new Intern();
                break;
            default:
                employee = new Employee() {
                    @Override
                    public double calculateSalaryPaid(int daysInMonth) {
                        return 0;
                    }
                };
        }

        return employee;

    }

}
