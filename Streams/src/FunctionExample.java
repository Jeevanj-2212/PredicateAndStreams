import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.util.function.Function;

public class FunctionExample {
    //It is used to perform some function Syntax Function<Input,ReturnType>
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        Function<Integer,Integer> doubleVal = x->2*x;
        Function<Integer,Integer> tripleVal = x->3*x;

        /*
               eg val = 5
        //output will be 2*val= 2*5=10
        //3*10=30
        //Compose does vise versa of andThen eg val= 5

        first 3*5=15 and 15*2=30

        Identity gives the output what you gave as input
        * */

        Function<Integer,Integer> ident = Function.identity();

        System.out.println(doubleVal.andThen(tripleVal).apply(val));
        System.out.println("Compose"+doubleVal.compose(tripleVal).apply(val));
        System.out.println("Identity "+ident.apply(val));


    }




}
