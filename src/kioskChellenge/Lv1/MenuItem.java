package kioskChellenge.Lv1;

public class MenuItem {
    String name;
    String content;
    Double price;

    public MenuItem(String name, String content, double price) {
        this.name = name;
        this.content = content;
        this.price = price;
    }

    public String getMenuFullName(){
        return this.name + " | ₩ " + this.price + " | " + this.content;
    }

}
