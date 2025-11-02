package models.employees;
import models.Order;
import models.abstracts.Employee;

public class Chef extends Employee {
    private String specialization;
    
    public Chef(String name, double salary, String specialization) {
        super(name, "Повар", salary);
        this.specialization = specialization;
    }
    
    @Override
    public double calculateSalary(Order order) {
        return salary; // Фиксированная зарплата для повара
    }
    
    public String getSpecialization() { return specialization; }
}