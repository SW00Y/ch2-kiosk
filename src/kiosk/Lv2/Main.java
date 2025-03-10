package kiosk.Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9));
        menuItems.add(new MenuItem("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9));
        menuItems.add(new MenuItem("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9));
        menuItems.add(new MenuItem("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4));

        Scanner scanner = new Scanner(System.in);


        System.out.println("[ SHAKESHACK MENU ]");
        for(int i=0;i<menuItems.size();i++)
        {
            System.out.println(i + ". " + menuItems.get(i).name + "  |  ￦ " + menuItems.get(i).price + "  |  " + menuItems.get(i).content);
        }
        System.out.println("0. 종료");

        int menuChoose = scanner.nextInt();

        System.out.println(menuItems.get(menuChoose).name + " " + menuItems.get(menuChoose).price + " " + menuItems.get(menuChoose).content);


    }


}
