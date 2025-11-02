package models;
import java.util.List;

import models.abstracts.Employee;
import models.employees.Chef;


public class Cafe{
    private Kitchen kitchen;
    private Menu menu;
    private List<Employee> workers;
    private Chef chef;
    private List<Client> clients;
    private int maxCapacity;
    private boolean open;
  
    
    public Cafe(Kitchen kitchen, Menu menu, List<Employee> workers, Chef chef, List<Client> clients, int maxCapacity) {
        this.kitchen = kitchen;
        this.menu = menu;
        this.workers = workers;
        this.chef = chef;
        this.clients = clients;
        this.maxCapacity = maxCapacity;
        this.open = false;
    }
    void openCafe(){
        this.open = true;
    }
    void closeCafe(){
        this.open = false;
    }
}