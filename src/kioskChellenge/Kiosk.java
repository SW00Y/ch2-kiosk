package kioskChellenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private List<Menu> menus = new ArrayList<>();
    UserCart userCart = new UserCart();
    Scanner scanner = new Scanner(System.in);

    public void addKioskMenu(Menu menu) {       //Main에서 Kiosk Menu 추가를 위한 메소드
        menus.add(menu);
    }

    /***************************************
     * 사용자의 입력을 받기 위한 함수
     * maxSize 를 설정해서 범위를 지정한다.
     *************************************/

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

    /***************************************
     * 메인메뉴 출력용 메소드
     *************************************/
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

    public void checkOut(){
        List<CartItem> userCartItems = userCart.getCartItems();
        double totalPrice = 0;
        System.out.println("[ Orders ]");
        for(int i=0; i<userCartItems.size(); i++){
            System.out.println(userCartItems.get(i).getCartItemFullName());
            totalPrice = totalPrice + userCartItems.get(i).getMenuItem().price;
        }
        System.out.println("[ Total ]");
        System.out.println("₩ " + totalPrice);
    }

    /***************************************
     * 키오스크 시작
     *************************************/
    public void start() {
        int menuChoose = 0;             //초기화
        while (1 == 1) {
            showMainMenu();             //메인메뉴 실행
            System.out.println(userCart.cartIsEmpty());
            //카트가 비어있는 경우 주문, 취소 메뉴가 나오지 않게 설정
            if (userCart.cartIsEmpty()) {
                menuChoose = userInput(menus.size());
            } else {
                menuChoose = userInput((menus.size() + 2));
            }
            
            switch (menuChoose) {
                case -1, 0:
                    return;                 //이전으로, 취소
                case 4:
                    checkOut();    //장바구니 확인
                    break;
                case 5:
                    userCart.removeCart();  //장바구니 비우기
                    break;
                default:
                    userOrder(menuChoose);  //메뉴 선택
            }

        }
    }

    public void userOrder(int menuChoose) {
        menuChoose = menuChoose - 1;    //인덱스 탐색을 위한 입력한 수 -1
        List<MenuItem> itemList = menus.get(menuChoose).getMenuItems();

        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(i + 1 + ". " + itemList.get(i).getMenuFullName());
        }

        System.out.println("0. 뒤로가기");
        menuChoose = userInput(itemList.size());

        if(menuChoose == -1)    //-1이 리턴되는 경우 뒤로가기가 입력된 상황(0 입력)
        {
            return;
        }

        System.out.println(itemList.get(menuChoose).getMenuFullName());     //MenuItem 이름 출력
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인    2. 취소");

        menuChoose = userInput(2);
        try {
            switch (menuChoose){
                case 1 :                                            //장바구니 담기
                    userCart.addCart(itemList.get(menuChoose));
                    break;
                case 2 :                                            //취소
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

