package kioskChallenge.Lv2;

import kioskChallenge.Lv2.cart.CartItem;
import kioskChallenge.Lv2.cart.UserCart;
import kioskChallenge.Lv2.menu.Menu;
import kioskChallenge.Lv2.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private List<Menu> menus = new ArrayList<>();
    UserCart userCart = new UserCart();
    boolean result = false;
    Scanner scanner = new Scanner(System.in);

    /*******************************
     * Main에서 Kiosk 객체 생성 후 Menu를 추가할때 호출
     *******************************/
    public void addKioskMenu(Menu menu) {
        menus.add(menu);
    }

    /*******************************
     * MainMenu 카테고리를 출력한다.
     * 이미 장바구니에 상품이 있는 경우 주문과 취소 옵션을 출력
     *******************************/
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

    /*******************************
     * 카테고리 선택 후 입력을 전달받고 카테고리에 대한 메뉴를 출력한다.
     * 변경 itemList를 직접 for문 출력 -> Stream 을 활용한 출력
     *******************************/
    public void showSubMenu(int menuChoose){
        List<MenuItem> itemList = menus.get(menuChoose).getMenuItems();


//        for (int i=0; i<itemList.size(); i++)     //Stream을 활용한 출력으로 삭제
//        {
//            System.out.println(i + 1 + ". " + itemList.get(i).getMenuFullName());
//        }

        menus.get(menuChoose).printMenuItems(); //Stream을 활용하여 출력
        System.out.println("0. 뒤로가기");

        menuChoose = userInput(itemList.size(),true);

        if(menuChoose == -1) //UserInput 메소드에서 0이 입력된 경우
        {
            System.out.println("메인메뉴로 돌아갑니다.");
            return;
        }

        addCart(itemList.get(menuChoose-1));
    }

    /*******************************
     * 사용자의 입력을 받고 예외처리를 진행하는 메소드
     * maxSize로 입력값의 범위를 설정
     * canReturn으로 0을 수신할 수 있는 메뉴의 경우 -1을 반환
     ********************************/
    public int userInput(int maxSize, boolean canReturn) {

        int inputNum;

        while (true) {
            try {
                System.out.print("메뉴 선택: ");
                inputNum = Integer.parseInt(scanner.nextLine().trim()); // 문자열 입력 방지

                if (inputNum == 0 && canReturn == true) {
                    return -1;
                }
                else if(inputNum == 0 && canReturn == false)
                {
                    System.out.println("입력값의 범위를 벗어났습니다. 다시 입력해주세요.");
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

    /*******************************
     * showSubMenu 호출 후 사용자의 추가할지 의사결정 처리
     * 추가하는 경우 UserCart에 menyItem을 전달하여 장바구니에 추가
     ********************************/
    public void addCart(MenuItem menuItem){

        System.out.println("선택한 메뉴 : " + menuItem.getMenuFullName());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인   2. 취소");

        int userOption = userInput(2, false);

        if (userOption == 1)
        {
            userCart.addCart(menuItem);
        }
    }

    /*******************************
     * UserCart의 Item을 보여주고, 주문을 진행한다.
     ********************************/
    public boolean showCart(){
        List<CartItem> cartList = userCart.getCartItems();
        double totalPrice = 0;  //총 금액 초기화

        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println("[ Orders ]");

        // 장바구니 내역 출력
        for(int i=0; i<cartList.size(); i++){
            System.out.println(cartList.get(i).getCartItemFullName());
            totalPrice = totalPrice + cartList.get(i).getCartItemPrice();
        }
        totalPrice = Math.floor(totalPrice*100) / 100.0;
        
        System.out.println("[ Total ]");
        System.out.println("￦ " + totalPrice);
        System.out.println("1. 주문    2. 메뉴삭제    3. 메뉴판");

        int userOption = userInput(3, false);

        if(userOption == 1) //주문의 경우
        {
            System.out.println("할인 정보를 입력해주세요.");
            System.out.println("1. 국가유공자 : 10%\n2. 군인 : 5%\n3. 학생 : 3%\n4. 일반 : 0%");
            userOption = userInput(4,false);    // 4개의 옵션, 0입력불가 환경

            totalPrice = OrderDiscount.doDiscount(userOption, totalPrice);  //Enum을 이용한 계산
            System.out.println("주문이 완료되었습니다. 금액은 : ￦" + totalPrice + " 입니다.");
            return true;    //주문완료 - 프로그램 종료
        }
        else if (userOption == 2) //메뉴 삭제의 경우
        {
            System.out.println("========현재 장바구니========");
            for(int i=0; i<cartList.size(); i++){
                System.out.println(i+1 + ". " + cartList.get(i).getCartItemFullName());
            }

            userOption = userInput(cartList.size(),false);
            userCart.removeItem(cartList.get(userOption-1).getCartItemName());  //Cart에서 선택된 Item을 삭제
            return false;
        }
        else
        {
            return false;
        }
    }

    /*******************************
     * Kiosk Main과 같은 Kiosk객체 실행 메소드
     ********************************/

    public void start() {
        while (!result) {
            int menuChoose;
            showMainMenu();

            //반복 중 Cart에 Item이 존재하면 주문, 취소 옵션을 위한 처리
            if (userCart.cartIsEmpty()) {
                menuChoose = userInput(menus.size(),true);
            } else {
                menuChoose = userInput((menus.size() + 2),true);
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

