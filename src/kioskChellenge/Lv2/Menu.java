package kioskChellenge.Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

    public void printMenuItems(){
        AtomicInteger index = new AtomicInteger(1);
        menuItems.stream()
                .forEach(menuItem ->
                        {
                            int itemIndex = index.getAndIncrement();
                            System.out.println(itemIndex + ". " + menuItem.getMenuFullName());
                        }
                );
    }

    public String getCategoryName(){
        return categoryName;
    }






}
