package streamsExample;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperatorsExample {
    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(1,2,3);

        //1 collect
        lst.stream().collect(Collectors.toList());
        // in latest java versions we can use toList directly

        List<Integer>lst1 = lst.stream().skip(1).toList();
        System.out.println(lst1);
        // 2 for each
        lst.stream().forEach(x-> System.out.println(x));

        // 3 reduce combines elements to produce single element

        Optional<Integer> val = lst.stream().reduce((a,b)->a+b);
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
    }
}
