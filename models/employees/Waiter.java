package models.employees;
import models.abstracts.Employee;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enums.OrderStatus;
import models.Client;
import models.Dish;
import models.Menu;
import models.Order;


public class Waiter extends Employee {
    private List<Order> completedOrders = new ArrayList<>();
    
    public Waiter(String name, double salary) {
        super(name, "Официант", salary);
    }
    
    public void addCompletedOrder(Order order) {
        completedOrders.add(order);
    }
    
    @Override
    public double calculateSalary(Order order) {
        double totalOrderPrice = order.getTotalPrice();
        return salary + (totalOrderPrice * 0.05);
    }
    
    public Order takeOrder(Client client, Menu menu){
        Scanner scanner = new java.util.Scanner(System.in, "cp866");
        List<Dish> dishes = new ArrayList<>();
        Order order = null;

        System.out.println("Добрый день, готовы сделать заказ?");
        char answer = scanner.next().charAt(0);

        if(answer == 'y'){
            boolean flag = true;
            while (flag) {
                int idDish = scanner.nextInt();
                Dish foundDish = menu.getDishes().stream().filter(s -> s.getID() == idDish).findFirst().orElse(null);;
                
                if(foundDish == null){
                    System.out.println("Такого блюда нет");
                }
                else{
                    dishes.add(foundDish);
                    System.out.println("Что-нибудь ещё?");
                    answer = scanner.next().charAt(0);

                    if(answer == 'n'){
                        
                        order = new Order(dishes, this, client);
                        flag = false;
                    }
                }
            }
        }
        else{
            menu.printMenu();
        }

        scanner.close();
        return order;
  }

    public void toKitchen(Order order){

    }

    public void getOrderFromKitchen(Order order){

    }
}