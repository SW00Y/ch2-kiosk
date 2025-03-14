package kioskChallenge.Lv2.cart;

import kioskChallenge.Lv2.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserCart {

    private List<CartItem> cartItems = new ArrayList<>();

    /*******************************
     * 장바구니에 선택한 메뉴를 담는 메소드
     * 이미 같은 Item이 존재하면 갯수 +1
     *******************************/
    public void addCart(MenuItem menuItem){
        for(int i=0; i<cartItems.size(); i++)
        {
            if(cartItems.get(i).getCartItemName().equals(menuItem.getItemName()))
            {
                cartItems.get(i).cartPlusItem();
                System.out.println(menuItem.getItemName() + "을 추가로 담았습니다. 현재 : " + cartItems.get(i).getItemCount());
                return;
            }
        }
        this.cartItems.add(new CartItem(menuItem));
        System.out.println(menuItem.getItemName() + "이 장바구니에 추가되었습니다.");
    }
    
    public List<CartItem> getCartItems(){
        return this.cartItems;
    }

    /*******************************
     * 장바구니의 Item을 삭제하는 메소드
     * itemName을 전달받아서 처리한다.
     *******************************/
    public void removeItem(String itemName){  //Stream 이용
        cartItems = cartItems.stream()
                .filter(cartItem -> !cartItem.getCartItemName().equals(itemName))
                .collect(Collectors.toList());
        System.out.println(itemName + " 메뉴가 삭제되었습니다.");
    }

    /*******************************
     * 카테고리 출력 시 취소를 선택한 경우 장바구니 비우기
     *******************************/
    public void removeCart(){
        cartItems.clear();
        System.out.println("장바구니를 비웠습니다.");
    }

    public boolean cartIsEmpty(){
        return cartItems.size() == 0;
    }

}
