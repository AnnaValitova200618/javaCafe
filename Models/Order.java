package models;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import enums.OrderStatus;
import models.employees.Waiter;

public class Order {
    private List<Dish> dishes = new ArrayList<>();
    private Waiter waiter;
    private ZonedDateTime datetime;
    private OrderStatus status;
    private Client client;
  
     public Order(List<Dish> dishes, Waiter waiter, Client client) {
        this.dishes = dishes;
        this.waiter = waiter;
        this.client = client;
        this.datetime = ZonedDateTime.now();
        this.status = OrderStatus.CREATED;
    }

    public int getTotalPrice(){
        int totalPrice = 0;

        for (Dish dish : this.dishes){
            totalPrice += dish.getPrice();
        }

        return totalPrice;
    }

    public OrderStatus getStatus(){return status;}

    public void setStatus(OrderStatus status){
        status = OrderStatus.PENDING;
    }
}
