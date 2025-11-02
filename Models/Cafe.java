package models;
import java.util.List;

import models.employees.Chef;
import models.employees.Waiter;

public class Cafe{
    private Kitchen kitchen;
    private Menu menu;
    private List<Waiter> workers;
    private Chef chef;
    private List<Client> clients;
    private int maxCapacity;
    private boolean open;
  
    void openCafe(){
        this.open = true;
    }
    void closeCafe(){
        this.open = false;
    }
}