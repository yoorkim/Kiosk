package com.example.level5;

import java.util.List;

public class Menu {
    private String category;
    private final List<MenuItem> menuItems;

    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    // 메뉴 카테고리 이름 반환 메서드
    public String getCategory() {
        return category;
    }
    // MenuItem List를 반환하는 메서드
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    // 카테고리 이름 변경 메서드
    public void setCategory(String category) {
        this.category = category;
    }
    // List에 들어있는 MenuItem을 순차적으로 보여주는 메서드
    public void printMenuItems() {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d. %-16s| W %.2f | %s\n", i+1, menuItems.get(i).getMenu(), menuItems.get(i).getPrice(), menuItems.get(i).getPrice());
        }
    }
}
