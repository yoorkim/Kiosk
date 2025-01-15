package com.example.level6;

public class CartItem {
    private String menu;
    private int count;
    private double price;

    public CartItem(String menu, int count, double price) {
        this.menu = menu;
        this.count = count;
        this.price = price;
    }

    public String getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void setCount() {  // 수량 1 증가
        this.count += 1;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
