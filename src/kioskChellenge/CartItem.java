package kioskChellenge;

import java.util.List;

public class CartItem {

    private MenuItem menuItem;
    private int itemCount;

    public CartItem(MenuItem menuItem){
        this.menuItem = menuItem;
        this.itemCount = 1;
    }

    @Override
    public String toString() {
        return menuItem.name + " | ₩ " + menuItem.price + " | " + menuItem.content + " | 수량: " + itemCount;
    }

}
