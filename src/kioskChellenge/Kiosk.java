package kioskChellenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private List<Menu> menus = new ArrayList<>();
    private UserCart userCart;
    Scanner scanner = new Scanner(System.in);

    public void addKioskMenu(Menu menu){
        menus.add(menu);
    }

    public void start() {
        int menuChoose = 0;

        while (1 == 1) {
            System.out.println("[ SHAKESHACK MENU ]");

            for(int i=0; i<menus.size(); i++)
            {
                System.out.println(i+1 + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료");

            try{
                menuChoose = scanner.nextInt();
                if(menuChoose > menus.size() || menuChoose < 0)
                {
                    throw new RuntimeException("범위를 벗어난 입력입니다.");
                }
            }
            catch (Exception e){
                System.out.println("잘못된 입력 : " + e);
                scanner.nextLine();
                continue;
            }

            if (menuChoose == 0) {
                break;
            }

            else {
                menuChoose = menuChoose - 1;
                List<MenuItem> itemList = menus.get(menuChoose).getMenuItems();

                for(int i=0; i<itemList.size(); i++ )
                {
                     System.out.println(i+1 + ". " + itemList.get(i).name + " | ₩ " + itemList.get(i).price + " | " + itemList.get(i).content + " | ");
                }

                System.out.println("0. 뒤로가기");

                try {
                    menuChoose = scanner.nextInt();
                    if(menuChoose > itemList.size() || menuChoose < 0)
                    {
                        throw new RuntimeException("범위를 벗어난 입력입니다.");
                    }
                }
                catch (Exception e){
                    System.out.println("잘못된 입력 : " + e);
                    scanner.nextLine();
                    continue;
                }

                if (menuChoose == 0) {
                    continue;
                }

                else{
                    menuChoose = menuChoose - 1;
                    userCart.addCart(itemList.get(menuChoose));
                    userCart.showCart();
                }
            }
        }
    }

}
