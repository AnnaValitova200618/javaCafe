package models;

public class Client {
    private String name;
    private int money;
  
    void payOrder(Order order, int totalPrice){
        if(totalPrice > this.money){
            System.out.println("У вас недостаточно средств");

        }
        else{
            System.out.println("Спасибо за заказ :)");
        }
    }
}
