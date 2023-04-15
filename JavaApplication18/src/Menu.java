/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author khact
 */
public class Menu {
     private Inventory inventory;

    public Menu(Inventory inventory) {
        this.inventory = inventory;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("=== QUẢN LÝ KHO QUẦN ÁO ===");
            System.out.println("1. THÊM SẢN PHẨM VÀO KHO");  
            System.out.println("2. XÓA SẢN PHẨM");
            System.out.println("3. CẬP NHẬT SỐ LƯỢNG SẢN PHẨM");
            System.out.println("4. CẬP NHẬT GIÁ SẢN PHẨM");
            System.out.println("5. SẮP XẾP SẢN PHẨM THEO GIÁ");
            System.out.println("6. SẮP XẾP SẢN PHẨM THEO TÊN");
            System.out.println("7. TẢI LÊN DANH SÁCH SẢN PHẨM TỪ FILE");
            System.out.println("8. LƯU DANH SÁCH SẢN PHẨM VÀO FILE");
            System.out.println("0. THOÁT");
            System.out.print("MỜI NHẬP LỰA CHỌN: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    updateItemQuantity();
                    break;
                case 4:
                    updateItemPrice();
                    break;
                case 5:
                    sortItemsByPrice();
                    break;
                case 6:
                    searchItemsByName();
                    break;
                case 7:
                    loadItemsFromFile();
                    break;
                case 8:
                    saveItemsToFile();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("LỰA CHỌN KHÔNG HỢP LỆ.");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }

    private void addItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("NHẬP ID SẢN PHẨM: ");
        String id = scanner.nextLine();
        System.out.print("NHẬP TÊN SẢN PHẨM: ");
        String name = scanner.nextLine();
        System.out.print("NHẬP SỐ LƯỢNG SẢN PHẨM: ");
        int quantity = scanner.nextInt();
        System.out.print("NHẬP GIÁ SẢN PHẨM: ");
        double price = scanner.nextDouble();
        System.out.print("NHẬP NHÀ CUNG CẤP: ");
        String suplier = scanner.nextLine();
        scanner.nextLine();
        Item item = new Item(id, name, quantity, price,suplier);
        inventory.addItem(item);
        System.out.println("THÊM SẢN PHẨM THÀNH CÔNG.");
    }

    private void removeItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("NHẬP ID SẢN PHẨM: ");
        String id = scanner.nextLine();
        Item item = inventory.findItemById(id);
        if (item != null) {
            inventory.removeItem(item);
            System.out.println("XÓA SẢN PHẨM THÀNH CÔNG.");
        } else {
            System.out.println("SẢN PHẨM KHÔNG TỒN TẠI.");
        }
    }

    private void updateItemQuantity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("NHẬP MÃ SẢN PHẨM: ");
        String id = scanner.nextLine();
        System.out.print("NHẬP SỐ LƯỢNG: ");
        int newQuantity = scanner.nextInt();
        scanner.nextLine();
        inventory.updateItemQuantity(id, newQuantity);
        System.out.println("CẬP NHẬT SỐ LƯỢNG SẢN PHẨM THÀNH CÔNG.");
    }

    private void updateItemPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("NHẬP MÃ SẢN PHẨM: ");
        String id = scanner.nextLine();
        System.out.print("NHẬP GIÁ SẢN PHẨM: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();
        inventory.updateItemPrice(id, newPrice);
        System.out.println("CẬP NHẬT GIÁ SẢN PHẨM THÀNH CÔNG.");
    }
private void sortItemsByPrice() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("NHẬP 'asc' ĐÊ SẮP XẾP THEO THỨ TỰ TĂNG DẦN HOẶC NHẬP 'desc' ĐỂ SẮP XẾP GIẢM DẦN: ");
    String sortOrder = scanner.nextLine();
    inventory.sortItemsByPrice(true);
    System.out.println("Items sorted by price.");
}

private void searchItemsByName() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("NHẬP TÊN SẢN PHẨM: ");
    String name = scanner.nextLine();
         ArrayList<Item> items = inventory.searchItemsByName(name);
    if (items.size() == 0) {
        System.out.println("TÊN SẢN PHẨM KHÔNG TỒN TẠI.");
    } else {
        System.out.println("DANH SÁCH SẢN PHẨM:");
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
private void loadItemsFromFile() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("NHẬP ĐƯỜNG DẪN TỚI FILE: ");
    String filePath = scanner.nextLine();
    boolean success = inventory.loadItemsFromFile(filePath);
    if (success) {
        System.out.println("DANH SÁCH SẢN PHẨM TỪ FILE.");
    } else {
        System.out.println("TẢI KHÔNG THÀNH CÔNG.");
    }
}
private void saveItemsToFile() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("NHẬP ĐƯỜNG DẪN TỜI FILE: ");
    String filePath = scanner.nextLine();
    boolean success = inventory.saveItemsToFile(filePath);
    if (success) {
        System.out.println("LƯU DANH SÁCH SẢN PHẨM THÀNH CÔNG.");
    } else {
        System.out.println("TẢI THẤT BẠI.");
    }
}

    
    
}
