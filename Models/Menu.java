package models;
import enums.DishType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Menu {
    private List<Dish> dishes = new ArrayList<>();

    public Menu(List<Dish> dishes){
        this.dishes = dishes;
        loadMenuFromCSV();
    }
    public List<Dish> getDishes(){return dishes;}
    
    private void loadMenuFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader("static/menu.csv"))) {
            String line;
            boolean firstLine = true;
            
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                
                String[] values = line.split(",");
                if (values.length >= 7) {
                    try {
                        Dish dish = new Dish(
                            Integer.parseInt(values[0].trim()),
                            values[1].trim(),
                            values[2].trim(),
                            Double.parseDouble(values[3].trim()),
                            Integer.parseInt(values[4].trim()),
                            DishType.valueOf(values[5].trim()),
                            Integer.parseInt(values[6].trim())
                        );
                        dishes.add(dish); 
                    } catch (Exception e) {
                        System.out.println("Ошибка в строке: " + line);
                    }
                }
            }
            
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public void printMenu(){
        System.out.println("\n==================================================");
        System.out.println("          МЕНЮ РЕСТОРАНА 'БУЛЬ-БУХ'");
        System.out.println("==================================================");
        
        for (DishType type : DishType.values()) {
            List<Dish> categoryDishes = dishes.stream()
                .filter(d -> d.getDishType() == type)
                .collect(Collectors.toList());
            
            if (!categoryDishes.isEmpty()) {
                printDetailedCategory(categoryDishes, type);
            }
        }
    }
    
    private static void printDetailedCategory(List<Dish> dishes, DishType type) {
        String name = getCategoryName(type);
        
        System.out.println("\n*** " + name + " ***");
        System.out.println("--------------------------------------------------");
        
        for (Dish dish : dishes) {
            System.out.printf("#%-2d %-20s %5.0f руб%n", dish.getID(), dish.getTitle(), dish.getPrice());
            System.out.println("   " + dish.getDescription());
            System.out.printf("   Вес: %dг | Калории: %d%n%n", dish.getWeight(), dish.getCaloricContent());
        }
    }
    
    private static String getCategoryName(DishType type) {
        switch (type) {
            case SOUP: return "Супы";
            case MAIN: return "Основные блюда";
            case DESSERT: return "Десерты";
            case DRINK: return "Напитки";
            case CHILDREN: return "Детское меню";
            default: return "Другое";
        }
    }
}