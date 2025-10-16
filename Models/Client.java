package Models;

public class Client {
    String name;
    int money;
  
    void payOrder(Order order, int totalPrice){
        if(totalPrice > this.money){
            System.out.println("У вас недостаточно средств");

        }
        else{
            System.out.println("Спасибо за заказ :)");
        }
    }
}
