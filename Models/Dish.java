package models;
import enums.DishType;
import models.interfaces.Discountable;

public class Dish implements Discountable {
    private int ID;
    private String title;
    private String description;
    private double price;
    private int weight;
    private DishType type;
    private int caloricContent;

 

    public Dish(int ID, String title, String description, double price, int weight, DishType type, int caloricContent) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.type = type;
        this.caloricContent = caloricContent;
    }

    @Override
    public double getDiscountedPrice(double discountRate) {
        return price * (1 - discountRate);
    }

    public int getID(){return ID;}
    public String getTitle(){return title;}
    public String getDescription(){return description;}
    public double getPrice(){return price;}
    public int getWeight(){return weight;}
    public DishType getDishType(){ return type;}
    public int getCaloricContent(){return caloricContent;}
}
