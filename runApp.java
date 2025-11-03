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

        List<Dish> dishes = new ArrayList<>();
        Menu menu = new Menu(dishes);
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
        cafe.addClientInCafe(client);//ростик пришел в кафе
        
        simulateWorkingDay(cafe, waiter, chef, menu);//cимуляция рабочего дня
        
        cafe.closeCafe();
    }
    
    public static void simulateWorkingDay(Cafe cafe, Waiter waiter, Chef chef, Menu menu) {
        Scanner scanner = new Scanner(System.in, "cp866");
        
        System.out.println("=== ДОБРО ПОЖАЛОВАТЬ В КАФЕ! ===");
        menu.printMenu();
        
    
        // Процесс заказа
        System.out.println("\n=== ПРОЦЕСС ЗАКАЗА ===");
        Order order = waiter.takeOrder(cafe.getClients().getFirst(), menu);
        
        if (order != null) {
            // Официант передает заказ на кухню
            waiter.toKitchen(order);
            
            cafe.getKitchen().toCook(order);//Фома на кухне готовит заказ (хотя фома тут никак не задействован)
            
            waiter.getOrderFromKitchen(order);//Рома забирает готовый заказ
            
            int totalPrice = order.getTotalPrice();//считаем на сколько наел Ростик
            
            cafe.getClients().getFirst().payOrder(totalPrice);//Ростик оплачивает
            
            waiter.addCompletedOrder(order);//учитываем выполненный заказ для зарплаты Ромы
            
            printSalaryReport(waiter, chef, order);//отчет по зарплатам
        }
        
        scanner.close();
    }
    
    public static void printSalaryReport(Waiter waiter, Chef chef, Order order) {
        System.out.println("\n=== ОТЧЕТ ПО ЗАРПЛАТАМ ===");
        System.out.printf("Официант %s: %.2f руб.%n", 
            waiter.getName(), waiter.calculateSalary(order));
        System.out.printf("Повар %s: %.2f руб.%n", 
            chef.getName(), chef.calculateSalary(order));
    }

    
}