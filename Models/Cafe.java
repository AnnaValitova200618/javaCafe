package Models;

import java.util.List;

public class Cafe{
    Kitchen kitchen;
    Menu menu;
    List<Worker> workers;
    List<Client> clients;
    int maxCapacity;
    boolean open;
  
    void openCafe(){
        this.open = true;
    }
    void closeCafe(){
        this.open = false;
    }
}