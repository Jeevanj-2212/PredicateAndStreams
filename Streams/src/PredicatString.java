import java.util.Scanner;
import java.util.function.Predicate;

public class PredicatString {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String inp = sc.nextLine();

        Predicate<String> start = x->x.startsWith("a");
        Predicate<String> end = x->x.endsWith("a");
        Predicate<String> ou = start.and(end);
        System.out.println(ou.test(inp));
    }
}
