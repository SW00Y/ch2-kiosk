package kioskChallenge.Lv2;

import kioskChallenge.Lv2.menu.Menu;
import kioskChallenge.Lv2.menu.MenuItem;

public class Main {
    public static void main(String[] args) {

        /*******************************
         * Kiosk 객체 생성
         *******************************/

        Kiosk kiosk = new Kiosk();

        /*******************************
         * Menu 추가
         *******************************/
        Menu burgerMenu = new Menu("햄버거");
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9));
        burgerMenu.addMenuItem(new MenuItem("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9));
        burgerMenu.addMenuItem(new MenuItem("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4));

        kiosk.addKioskMenu(burgerMenu);

        Menu drinkMenu = new Menu("음료");
        drinkMenu.addMenuItem(new MenuItem("Coca-Cola", "코카콜라", 0.9));
        drinkMenu.addMenuItem(new MenuItem("Pepsi", "펩시", 0.9));

        kiosk.addKioskMenu(drinkMenu);

        Menu dessertsMenu = new Menu("디저트");
        dessertsMenu.addMenuItem(new MenuItem("French fries", "감자튀김", 2.9));
        dessertsMenu.addMenuItem(new MenuItem("Onion Ring", "양파튀김", 2.9));

        kiosk.addKioskMenu(dessertsMenu);





        kiosk.start();





    }
}
