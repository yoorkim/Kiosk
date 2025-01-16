package com.example.level6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private static Cart instance;
    private List<CartItem> cartItems = new ArrayList<>();

    public static Cart getInstance() {  // 하나의 인스턴스만 존재하도록
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    // 장바구니 리스트 가져오는 메서드
    public List<CartItem> getCartItems() {
        return cartItems;
    }
    // total 의 자료형 변경 메서드
    public BigDecimal setTotal(double total) {
        // BigDecimal 생성 후 반올림
        return BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP);
    }
    // 장바구니 리스트 변경하는 메서드
    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    // 장바구니에 메뉴 추가하는 메서드
    public void addCartItems(MenuItem menuItem) {
        for (CartItem cart : cartItems) {
            if (menuItem.getMenu().equals(cart.getMenu())) {  // 이미 장바구니에 담겨있는 메뉴라면
                cart.setCount();  // 수량만 증가
                return;
            }
        }
        cartItems.add(new CartItem(menuItem.getMenu(), 1, menuItem.getPrice()));
    }
    // 장바구니 내용 출력하는 메서드
    public void printCartItems(double total) {
        System.out.println("\n[ Orders ]");
        for (CartItem cartItem : cartItems) {
            System.out.printf("%-16s | 수량: %d개 | W %.2f\n",
                    cartItem.getMenu(), cartItem.getCount(), cartItem.getPrice());
        }
        System.out.println("\n[ Total ]");
        System.out.println("W " + setTotal(total) +"\n");  // total 자료형 변경하여 출력
    }
    // 총 금액 계산하는 메서드 (할인 전)
    public double calculateTotal(List<CartItem> cartItems) {
        double total = 0;
        for (CartItem cartItem : cartItems) {
            total += cartItem.getCount() * cartItem.getPrice();  // 총 금액 계산
        }
        return total;
    }
    // 장바구니에서 특정 메뉴 제거하는 메서드
    public void removeCartItemByName(String menuName) {
        cartItems = cartItems.stream()
                .filter(cartItem -> !cartItem.getMenu().equals(menuName))  // menuName 과 동일한 메뉴 제외
                .collect(Collectors.toCollection(ArrayList::new));  // ArrayList 타입으로 저장
    }
    // 장바구니에 담긴 금액을 제한하는 메서드
    public void dropItemsOverLimit(double max) {
        final double[] total = {0};  // 계산 결과 누적할 배열
        cartItems = cartItems.stream()
                .takeWhile(cartItem -> {
                    double newTotal = total[0] + cartItem.getCount() * cartItem.getPrice();
                    if (newTotal > max) {  // 누적된 금액이 20을 초과하면 스트림 종료
                        return false;
                    }
                    total[0] = newTotal;
                    return true;
                })
                .collect(Collectors.toCollection(ArrayList::new));  // ArrayList 타입으로 저장
    }
    // 메뉴가 장바구니에 있는지 확인하는 메서드
    public boolean isMenuInCart(String menuName) {
        boolean exists = false;
        exists = cartItems.stream()
                .anyMatch(cartItem -> menuName.equals(cartItem.getMenu()));
        return exists;
    }
}
