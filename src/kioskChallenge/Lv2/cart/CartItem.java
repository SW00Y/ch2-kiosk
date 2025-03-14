package kioskChallenge.Lv2.cart;

import kioskChallenge.Lv2.menu.MenuItem;

public class CartItem {

    /*******************************
     * 사용자의 장바구니 - MenuItem, MenuItem의 갯수를 관리한다.
     *******************************/

    private MenuItem menuItem;
    private int itemCount;

    public CartItem(MenuItem menuItem){
        this.menuItem = menuItem;
        this.itemCount = 1;
    }

    public String getCartItemName(){
        return this.menuItem.getItemName();
    }

    public String getCartItemFullName(){
        return this.menuItem.getItemName() + " | ₩ " + this.menuItem.getItemPrice() + " | " + this.menuItem.getItemPrice() + " | " + this.itemCount + " 개";
    }

    public double getCartItemPrice(){
        return this.menuItem.getItemPrice() * itemCount;
    }

    public int getItemCount(){
        return this.itemCount;
    }

    public void cartPlusItem(){
        this.itemCount = this.itemCount +1;
    }
}
