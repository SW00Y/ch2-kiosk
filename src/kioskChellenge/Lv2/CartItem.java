package kioskChellenge.Lv2;

public class CartItem {

    private MenuItem menuItem;
    private int itemCount;

    public CartItem(MenuItem menuItem){
        this.menuItem = menuItem;
        this.itemCount = 1;
    }

    public String getCartItemName(){
        return this.menuItem.name;
    }

    public String getCartItemFullName(){
        return this.menuItem.name + " | ₩ " + this.menuItem.price + " | " + this.menuItem.content + " | " + this.itemCount + " 개";
    }

    public double getCartItemPrice(){
        return this.menuItem.price * itemCount;
    }

    public int getItemCount(){
        return this.itemCount;
    }

    public void cartPlusItem(){
        this.itemCount = this.itemCount +1;
    }
}
