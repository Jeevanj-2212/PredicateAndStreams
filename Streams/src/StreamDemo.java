import java.util.Arrays;
import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {
        /*Stream is a sequence of element supporting functional and declarative Programing
        * - It process data in declarative manner
        * Stream will have source Intermediate operations and terminal   operations  */

        List<Integer> numbers  = Arrays.asList(1,2,3,4,5);
        System.out.println(numbers.stream().filter(x->x%2==0).count());

    }
}
