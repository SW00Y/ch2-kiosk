package kiosk;

import java.util.Scanner;

public class Kiosk {

    private Menu burgerMenu;
    Scanner scanner = new Scanner(System.in);

    public Kiosk(Menu burgerMenu) {
        this.burgerMenu = burgerMenu;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);


        while (1 == 1) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < burgerMenu.getMenuItems().size(); i++) {
                System.out.println(i + ". " + burgerMenu.getMenuItems().get(i).name + "  |  ￦ " + burgerMenu.getMenuItems().get(i).price + "  |  " + burgerMenu.getMenuItems().get(i).content);
            }
            System.out.println("0. 종료");
            int menuChoose = scanner.nextInt();
            if (menuChoose == 0) {
                break;
            } else {
//                System.out.println("선택한 메뉴 : " + menu.menuItems.get(menuChoose).name + " " + menu.menuItems.get(menuChoose).price + " " + menu.menuItems.get(menuChoose).content);
            }
        }
    }

}
