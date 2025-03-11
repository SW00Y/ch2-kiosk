package kioskChellenge.Lv1;

import java.util.ArrayList;
import java.util.List;

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

    public String getCategoryName(){
        return categoryName;
    }






}
