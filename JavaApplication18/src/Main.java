/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        menu.display();
    }
}

