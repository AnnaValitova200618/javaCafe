package models.abstracts;

import models.Order;

public abstract class Employee {
    protected String name;
    protected String position;
    protected double salary;
    
    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    
    public abstract double calculateSalary(Order order);
    
    
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary(){ return salary;}
}