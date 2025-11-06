import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Cafe;
import models.Client;
import models.Dish;
import models.Kitchen;
import models.Menu;
import models.Order;
import models.abstracts.Employee;
import models.employees.Chef;
import models.employees.Waiter;

public class runApp {
    public static void main(String[] args) {
        System.out.println("Чтобы программа нормально функционаировала, пожалуйста, вводите y - да или n - нет");

        // List<Dish> dishes = new ArrayList<>();
        Menu menu = new Menu();
        //Waiter natalya = new Waiter("Наталья", 30000);
        Waiter waiter = new Waiter("Рома", 29000);
        Chef chef = new Chef("Фома", 400000);
        Client client = new Client("Ростик", 20000);
        Kitchen kitchen = new Kitchen(null);
        List<Employee> workersCafe = new ArrayList<>();
        List<Client> clients = new ArrayList<>();

        workersCafe.add(waiter);
        workersCafe.add(chef);
        
        Cafe cafe = new Cafe(kitchen, menu, workersCafe, clients, 5);

        cafe.openCafe();// кафе открылось
        clients.add(client);//ростик теперь с другими клиентами
       
        
        simulateWorkingDay(cafe, waiter, chef, menu);//cимуляция рабочего дня
        
        cafe.closeCafe();
    }
    
    public static void simulateWorkingDay(Cafe cafe, Waiter waiter, Chef chef, Menu menu) {
        if (cafe.getClients() == null || cafe.getClients().isEmpty()) {
            System.out.println("Нет клиентов в кафе!");
            return;
        }
    
        Client firstClient = cafe.getClients().getFirst();
    
        System.out.println("=== ДОБРО ПОЖАЛОВАТЬ В КАФЕ! ===");
        menu.printMenu();
        System.out.println();
    
        System.out.println("=== ПРОЦЕСС ЗАКАЗА ===");
        Order order = waiter.takeOrder(firstClient, menu);
    
        if (order == null) {
            System.out.println("Заказ не был сделан. До свидания!");
            return;
        }
    
        waiter.toKitchen(order); // Официант передает заказ на кухню
    
        Kitchen kitchen = cafe.getKitchen();//Фома на кухне готовит заказ
        if (kitchen != null) {
            kitchen.toCook(order);
        } else {
            System.out.println("Ошибка: кухня недоступна!");
            return;
        }
    
        waiter.getOrderFromKitchen(order);//Рома забирает готовый заказ
    
        // Расчёт и оплата
        try {
            int totalPrice = order.getTotalPrice();//считаем на сколько наел Ростик
            firstClient.payOrder(totalPrice);//Ростик оплачивает
            waiter.addCompletedOrder(order);//учитываем выполненный заказ для зарплаты Ромы
            printSalaryReport(waiter, chef, order);//отчет по зарплатам
        } catch (Exception e) {
            System.out.println("Ошибка при расчёте заказа: " + e.getMessage());
        }
    }
    
    public static void printSalaryReport(Waiter waiter, Chef chef, Order order) {
        System.out.println("\n=== ОТЧЕТ ПО ЗАРПЛАТАМ ===");
        System.out.printf("Официант %s: %.2f руб.%n", 
            waiter.getName(), waiter.calculateSalary(order));
        System.out.printf("Повар %s: %.2f руб.%n", 
            chef.getName(), chef.calculateSalary(order));
    }

    
}