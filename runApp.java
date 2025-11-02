import java.util.ArrayList;
import java.util.List;

import models.Dish;
import models.Menu;

public class runApp {
    public static void main(String[] args){
        List<Dish> dishes = new ArrayList<>();
        Menu menu = new Menu(dishes);
        menu.printMenu();//
    }
}
