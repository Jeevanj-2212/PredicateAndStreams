package streamsExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateStreamExamples {
    public static void main(String[] args) {
        /*
        Intermediate operations Transforms streams from one stream format to other stream formats
        they are not being executed until the terminal operation is executed
        Ex are filter,limit...
        * */

        //1 filter this is Predicate

        List<String> str = Arrays.asList("John","Peter","Fernando","John");
        Stream<String> val = str.stream().filter(x->x.startsWith("J"));
        long ans = val.count();
        System.out.println(ans);


        //2 Map here this takes map is Function meaning it is used to convert the data to some other formats
        List<String> nameString=str.stream().map(x->x.toUpperCase()).collect(Collectors.toList());
        System.out.println(nameString);

        //3 Sort
        System.out.println("Sorted names");
        List<String> sortedName = str.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedName);

        // We Can Perform custom sort also

        System.out.println("Sorted names using Comparator");
        List<String> names = str.stream().sorted((x, y) -> Integer.compare(x.length(), y.length()))
                .collect(Collectors.toList());
        System.out.println(names);

        //4 Distinct we can fetch only distinct element

        long dis = str.stream().filter(x->x.startsWith("J")).distinct().count();
        System.out.println(dis);

        //5 Limit it is used ti limit the value

        System.out.println( Stream.iterate(1, x->x+1).limit(100).collect(Collectors.toUnmodifiableList()));

        //6 skip it is used to skip the values so here first 10 values will be skipped

        System.out.println( Stream.iterate(1, x->x+1).limit(100).skip(10).collect(Collectors.toUnmodifiableList()));

    }
}
