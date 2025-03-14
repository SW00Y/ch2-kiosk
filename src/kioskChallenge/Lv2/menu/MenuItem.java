package kioskChallenge.Lv2.menu;

public class MenuItem {
    private String name;
    private String content;
    private Double price;

    public MenuItem(String name, String content, double price) {
        this.name = name;
        this.content = content;
        this.price = price;
    }

    public String getItemName(){
        return this.name;
    }

    public String getItemContent(){
        return this.content;
    }

    public Double getItemPrice(){
        return this.price;
    }





    public String getMenuFullName(){
        return this.name + " | ₩ " + this.price + " | " + this.content;
    }

}
