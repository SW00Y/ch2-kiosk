package kioskChellenge;

public class CartItem {

    private MenuItem menuItem;      
    private int itemCount;

    public CartItem(MenuItem menuItem){     //생성자
        this.menuItem = menuItem;
        this.itemCount = 1;
    }

    public String getCartItemFullName(){            //장바구니 출력
        return this.menuItem.name + " | ₩ " + this.menuItem.price + " | " + this.menuItem.content + " | " + this.itemCount + " 개";
    }

    public MenuItem getMenuItem(){
        return this.menuItem;
    }

}
