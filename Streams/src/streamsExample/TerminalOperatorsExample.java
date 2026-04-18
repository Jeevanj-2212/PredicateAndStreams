package streamsExample;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperatorsExample {
    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(1, 2, 3);

        //1 collect
        lst.stream().collect(Collectors.toList());
        // in latest java versions we can use toList directly

        List<Integer> lst1 = lst.stream().skip(1).toList();
        System.out.println(lst1);
        // 2 for each
        lst.stream().forEach(x -> System.out.println(x));

        // 3 reduce combines elements to produce single element

        Optional<Integer> val = lst.stream().reduce((a, b) -> a + b);
        System.out.println(val.get());

        //4 count
        long count = lst.stream().count();
        System.out.println(count);


        //5 anyMatch allMatch noneMatch

        boolean b = lst.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);

        boolean b1 = lst.stream().allMatch(x -> x > 0);
        System.out.println(b1);

        boolean b2 = lst.stream().noneMatch(x -> x + 1 > 2);
        System.out.println(b2);

        //6 find first,find any
        System.out.println(lst.stream().findFirst().get());
        System.out.println(lst.stream().findAny().get());


        //example Filtering names and collecting it

        List<String> names = Arrays.asList("John", "Sam", "Anna", "Rudolf", "Fab");
        System.out.println(names.stream().filter(x -> x.length() > 3).toList());


        // Example squaring  and sorting the numbers

        List<Integer> nums = Arrays.asList(10, 5, 6, 1, 8, 12);
        System.out.println(nums.stream().map(x -> x * x).sorted().toList());

        //Example summing values

        System.out.println(nums.stream().reduce(Integer::sum).get());

        //Counting occurrence of character
        //use chars method that converts String to  character streams

        String s = "Hello World";
        System.out.println(s.chars().filter(x->x=='l').count());

        //find even numbers and square the number and fine their sum
        List<Integer> numList = Arrays.asList(1,2,3,4,5,6);
        System.out.println(numList.stream().filter(x->x%2==0).map(y->y*y).reduce(Integer::sum).get());

    }
}