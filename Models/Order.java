package Models;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Dish> dishes = new ArrayList<>();
    Worker waiter;
    ZonedDateTime datetime;
    OrderStatus status;
    Client client;
  
    public enum OrderStatus{
        CREATED,
        PENDING,
        IN_WORK,
        DONE
    }

    public Order(List<Dish> dishes, Worker waiter, ZonedDateTime datetime, 
    OrderStatus status, Client client) {
        this.dishes = dishes;
        this.waiter = waiter;
        this.datetime = datetime;
        this.status = status;
        this.client = client;
    }

    int getTotalPrice(){
        int totalPrice = 0;

        for (Dish dish : this.dishes){
            totalPrice += dish.price;
        }

        return totalPrice;
    }

    void setStatus(OrderStatus status){
        status = OrderStatus.PENDING;
    }
}
