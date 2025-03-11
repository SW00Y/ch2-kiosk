package kioskChellenge.Lv1;

import java.util.ArrayList;
import java.util.List;

public class UserCart {

    private List<CartItem> cartItems = new ArrayList<>();

    public void addCart(MenuItem menuItem){
        this.cartItems.add(new CartItem(menuItem));
        System.out.println(menuItem.name + "이 장바구니에 추가되었습니다.");
    }

    public List<CartItem> getCartItems(){
        return this.cartItems;
    }

    public void removeCart(){
        cartItems.clear();
        System.out.println("장바구니를 비웠습니다.");
    }

    public boolean cartIsEmpty(){
        return cartItems.size() == 0;
    }

}
