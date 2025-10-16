package Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.io.*;
import java.util.*;

public class Menu {
    static List<Dish> dishes = new ArrayList<>();

    public Menu(List<Dish> dishes){
        loadMenuFromCSV("static/menu.csv");
    }

    private void loadMenuFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader("static/menu.csv"))) {
            String line;
            boolean firstLine = true;
            
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                
                // Простой парсинг - убрали запятые из описаний в CSV
                String[] values = line.split(",");
                if (values.length >= 7) {
                    try {
                        Dish dish = new Dish(
                            Integer.parseInt(values[0].trim()),
                            values[1].trim(),
                            values[2].trim(),
                            Double.parseDouble(values[3].trim()),
                            Integer.parseInt(values[4].trim()),
                            Dish.DishType.valueOf(values[5].trim()),
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

    public static void printMenu(){
        System.out.println("\n==================================================");
        System.out.println("          МЕНЮ РЕСТОРАНА 'ВКУСНО И ТОЧКА'");
        System.out.println("==================================================");
        
        for (Dish.DishType type : Dish.DishType.values()) {
            List<Dish> categoryDishes = dishes.stream()
                .filter(d -> d.type == type)
                .collect(Collectors.toList());
            
            if (!categoryDishes.isEmpty()) {
                printDetailedCategory(categoryDishes, type);
            }
        }
    }
    
    private static void printDetailedCategory(List<Dish> dishes, Dish.DishType type) {
        String name = getCategoryName(type);
        
        System.out.println("\n*** " + name + " ***");
        System.out.println("--------------------------------------------------");
        
        for (Dish dish : dishes) {
            System.out.printf("#%-2d %-20s %5.0f руб%n", dish.ID, dish.title, dish.price);
            System.out.println("   " + dish.description);
            System.out.printf("   Вес: %dг | Калории: %d%n%n", dish.weight, dish.caloricContent);
        }
    }
    
    private static String getCategoryName(Dish.DishType type) {
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