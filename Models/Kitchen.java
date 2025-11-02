package models;

import java.util.List;

import enums.OrderStatus;

public class Kitchen {
    
    private List<Order> orders;
  
    public Kitchen(List<Order> orders){
        this.orders = orders;
    }
    public void toCook(Order order){
        if(order.getStatus() != OrderStatus.PENDING){
            System.out.println("возникла проблема с блюдом");
            return;
        }
        System.out.println("Статус заказа - в работе");
        order.setStatus(OrderStatus.IN_WORK);
    }
}
