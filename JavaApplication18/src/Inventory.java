/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author khact
 */
public class Inventory {

    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

//    public void removeItem(Item item) {
//        items.remove(item);
//    }
    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public Item findItemById(String itemId) {
        for (Item item : items) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }
        System.out.println("Item not found.");
        return null;
    }

    public void updateItemQuantity(String itemId, int newQuantity) {
        for (Item item : items) {
            if (item.getId().equals(itemId)) {
                item.setQuantity(newQuantity);
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public void updateItemPrice(String itemId, double newPrice) {
        for (Item item : items) {
            if (item.getId().equals(itemId)) {
                item.setPrice(newPrice);
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public void sortItemsByPrice(boolean ascending) {
        Comparator<Item> priceComparator = new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                if (item1.getPrice() < item2.getPrice()) {
                    return -1;
                } else if (item1.getPrice() > item2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        if (ascending) {
            Collections.sort(items, priceComparator);
        } else {
            Collections.sort(items, Collections.reverseOrder(priceComparator));
        }
    }

    public ArrayList<Item> searchItemsByName(String name) {
        ArrayList<Item> matchingItems = new ArrayList<Item>();
        for (Item item : items) {
            if (item.getName().contains(name)) {
                matchingItems.add(item);
            }
        }
        return matchingItems;
    }

//    public void loadItemsFromFile(String filename) {
//        try {
//            Scanner scanner = new Scanner(new File(filename));
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] parts = line.split(",");
//                String id = parts[0];
//                String name = parts[1];
//                int quantity = Integer.parseInt(parts[2]);
//                double price = Double.parseDouble(parts[3]);
//                Item item = new Item(id, name, quantity, price);
//                addItem(item);
//            }
//            scanner.close();
//            System.out.println("Items loaded from file.");
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found.");
//        }
//    }
    public boolean loadItemsFromFile(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                if (fields.length != 4) {
                    System.out.println("Invalid line: " + line);
                    continue;
                }
                String id = fields[0];
                String name = fields[1];
                int quantity = Integer.parseInt(fields[2]);
                double price = Double.parseDouble(fields[3]);
                String suplier = fields[4];
                Item item = new Item(id, name, quantity, price,suplier);
                this.items.add(item);
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            return false;
        } catch (Exception e) {
            System.out.println("Failed to load items from file: " + filePath);
            return false;
        }
    }

//    public void saveItemsToFile(String filename) {
//        try {
//            PrintWriter writer = new PrintWriter(new File(filename));
//            for (Item item : items) {
//                String line = item.getId() + "," + item.getName() + "," + item.getQuantity() + "," + item.getPrice();
//                writer.println(line);
//            }
//            writer.close();
//            System.out.println("Items saved to file.");
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found.");
//        }
//    }
    public boolean saveItemsToFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            for (Item item : this.items) {
                writer.println(item.getId() + "," + item.getName() + "," + item.getQuantity() + "," + item.getPrice());
            }
            return true;
        } catch (Exception e) {
            System.out.println("Failed to save items to file: " + filePath);
            return false;
        }
    }

}
