package models;
import java.util.List;

import models.abstracts.Employee;
import models.employees.Chef;


public class Cafe{
    
    private Kitchen kitchen;
    private Menu menu;
    private List<Employee> workers;
    // private Chef chef;
    private List<Client> clients;
    private int maxCapacity;
    private boolean open;
  
    
    public Cafe(Kitchen kitchen, Menu menu, List<Employee> workers, List<Client> clients, int maxCapacity) {
        this.kitchen = kitchen;
        this.menu = menu;
        this.workers = workers;
        this.clients = clients;
        this.maxCapacity = maxCapacity;
        this.open = false;
    }
    public void openCafe(){
        this.open = true;
        System.out.println("Кафе открыто");
    }
    public void closeCafe(){
        this.open = false;
        System.out.println("Кафе закрыто");
    }
    public void addClientInCafe(Client client){
        this.clients.add(client);
    }
    public void delClientInCafe(Client client){
        this.clients.remove(client);
    }
    public Kitchen getKitchen() {return kitchen;}
    public Menu getMenu() {return menu;}
    public List<Employee> getWorkers() { return workers;}
    public List<Client> getClients() {return clients;}
    public int getMaxCapacity() {return maxCapacity;}
    
}