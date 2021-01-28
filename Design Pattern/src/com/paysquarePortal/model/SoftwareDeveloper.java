package com.paysquarePortal.model;

public class SoftwareDeveloper extends Employee{

    private double salary  = 80000.0;

    public SoftwareDeveloper() {
    }

    public SoftwareDeveloper(int empId, String name, String emailId, String phone, int leavesTaken) {
        super(empId, name, emailId, phone, leavesTaken);
    }

    public SoftwareDeveloper(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double calculateSalaryPaid(int daysInMonth) {
        double ratio = ((double)(this.getLeavesTaken())/(double)daysInMonth);
        double netSalary = (1-ratio)*this.salary;
        netSalary = Double.parseDouble(String.format("%.2f", netSalary));
        return netSalary;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Software developer salary: "+this.salary);
    }

}
