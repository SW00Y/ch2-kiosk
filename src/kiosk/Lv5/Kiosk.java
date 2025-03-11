package kiosk.Lv5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private List<Menu> menus = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addKioskMenu(Menu menu){    //Main에서 실행하는 메소드, Kiosk의 Menu를 추가한다.
        menus.add(menu);
    }

    public void start() {
        int menuChoose = 0;     //메뉴 입력 변수 초기화

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
                    throw new RuntimeException("범위를 벗어난 입력입니다.");       //범위에 대한 예외처리
                }
            }
            catch (Exception e){
                System.out.println("잘못된 입력 : " + e);        //전체 예외처리
                scanner.nextLine();
                continue;
            }

            if (menuChoose == 0) {      //0 입력시 종료
                break;
            }

            else {
                menuChoose = menuChoose - 1;        // 인덱스 탐색을 위한 입력받은 수 -1
                List<MenuItem> itemList = menus.get(menuChoose).getMenuItems();

                for(int i=0; i<itemList.size(); i++ )
                {
                     System.out.println(i+1 + ". " + itemList.get(i).name + " | ₩ " + itemList.get(i).price + " | " + itemList.get(i).content + " | ");
                }

                System.out.println("0. 뒤로가기");

                try {
                    menuChoose = scanner.nextInt();
                    if(menuChoose > itemList.size() || menuChoose < 0)      //범위에 대한 예외처리
                    {
                        throw new RuntimeException("범위를 벗어난 입력입니다.");
                    }
                }
                catch (Exception e){        //전체 예외처리
                    System.out.println("잘못된 입력 : " + e);
                    scanner.nextLine();
                    continue;
                }

                if (menuChoose == 0) {
                    continue;
                }

                else{
                    menuChoose = menuChoose - 1;        //출력
                    System.out.println("선택한 메뉴 : " + itemList.get(menuChoose).name + " | ₩ " + itemList.get(menuChoose).price + " | " + itemList.get(menuChoose).content);
                }
            }
        }
    }

}
