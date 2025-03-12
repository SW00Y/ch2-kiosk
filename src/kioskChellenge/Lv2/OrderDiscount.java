package kioskChellenge.Lv2;

public enum OrderDiscount {
    HERO(0.10),
    SOLDIER(0.05),
    STUDENT(0.03),
    PERSON(0.00);

    private final double discountPercent;

    OrderDiscount(double discountPercent){
        this.discountPercent = discountPercent;
    }

    public double getDiscountPercent(){
        return this.discountPercent;
    }

    public static double doDiscount(int userOption, double totalPrice){
        OrderDiscount discountType = null;

        switch (userOption){
            case 1 : discountType = HERO;
                break;
            case 2 : discountType = SOLDIER;
                break;
            case 3 : discountType = STUDENT;
                break;
            case 4 : discountType = PERSON;
                break;

        }
        return totalPrice - (totalPrice * discountType.getDiscountPercent());
    }

};


