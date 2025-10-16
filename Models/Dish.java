package Models;

import java.util.ArrayList;
import java.util.List;


public class Dish {
    int ID;
    String title;
    String description;
    double price;
    int weight;
    // List<Product> products = new ArrayList<>();
    DishType type;
    int caloricContent;

    public enum DishType {
        CHILDREN,
        DRINK,
        DESSERT,
        SOUP,
        MAIN
    }

    public Dish(int ID, String title, String description, double price, int weight, DishType type, int caloricContent) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.type = type;
        this.caloricContent = caloricContent;
    }
}
