package kioskChallenge.Lv2;

public enum OrderDiscount {
    /*******************************
     *상수 목록
     *******************************/
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

    /*******************************
     * 할인율 계산
     * 사용자의 할인옵션, 총 금액을 전달받고 처리한다.
     *******************************/
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

        double discountPrice = Math.floor(totalPrice * discountType.getDiscountPercent() * 100) / 100;
        totalPrice = Math.floor((totalPrice - discountPrice) * 100) / 100;

        System.out.println("할인금액 ￦ " + discountPrice);
        return totalPrice;
    }

};


