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
    
    public Order takeOrder(Client client, Menu menu) {
        Scanner scanner = new java.util.Scanner(System.in, "cp866");
        List<Dish> dishes = new ArrayList<>();
    
        System.out.println("Добрый день! Готовы сделать заказ? (y/n)");
        String answer = scanner.next();
    
        if (!answer.equals("y")) {
            System.out.println("Хорошо, возвращайтесь позже!");
            
            scanner.close();
            return null;
        }
    
        while (true) {
            System.out.println("\nКакое блюдо желаете? Введите ID из меню:");
            
    
            try {
                int idDish = scanner.nextInt();
                Dish foundDish = menu.getDishes().stream().filter(d -> d.getId() == idDish).findFirst().orElse(null);
    
                if (foundDish == null) {
                    System.out.println("Блюдо с ID " + idDish + " не найдено.");
                    continue;
                }
    
                dishes.add(foundDish);
                System.out.println("Хотите что-нибудь ещё? (y/n)");
                answer = scanner.next();
    
                if (answer.equals("n")) {
                    scanner.close();
                    return new Order(dishes, this, client);
                }
                
    
            } catch (Exception e) {
                System.out.println("Ошибка: введите корректный ID (целое число).");
                scanner.nextLine(); // съедаем неверный ввод, чтобы не зациклиться
            }
        }
    }

    public void toKitchen(Order order){

        if(order.getStatus() != OrderStatus.CREATED){
            System.out.println("возникла проблема с блюдом");
            return;
        }
        System.out.println("Статус заказа - ожидание");
        order.setStatus(OrderStatus.PENDING);
    }

    public void getOrderFromKitchen(Order order){
        if(order.getStatus() != OrderStatus.IN_WORK){
            System.out.println("возникла проблема с блюдом");
            return;
        }
        System.out.println("Статус заказа - готово");
        order.setStatus(OrderStatus.DONE);
    }
}