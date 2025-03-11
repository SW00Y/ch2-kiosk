package kioskChellenge;

public class MenuItem {
    String name;
    String content;
    Double price;

    public MenuItem(String name, String content, double price) {
        this.name = name;
        this.content = content;
        this.price = price;
    }

    public String getMenuFullName(){        //Item 출력용
        return this.name + " | ₩ " + this.price + " | " + this.content;
    }

}
