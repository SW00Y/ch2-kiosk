package kioskChellenge.Lv1_back.Lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private List<Menu> menus = new ArrayList<>();
    UserCart userCart = new UserCart();
    Scanner scanner = new Scanner(System.in);

    public void addKioskMenu(Menu menu) {
        menus.add(menu);
    }

    public int userInput(int maxSize) {
        while (1 == 1) {
            int menuChoose = 0;
            try {
                menuChoose = scanner.nextInt();
                if (menuChoose > maxSize || menuChoose < 0) {
                    throw new RuntimeException("범위를 벗어난 입력입니다.");
                }
                else if(menuChoose == 0)
                {
                    return -1;
                }
                else {
                    return menuChoose;
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력 : " + e);
                scanner.nextLine();
                return -1;
            }
        }
    }

    public void showMainMenu() {
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        System.out.println("[ SHAKESHACK MENU ]");

        for (int i = 0; i < menus.size(); i++) {
            System.out.println(i+1 + ". " + menus.get(i).getCategoryName());
        }
        if (!userCart.cartIsEmpty()) {
            System.out.println("4. 주문 | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. 취소 | 진행중인 주문을 취소합니다.");
        }
        System.out.println("0. 종료");
    }

    public void start() {
        int menuChoose = 0;
        while (1 == 1) {
            showMainMenu();
            if (userCart.cartIsEmpty()) {
                menuChoose = userInput(menus.size());
            } else {
                menuChoose = userInput((menus.size() + 2));
            }
            switch (menuChoose) {
                case -1, 0:
                    return;
                case 4:
                    userCart.showCart();
                    break;
                case 5:
                    userCart.removeCart();
                    break;
                default:
                    userOrder(menuChoose);
            }

        }
    }

    public void userOrder(int menuChoose) {
        menuChoose = menuChoose - 1;
        List<MenuItem> itemList = menus.get(menuChoose).getMenuItems();

        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(i + 1 + ". " + itemList.get(i).getMenuFullName());
        }

        System.out.println("0. 뒤로가기");
        menuChoose = userInput(itemList.size());

        if(menuChoose == -1)
        {
            return;
        }

        System.out.println(itemList.get(menuChoose).getMenuFullName());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인    2. 취소");

        menuChoose = userInput(2);
        try {
            switch (menuChoose){
                case 1 :
                    userCart.addCart(itemList.get(menuChoose));
                    break;
                case 2 :
                    System.out.println("취소하였습니다.");
                    break;
                default:
                    throw new RuntimeException();
            }
        }
        catch (Exception e)
        {
            System.out.println("잘못된 입력 : " + e);
        }
    }
}

