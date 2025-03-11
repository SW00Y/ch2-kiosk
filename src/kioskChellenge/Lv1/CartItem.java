package kioskChellenge.Lv1;

public class CartItem {

    private MenuItem menuItem;
    private int itemCount;

    public CartItem(MenuItem menuItem){
        this.menuItem = menuItem;
        this.itemCount = 1;
    }

    public String getCartItemFullName(){
        return this.menuItem.name + " | ₩ " + this.menuItem.price + " | " + this.menuItem.content + " | " + this.itemCount + " 개";
    }

    public double getCartItemPrice(){
        return this.menuItem.price;
    }


}
