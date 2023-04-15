/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */
public class Item {
        private String id;
    private String name;
    private int quantity;
    private double price;
    private String suplier;

    public Item(String id, String name, int quantity, double price,String suplier) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.suplier=suplier;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSuplier() {
        return suplier;
    }

    public void setSuplier(String suplier) {
        this.suplier = suplier;
    }
    

    public double getTotalValue() {
        return quantity * price;
    }
    
}
