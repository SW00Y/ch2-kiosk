package kioskChellenge;

import java.util.ArrayList;
import java.util.List;

public class UserCart {

    private List<CartItem> cartItems = new ArrayList<>();

    public void addCart(MenuItem menuItem){
        cartItems.add(new CartItem(menuItem));
        System.out.println(menuItem.name + "이 장바구니에 추가되었습니다.");
    }

    public void showCart(){
        for(int i=0; i<cartItems.size(); i++){
            System.out.println(cartItems.get(i).getCartItemFullName());
        }
    }

    public boolean cartIsEmpty(){
        return cartItems.size() == 0;
    }

}
