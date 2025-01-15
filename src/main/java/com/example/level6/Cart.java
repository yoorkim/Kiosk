package com.example.level6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();
    private double total;

    // 장바구니 리스트 가져오는 메서드
    public List<CartItem> getCartItems() {
        return cartItems;
    }
    // 총 금액을 가져오는 메서드
    public double getTotal() {
        return total;
    }
    // total 의 자료형 변경 메서드
    public BigDecimal setTotal() {
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
    public void printCartItems() {
        total = 0;
        System.out.println("[ Orders ]");
        for (CartItem cartItem : cartItems) {
            System.out.printf("%-16s | 수량: %d개 | W %.2f\n",
                    cartItem.getMenu(), cartItem.getCount(), cartItem.getPrice());
            total += cartItem.getCount() * cartItem.getPrice();
        }
        System.out.println("\n[ Total ]");
        System.out.println("W " + setTotal());
    }
}
