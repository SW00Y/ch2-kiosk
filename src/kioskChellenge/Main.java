package kioskChellenge;

import kiosk.Lv5.Kiosk;
import kiosk.Lv5.Menu;
import kiosk.Lv5.MenuItem;

public class Main {
    public static void main(String[] args) {
//        드링크, 디저트는 addMenu 이런식으로 new Menu를 더 추가해서 Kiosk.addMenu(추가한메뉴)
        //하고 kiosk.addMenu를 메뉴 종류별로 띄우고 kiosk start?

        kiosk.Lv5.Kiosk kiosk = new Kiosk();      //Kiosk 객체 생성

        kiosk.Lv5.Menu burgerMenu = new kiosk.Lv5.Menu("햄버거");      //각 카테고리 메뉴 생성
        burgerMenu.addMenuItem(new kiosk.Lv5.MenuItem("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9));
        burgerMenu.addMenuItem(new kiosk.Lv5.MenuItem("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9));
        burgerMenu.addMenuItem(new kiosk.Lv5.MenuItem("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9));
        burgerMenu.addMenuItem(new kiosk.Lv5.MenuItem("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4));

        kiosk.addKioskMenu(burgerMenu);

        kiosk.Lv5.Menu drinkMenu = new kiosk.Lv5.Menu("음료");
        drinkMenu.addMenuItem(new kiosk.Lv5.MenuItem("Coca-Cola", "코카콜라", 0.9));
        drinkMenu.addMenuItem(new kiosk.Lv5.MenuItem("Pepsi", "펩시", 0.9));

        kiosk.addKioskMenu(drinkMenu);

        kiosk.Lv5.Menu dessertsMenu = new Menu("디저트");
        dessertsMenu.addMenuItem(new kiosk.Lv5.MenuItem("French fries", "감자튀김", 2.9));
        dessertsMenu.addMenuItem(new MenuItem("Onion Ring", "양파튀김", 2.9));

        kiosk.addKioskMenu(dessertsMenu);





        kiosk.start();      //키오스크 실행





    }
}
