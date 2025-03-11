package kiosk.Lv5;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItems;       //MenuItem을 List로 가지는 menuItems 선언
    private String categoryName;            //menuItems 카테고리

    public Menu(String categoryName){
        this.menuItems = new ArrayList<>();
        this.categoryName = categoryName;       //생성자
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public List<MenuItem> getMenuItems(){
        return menuItems;
    }

    public String getCategoryName(){
        return categoryName;
    }






}
