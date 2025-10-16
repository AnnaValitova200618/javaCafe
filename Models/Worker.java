package Models;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.Order.OrderStatus;

public class Worker {
    String name;
    String position;
  
  Order takeOrder(Client client, Menu menu){
        Scanner scanner = new java.util.Scanner(System.in, "cp866");
        List<Dish> dishes = new ArrayList<>();
        ZonedDateTime dateTime = ZonedDateTime.now();
        OrderStatus orderStatus = OrderStatus.CREATED;
        Order order = null;

        System.out.println("Добрый день, готовы сделать заказ?");
        char answer = scanner.next().charAt(0);

        if(answer == 'y'){
            boolean flag = true;
            while (flag) {
                int idDish = scanner.nextInt();
                Dish foundDish = menu.dishes.stream().filter(s -> s.ID == idDish).findFirst().orElse(null);;
                
                if(foundDish == null){
                    System.out.println("Такого блюда нет");
                }
                else{
                    dishes.add(foundDish);
                    System.out.println("Что-нибудь ещё?");
                    answer = scanner.next().charAt(0);

                    if(answer == 'n'){
                        order = new Order(dishes, this, dateTime, orderStatus, client);
                        flag = false;
                    }
                }
            }
        }
        else{
            Menu.printMenu();
        }

        scanner.close();
        return order;
  }

  void toKitchen(Order order){

  }

  void getOrderFromKitchen(Order order){

  }
}
