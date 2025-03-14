package kioskChallenge.Lv2.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Menu {
    private List<MenuItem> menuItems;
    private String categoryName;

    public Menu(String categoryName){
        this.menuItems = new ArrayList<>();
        this.categoryName = categoryName;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public List<MenuItem> getMenuItems(){
        return menuItems;
    }

    /*******************************
     * MenuItem을 Stearm을 활용하여 출력
     *******************************/
    public void printMenuItems() {
        IntStream.range(0, menuItems.size())  // 0부터 menuItems.size() - 1까지
                .forEach(i ->
                        System.out.println((i + 1) + ". " + menuItems.get(i).getMenuFullName()) // 1부터 시작
                );
    }

    public String getCategoryName(){
        return categoryName;
    }






}
