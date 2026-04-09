import java.util.Scanner;
import java.util.function.*;

public class BiPredicateBiConsumerBiFunction {
    public static void main(String[] args) {

        /*
        BiPredicateBiConsumerBiFunction will have two parameters
        * */
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        BiPredicate<Integer,Integer> isEven = (x,y)->(x+y)%2==0;
        System.out.println("Checking Even or Not: "+isEven.test(a,b));

        BiConsumer<Integer,Integer> sum = (x,y)-> {
            System.out.println("Sum: "+(x+y));
        };
       sum.accept(a,b);

        BiFunction<String,String,Integer> lenOfString = (x,y)->(x+y).length();

        System.out.println("Length of String "+lenOfString.apply("Jeevan","J"));


        /*
        UnaryOperator and BinaryOperator is same as Function But instead of 2 and 3 arguments we are passing 1 argument respectively and return type will be arguments which we have passed
        * */

        UnaryOperator<Integer> square = x->(x*x);
        System.out.println("Square "+square.apply(2));

        BinaryOperator<Integer> add = (x,y)->x+y;

        System.out.println("Add "+add.apply(3,2));
        String actualUsername = "admin";
        String actualPassword = "1234";

        BiPredicate<String, String> isValidUser = (username, password) ->
                username.equals(actualUsername) && password.equals(actualPassword);


        System.out.println(isValidUser.test("admin", "1234")); // true
        System.out.println(isValidUser.test("admin", "wrong")); // false


    }
}
