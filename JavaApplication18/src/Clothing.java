/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */
public class Clothing extends Item {
        private String size;
    private String material;

    public Clothing(String id, String name, int quantity, double price,String suplier, String size, String material) {
        super(id, name, quantity, price,suplier);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public double getTotalValue() {
        // Override phương thức tính tổng giá trị hàng hóa để tính cả giá trị của quần áo
        return super.getTotalValue() * 1.2;
    }
}
