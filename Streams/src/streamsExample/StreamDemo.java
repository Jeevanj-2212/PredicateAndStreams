package streamsExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        /*Stream is a sequence of element supporting functional and declarative Programing
        * - It process data in declarative manner
        * Stream will have source Intermediate operations and terminal   operations  */

        List<Integer> numbers  = Arrays.asList(1,2,3,4,5);
        System.out.println(numbers.stream().filter(x->x%2==0).count());

        // Ways to create Stream
        //1 Through any collection

        List<Integer> num = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = num.stream();

        //2 Through Arrays

        String[] str = {"a","b","c","d","e"};
        Stream<String> strStream = Arrays.stream(str);
        //3 Using Stream of

        Stream<String> strStream2 = Stream.of("a","b","c","d","e");

        //4 Infinite Stream

        Stream<Integer> str3 = Stream.generate(()->1);

        //Through iterator
        //In this example the infinite Stream is created and added limit of 100 to display 100 elements and that stream is collected in List
        List<Integer>lst =Stream.iterate(1, x->x+1).limit(100).collect(Collectors.toList());
        System.out.println(lst);



    }
}
