package kioskChellenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private List<Menu> menus = new ArrayList<>();
    UserCart userCart = new UserCart();
    Scanner scanner = new Scanner(System.in);

    public void addKioskMenu(Menu menu){
        menus.add(menu);
    }

    public void start() {
        int menuChoose = 0;

        while (1 == 1) {
            int menusSize = menus.size();
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
            System.out.println("[ SHAKESHACK MENU ]");

            for(int i=0; i<menusSize; i++)
            {
                System.out.println(i+1 + ". " + menus.get(i).getCategoryName());
            }
            if(!userCart.cartIsEmpty())
            {
                menusSize = menusSize + 2;
                System.out.println("4. 주문 | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. 취소 | 진행중인 주문을 취소합니다.");
            }
            System.out.println("0. 종료");

            try{
                menuChoose = scanner.nextInt();
                if(menuChoose > menusSize || menuChoose < 0)
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
            else if (menuChoose == 4)
            {
                System.out.println("아래와 같이 주문하시겠습니까?");
                userCart.showCart();

            }
            else if(menuChoose== 5)
            {
                System.out.println("장바구니를 비웁니다.");
            }
            else {
                menuChoose = menuChoose - 1;
                List<MenuItem> itemList = menus.get(menuChoose).getMenuItems();

                for(int i=0; i<itemList.size(); i++ )
                {
                    System.out.println(i+1 + ". " + itemList.get(i).getMenuFullName());
                }

                System.out.println("0. 뒤로가기");

                try {
                    menuChoose = scanner.nextInt();
                    if(menuChoose > itemList.size() || menuChoose < 0)
                    {
                        System.out.println(itemList.size());
                        throw new RuntimeException("범위를 벗어난 입력입니다.");
                    }
                }
                catch (Exception e){
                    System.out.println("잘못된 입력 : " + e);
                    continue;
                }
                scanner.nextLine();
                if (menuChoose == 0) {
                    continue;
                }

                else{
                    menuChoose = menuChoose - 1;
                    System.out.println(itemList.get(menuChoose).getMenuFullName());
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인    2. 취소");
                    menuChoose = scanner.nextInt();
                    try {
                        if(menuChoose > 2 || menuChoose < 0)
                        {
                            throw new RuntimeException("범위를 벗어난 입력입니다.");
                        }
                        menuChoose = scanner.nextInt();
                    }catch (Exception e){
                        System.out.println("잘못된 입력 : " + e);
                    }
                    userCart.addCart(itemList.get(menuChoose));
                }
            }
        }
    }

}
