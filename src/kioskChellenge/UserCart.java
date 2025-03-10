package kioskChellenge;

import java.util.ArrayList;
import java.util.List;

public class UserCart {

    private List<CartItem> cartItems = new ArrayList<>();

    public void addCart(MenuItem menuItem){
        cartItems.add(new CartItem(menuItem));
        System.out.println("ㅇㅇ");
    }

    public void showCart(){
        System.out.println(cartItems.get(0));
    }

}
