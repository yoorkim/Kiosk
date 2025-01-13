package com.example.level3;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItems;  // MenuItem을 관리하는 리스트

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    // 키오스크 프로그램 시작 메서드
    public void start() {
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

            if(num < 0 || num > menuItems.size()) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.\n");
                continue;
            }

            switch (num) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    proceed = false;
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.println("선택한 메뉴: " + menuItems.get(num-1).menu + "\t| W "
                            + menuItems.get(num-1).price + " | " + menuItems.get(num-1).menuInfo);
                    break;
            }
            System.out.println();
        }
    }
}
