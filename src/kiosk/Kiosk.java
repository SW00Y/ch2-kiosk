package kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private List<Menu> menus = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Kiosk() {

    }

    public void addKioskMenu(Menu menu){
        menus.add(menu);
    }

    public void start() {
        int menuChoose;

        while (1 == 1) {
            System.out.println("[ SHAKESHACK MENU ]");

            for(int i=0; i<menus.size(); i++)
            {
                System.out.println(i+1 + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료");
            menuChoose = scanner.nextInt();
            if (menuChoose == 0) {
                break;
            } else {
                menuChoose = menuChoose - 1;
                List<MenuItem> itemList = menus.get(menuChoose).getMenuItems();
                for(int i=0; i<itemList.size(); i++ )
                {
                     System.out.println(i+1 + ". " + itemList.get(i).name + " | ₩ " + itemList.get(i).price + " | " + itemList.get(i).content + " | ");
                 }
                System.out.println("0. 뒤로가기");
                menuChoose = scanner.nextInt();
                if (menuChoose == 0) {
                    continue;
                }
                else{
                    menuChoose = menuChoose - 1;
                    System.out.println("선택한 메뉴 : " + itemList.get(menuChoose).name + " | ₩" + itemList.get(menuChoose).price + " | " + itemList.get(menuChoose).content);
                }
            }
        }
    }

}
