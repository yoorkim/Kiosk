package com.example.level6;

public enum UserType {
    VETERAN(1, 0.1),
    SOLDIER(2, 0.05),
    STUDENT(3, 0.03),
    GENERAL(4, 0);

    private final int num;
    private final double discountRate;

    UserType(int num, double discountRate) {
        this.num = num;
        this.discountRate = discountRate;
    }

    public int getNum() {
        return num;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public static UserType compare(int num) {
        for (UserType userType : UserType.values()) {
            if (userType.getNum() == num) {
                return userType;
            }
        }
        throw new IllegalArgumentException("잘못된 입력입니다. 다시 입력해주세요.");
    }
}
