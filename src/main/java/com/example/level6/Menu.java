package com.example.level6;

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
        System.out.println();
        System.out.println("[ " + category.toUpperCase() + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            String menu = String.format("%-16s", menuItems.get(i).getMenu());  // 문자열 간격 맞추기
            System.out.printf("%d. %s| W %.2f | %s\n", i+1, menu, menuItems.get(i).getPrice(), menuItems.get(i).getPrice());
        }
        System.out.println("0. 뒤로가기");
    }
}
