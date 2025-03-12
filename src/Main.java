import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 427;
        int answer = 0;

        while(true){
            answer+=n%10;
            if(n<10)
                break;

            n=n/10;
        }
        System.out.println(answer);

        System.out.println("=====");
        System.out.println(427%10);
        System.out.println(427/10);
        System.out.println("=====");
        System.out.println(42%10);
        System.out.println(42/10);
    }
}