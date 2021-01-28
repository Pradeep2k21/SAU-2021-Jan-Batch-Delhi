package com.paysquarePortal.model;

public class SeniorSoftwareDeveloper extends Employee{

    private double salary = 130000.0;

    public SeniorSoftwareDeveloper() {
    }

    public SeniorSoftwareDeveloper(int empId, String name, String emailId, String phone, int leavesTaken) {
        super(empId, name, emailId, phone, leavesTaken);
    }

    public SeniorSoftwareDeveloper(double salary) {
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
        System.out.println("Senior software salary: "+this.salary);
    }
}
