package models;
import enums.DishType;

public class Dish {
    private int ID;
    private String title;
    private String description;
    private double price;
    private int weight;
    // List<Product> products = new ArrayList<>();
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

    public int getID(){return ID;}
    public String getTitle(){return title;}
    public String getDescription(){return description;}
    public double getPrice(){return price;}
    public int getWeight(){return weight;}
    public DishType getDishType(){ return type;}
    public int getCaloricContent(){return caloricContent;}
}
