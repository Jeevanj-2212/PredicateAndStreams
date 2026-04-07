import java.util.Scanner;
import java.util.function.Predicate;


// Predicate Usually checks the condition
public class PredicateExample {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int a  = sc.nextInt();
        Predicate<Integer> isEven = x-> x%2==0;
        System.out.println(isEven.test(a));
    }
}
