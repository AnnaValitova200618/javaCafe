package models.employees;
import models.Order;
import models.abstracts.Employee;

public class Chef extends Employee {
    
    
    public Chef(String name, double salary) {
        super(name, "Повар", salary);
        
    }
    
    @Override
    public double calculateSalary(Order order) {
        return salary;
    }
    
    
}