import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerAndSupplierExample {
    public static void main(String[] args) {
        //Consumer just consumes the value and return type is void
     List<Integer> val = Arrays.asList(1,2,3);

        Consumer<List<Integer>> res = x-> {
            for(int num : x) {
                System.out.println(num);
            }
        };
        res.accept(val);

        /*
        * Supplier do not accept anything but returns the value */

        Supplier<String> st = () -> "Hi";
        System.out.println(st.get());
    }
}
