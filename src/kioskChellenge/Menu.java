package kioskChellenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        // 스트림을 이용한 출력

    }

    public String getCategoryName(){
        return categoryName;
    }






}
