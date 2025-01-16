package com.example.level6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> categoryMenu = new ArrayList<>();

    // 카테고리 리스트 반환 메서드
    public List<Menu> getCategoryMenu() {
        return categoryMenu;
    }
    // 카테고리 등록 메서드
    public void addCategoryMenu(Menu menu) {
        categoryMenu.add(menu);
    }
    // 키오스크 프로그램 시작 메서드
    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean proceed = true;

        while (proceed) {
            // 상위 카테고리 메뉴 출력
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < categoryMenu.size(); i++) {
                System.out.println((i+1) + ". " + categoryMenu.get(i).getCategory());
            }
            System.out.println("0. 종료\t\t| 종료");

            if (!Cart. getCartItems().isEmpty()) {  // 장바구니에 물건이 들어 있는 경우
                System.out.println();
                System.out.println("[ ORDER MENU ]");
                System.out.println((categoryMenu.size()+1) + ". Orders\t\t| 장바구니를 확인 후 주문합니다.");
                System.out.println((categoryMenu.size()+2) + ". Cancel\t\t| 진행중인 주문을 취소합니다.");
            }

            System.out.print("> 선택: ");
            int categoryNum = sc.nextInt();  // 카테고리 번호 입력

            if (!Cart. getCartItems().isEmpty()) {  // 장바구니에 메뉴가 들어있는 경우
                if (categoryNum < 0 || categoryNum > categoryMenu.size()+2) {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.\n");
                    continue;
                }

            } else {
                if (categoryNum < 0 || categoryNum > categoryMenu.size()) {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.\n");
                    continue;
                }
            }

            if (categoryNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                proceed = false;
            } else if (categoryNum == categoryMenu.size()+1) {  // [ ORDER MENU ] Orders 선택
                System.out.println("\n아래와 같이 주문 하시겠습니까?");
                double total = Cart.calculateTotal(Cart.getCartItems());  // 총 금액 계산
                Cart.printCartItems(total);  // 장바구니 내용 출력

                String menuName = "SmokeShack";  // 삭제할 메뉴 저장
                if (Cart.isMenuInCart(menuName)) {
                    Cart.removeCartItemByName(menuName);  // 장바구니에 "SmokeShack" 들어 있다면 메뉴 제거
                    System.out.println(menuName + "가 제거되었습니다.\n");
                    total = Cart.calculateTotal(Cart.getCartItems());  // 총 금액 다시 계산
                }
                double max = 20;  // 총 금액 제한
                if (total > max) {
                    Cart.dropItemsOverLimit(max);  // 금액 초과되면 장바구니에 담긴 메뉴 삭제
                    System.out.println("예산 초과로 메뉴가 삭제되었습니다.\n");
                    total = Cart.calculateTotal(Cart.getCartItems());  // 총 금액 다시 계산
                }
                System.out.println("- 장바구니 리스트 재출력 -");

                while (true) {
                    try {
                        Cart.printCartItems(total);  // 장바구니 내용 출력
                        System.out.println("1. 주문\t\t\t 2. 메뉴판");
                        int orderNum = sc.nextInt();
                        if(orderNum != 1 && orderNum != 2) {
                            throw new IllegalArgumentException("유효하지 않은 번호 입력. 1 또는 2를 입력해주세요.");
                        }
                        switch (orderNum) {
                            case 1:  // 주문 선택
                                while (true) {
                                    try {
                                        Discount.printDiscountInfo();  // 할인 정보 출력
                                        int userNum = sc.nextInt();
                                        UserType userType = UserType.compare(userNum);  // 유저 타입 확인
                                        Discount.printDiscountedTotal(userType);  // 할인 적용된 금액 출력
                                        Cart.setCartItems(new ArrayList<>());  // 장바구니 초기화
                                    } catch (IllegalArgumentException e) {
                                        System.out.println(e.getMessage());
                                        continue;
                                    }
                                    break;
                                }
                                break;
                            case 2:  // 메뉴판 이동 선택
                                System.out.println("메뉴판으로 이동합니다.");
                                break;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                }
            } else if (categoryNum == categoryMenu.size()+2) {  // [ ORDER MENU ] Cancel 선택
                // 진행중인 주문 취소
                System.out.println("진행중인 주문을 취소합니다.");
                Cart.setCartItems(new ArrayList<>());  // 장바구니 초기화
            } else {  // [ MAIN MENU ] 카테고리 선택
                Menu menu = categoryMenu.get(categoryNum-1);
                boolean proceed2 = true;
                while (proceed2) {
                    menu.printMenuItems();  // 카테고리별 메뉴 출력
                    System.out.print("> 메뉴 선택: ");
                    int menuNum = sc.nextInt();  // 메뉴 번호 입력

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
                            System.out.printf("선택한 메뉴: %s | W %.2f | %s\n", selected.getMenu(), selected.getPrice(), selected.getMenuInfo());

                            while (true) {
                                try {
                                    // 장바구니 추가 선택
                                    System.out.println();
                                    System.out.printf("\"%s | W %.2f | %s\"\n", selected.getMenu(), selected.getPrice(), selected.getMenuInfo());
                                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                                    System.out.println("1. 확인\t\t\t 2. 취소");
                                    int cartNum = sc.nextInt();
                                    if(cartNum != 1 && cartNum != 2) {
                                        throw new IllegalArgumentException("유효하지 않은 번호 입력. 1 또는 2를 입력해주세요.");
                                    }
                                    switch (cartNum) {
                                        case 1:
                                            System.out.println(selected.getMenu() + " 이 장바구니에 추가되었습니다.");
                                            Cart.addCartItems(selected);
                                            break;
                                        case 2:
                                            System.out.println("장바구니 추가가 취소되었습니다.");
                                            break;
                                    }
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                    continue;
                                }
                                break;
                            }
                            break;
                    }
                }
            }
            System.out.println();
        }
    }
}
