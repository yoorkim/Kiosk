package com.example.level6;

public class MenuItem {
    private String menu;
    private double price;
    private String menuInfo;

    public MenuItem(String menu, double price, String menuInfo) {
        this.menu = menu;
        this.price = price;
        this.menuInfo = menuInfo;
    }

    public String getMenu() {
        return menu;
    }

    public double getPrice() {
        return price;
    }

    public String getMenuInfo() {
        return menuInfo;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMenuInfo(String menuInfo) {
        this.menuInfo = menuInfo;
    }
}
