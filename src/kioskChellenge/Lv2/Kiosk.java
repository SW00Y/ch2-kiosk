package kioskChellenge.Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Kiosk {

    private List<Menu> menus = new ArrayList<>();
    UserCart userCart = new UserCart();
    boolean result = false;
    Scanner scanner = new Scanner(System.in);

    public void addKioskMenu(Menu menu) {
        menus.add(menu);
    }

    public void showMainMenu() {
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        System.out.println("[ SHAKESHACK MENU ]");

        for (int i = 0; i < menus.size(); i++) {
            System.out.println(i + 1 + ". " + menus.get(i).getCategoryName());
        }
        if (!userCart.cartIsEmpty()) {
            System.out.println("4. 주문 | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. 취소 | 진행중인 주문을 취소합니다.");
        }
        System.out.println("0. 종료");
    }

    public void showSubMenu(int menuChoose){
        List<MenuItem> itemList = menus.get(menuChoose).getMenuItems();


//        for (int i=0; i<itemList.size(); i++)
//        {
//            System.out.println(i + 1 + ". " + itemList.get(i).getMenuFullName());
//        }
        menus.get(menuChoose).printMenuItems(); //Stream을 사용하여 출력하기
        System.out.println("0. 뒤로가기");


        menuChoose = userInput(itemList.size());

        if(menuChoose == -1)
        {
            System.out.println("메인메뉴로 돌아갑니다.");
            return;
        }

        addCart(itemList.get(menuChoose-1));
    }

    public int userInput(int maxSize) {

        int inputNum;

        while (true) {
            try {
                System.out.print("메뉴 선택: ");
                inputNum = Integer.parseInt(scanner.nextLine().trim()); // 문자열 입력 방지

                if (inputNum == 0) {
                    return -1;
                }
                else if (inputNum > 0 && inputNum <= maxSize) {
                    return inputNum;
                }
                else {
                    System.out.println("입력값의 범위를 벗어났습니다. 다시 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }

    public void addCart(MenuItem menuItem){

        System.out.println("선택한 메뉴 : " + menuItem.getMenuFullName());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인   2. 취소");

        int userOption = userInput(2);

        if (userOption == 1)
        {
            userCart.addCart(menuItem);
        }
    }

    public boolean showCart(){
        List<CartItem> cartList = userCart.getCartItems();
        double totalPrice = 0;
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println("[ Orders ]");
        for(int i=0; i<cartList.size(); i++){
            System.out.println(cartList.get(i).getCartItemFullName());
            totalPrice = totalPrice + cartList.get(i).getCartItemPrice();
        }
        totalPrice = Math.floor(totalPrice*100) / 100.0;
        System.out.println("[ Total ]");
        System.out.println("￦ " + totalPrice);
        System.out.println("1. 주문    2. 메뉴삭제    3. 메뉴판");

        int userOption = userInput(3);

        if(userOption == 1)
        {
            System.out.println("할인 정보를 입력해주세요.");
            System.out.println("1. 국가유공자 : 10%\n2. 군인 : 5%\n3. 학생 : 3%\n4. 일반 : 0%");
            userOption = userInput(4);

            totalPrice = OrderDiscount.doDiscount(userOption, totalPrice);
            System.out.println("주문이 완료되었습니다. 금액은 : ￦" + totalPrice + " 입니다.");
            return true;
        }
        else if (userOption == 2)
        {
            System.out.println("========현재 장바구니========");
            for(int i=0; i<cartList.size(); i++){
                System.out.println(i+1 + ". " + cartList.get(i).getCartItemFullName());
            }

            userOption = userInput(cartList.size());
            userCart.removeItem(cartList.get(userOption-1).getCartItemName());
            return false;
        }
        else
        {
            return false;
        }
    }

    public void start() {
        while (!result) {
            int menuChoose;
            showMainMenu();

            if (userCart.cartIsEmpty()) {
                menuChoose = userInput(menus.size());
            } else {
                menuChoose = userInput((menus.size() + 2));
            }

            switch (menuChoose)
            {
                case -1 : return;
                case 4 :
                    result = showCart();
                    break;
                case 5 :
                    userCart.removeCart();
                    break;
                default:
                    showSubMenu(menuChoose-1);
            }

        }
    }

}

