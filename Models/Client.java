package models;

public class Client {
    private String name;
    private int money;
  
    public Client(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void payOrder(int totalPrice){
        if(totalPrice > this.money){
            System.out.println("У вас недостаточно средств, что делать будем?)");
        }
        else{
            System.out.println("Спасибо за заказ :)");
        }
    }
}
