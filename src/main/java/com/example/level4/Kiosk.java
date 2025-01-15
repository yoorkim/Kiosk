package com.example.level4;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<Menu> categoryMenu;

    public Kiosk(List<Menu> categoryMenu) {
        this.categoryMenu = categoryMenu;
    }

    // 키오스크 프로그램 시작 메서드
    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean proceed = true;
        Menu menu;

        while (proceed) {
            // 상위 카테고리 메뉴 출력
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < categoryMenu.size(); i++) {
                System.out.println((i+1) + ". " + categoryMenu.get(i).getCategory());
            }
            System.out.println("0. 종료\t\t| 종료");

            System.out.print("> 카테고리 선택: ");
            int categoryNum = sc.nextInt();

            if (categoryNum < 0 || categoryNum > categoryMenu.size()) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.\n");
                continue;
            }

            switch (categoryNum) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    proceed = false;
                    break;
                default:
                    menu = categoryMenu.get(categoryNum-1);
                    boolean proceed2 = true;
                    while (proceed2) {
                        // 카테고리별 메뉴 출력
                        System.out.println();
                        System.out.println("[ " + menu.getCategory().toUpperCase() + " MENU ]");
                        menu.printMenuItems();  // 카테고리에 맞는 메뉴 리스트 출력
                        System.out.println("0. 뒤로가기");
                        System.out.print("> 메뉴 선택: ");
                        int menuNum = sc.nextInt();

                        if (menuNum < 0 || menuNum > menu.getMenuItems().size()) {
                            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                            continue;
                        }

                        switch (menuNum) {
                            case 0:
                                System.out.println("뒤로가기 -> MAIN MENU로 이동합니다.");
                                proceed2 = false;
                                break;
                            default:
                                MenuItem selected = menu.getMenuItems().get(menuNum-1);  // 선택한 메뉴 저장
                                // 선택한 메뉴 정보 출력
                                System.out.printf("선택한 메뉴: %s | W %.2f | %s\n", selected.menu, selected.price, selected.menuInfo);
                                break;
                        }
                    }
                    break;
            }
            System.out.println();
        }
    }
}
