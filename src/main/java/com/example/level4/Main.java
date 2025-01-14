package com.example.level4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 버거 Menu 객체 생성
        Menu burgers = new Menu("Burgers",
                new ArrayList<>() {{
                    add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
                    add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
                    add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
                    add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
                }}
        );
        // 음료 Menu 객체 생성
        Menu drinks = new Menu("Drinks",
                new ArrayList<>() {{
                    add(new MenuItem("Cola", 2.9, "코카콜라/코카콜라 제로"));
                    add(new MenuItem("Iced Tea", 3.7, "유기농 홍차를 우려낸 아이스 티"));
                    add(new MenuItem("Lemonade", 5.0, "시즌마다 달라지는 스페셜 레몬에이드"));
                    add(new MenuItem("Shake", 6.8, "쫀득하고 진한 커스터드가 들어간 클래식 쉐이크"));
                }}
        );
        // 디저트 Menu 객체 생성
        Menu desserts = new Menu("Desserts",
                new ArrayList<>() {{
                    add(new MenuItem("Frozen Custard", 5.7, "쫀득하고 진한 아이스크림"));
                    add(new MenuItem("Shack Attack", 5.9, "세 가지 초콜릿 토핑이 블렌딩된 대표 콘크리트"));
                }}
        );
        // Kiosk 객체 생성 및 초기화
        Kiosk kiosk = new Kiosk(
                new ArrayList<>() {{
                    add(burgers);
                    add(drinks);
                    add(desserts);
                }}
        );
        kiosk.start();
    }
}
