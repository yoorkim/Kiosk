package com.example.level6;

public class Discount {

    // 할인 정보를 출력하는 메서드
    public static void printDiscountInfo() {
        System.out.println("\n할인 정보를 입력해주세요.");
        for (UserType userType : UserType.values()) {
            System.out.printf("%d. %s\t : %d%%\n", userType.getNum(), userType.name(), (int)(userType.getDiscountRate() * 100));
        }
    }
    // 할인율 적용된 총 금액 계산하여 출력하는 메서드
    public static void printDiscountedTotal(UserType userType) {
        double discountedTotal = 0;
        for (CartItem cartItem : Cart.getCartItems()) {
            discountedTotal += cartItem.getCount() * cartItem.getPrice() * (1 - userType.getDiscountRate());
        }
        System.out.printf("\n주문이 완료되었습니다. 금액은 W %s 입니다.\n", Cart.setTotal(discountedTotal));
    }
}
