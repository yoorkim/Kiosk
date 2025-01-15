package com.example.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner sc = new Scanner(System.in);
        boolean proceed = true;

        while (proceed) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i+1) + ". " + menuItems.get(i).menu + "\t| W "
                        + menuItems.get(i).price + " | " + menuItems.get(i).menuInfo);
            }
            System.out.println("0. 종료\t\t\t| 종료");

            System.out.print("> 메뉴 선택: ");
            int num = sc.nextInt();

            if (num < 0 || num > menuItems.size()) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.\n");
                continue;
            }

            switch (num) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    proceed = false;
                    break;
                default:
                    System.out.printf("선택한 메뉴: %s | W %.2f | %s\n", menuItems.get(num-1).menu, menuItems.get(num-1).price, menuItems.get(num-1).menuInfo);
                    break;
            }
            System.out.println();
        }

    }
}
