package kiosk.Lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private List<MenuItem> menuItems = new ArrayList<>();

    public Kiosk() {    //Kiosk 메소드에서 menuItems 생성
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9));
        menuItems.add(new MenuItem("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9));
        menuItems.add(new MenuItem("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9));
        menuItems.add(new MenuItem("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (1 == 1) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println(i + ". " + menuItems.get(i).name + "  |  ￦ " + menuItems.get(i).price + "  |  " + menuItems.get(i).content);
            }
            System.out.println("0. 종료");
            int menuChoose = scanner.nextInt();
            if (menuChoose == 0) {
                break;
            } else {
                System.out.println("선택한 메뉴 : " + menuItems.get(menuChoose).name + " " + menuItems.get(menuChoose).price + " " + menuItems.get(menuChoose).content);
            }
        }
    }

    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();  //Kiosk 메서드로 MenuItems 생성 -> 필드에 menuItems add

        kiosk.start();  
    }

}
