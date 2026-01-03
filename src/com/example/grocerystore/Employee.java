package com.example.grocerystore;

public class Employee extends Person {
    private String position;
    private double salary;

    public Employee(String id, String name, String position, double salary) {
        super(id, name);
        setPosition(position);
        setSalary(salary);
    }

    public Employee() {
        this("E000", "Staff", "CASHIER", 0);
    }

    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    public void setPosition(String position) {
        if (position == null || position.trim().isEmpty()) {
            this.position = "CASHIER";
        } else {
            this.position = position.trim().toUpperCase();
        }
    }

    public void setSalary(double salary) {
        if (salary < 0) this.salary = 0;
        else this.salary = salary;
    }

    @Override
    public String getRole() {
        return "Employee";
    }

    @Override
    public void work() {
        System.out.println(name + " works as " + position + ". Salary: " + salary + " KZT");
    }

    @Override
    public String toString() {
        return super.toString() + ", position=" + position + ", salary=" + salary;
    }
}
