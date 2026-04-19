package streamsExample;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsEx {
    public static void main(String[] args) {
        // collectors is a utility class
        // it provides a set of methods to create common colletors
        // 1 Collecting to List
        List<String> str = Arrays.asList("John","Peter","Fernando","John");
        List<String>res = str.stream().filter(name->name.startsWith("J")).collect(Collectors.toList());
        System.out.println(res);

        //2 Collecting to Set
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 5, 5, 1);
        Set<Integer> n = nums.stream().collect(Collectors.toSet());
        System.out.println(n);

        //3 we can use collectors to collect any collection here We have used ArrayDeque
        ArrayDeque<String>r =  str.stream().collect(Collectors.toCollection(()-> new ArrayDeque<>()));
        System.out.println(r);

        String collect = str.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(collect);
        // 4 summerizing data
        // Generating statistical  Data like max, min,count,average, max

        List<Integer> num = Arrays.asList(1,2,3,4);
        IntSummaryStatistics sums = num.stream().collect(Collectors.summarizingInt(x->x));
        System.out.println("count "+sums.getCount());
        System.out.println("Max "+sums.getMax());
        System.out.println("Min "+sums.getMin());
        System.out.println("Sum "+sums.getSum());
        System.out.println("Avg "+sums.getAverage());


        // we can use  stats separately

        //5 Averaging

        System.out.println(num.stream().collect(Collectors.averagingInt(x->x)));
        //6 counting

        System.out.println(num.stream().collect(Collectors.counting()));

        //7 Grouping elements

        List<String> lst = Arrays.asList("John","Peter","Fernando","john");
        // With the normal logic group by length
        System.out.println(lst.stream().collect(Collectors.groupingBy(x->x.length())));
        // By method reference
        System.out.println(lst.stream().collect(Collectors.groupingBy(String::length)));
        // applying collectors inside collector

        System.out.println(lst.stream().collect(Collectors.groupingBy(String::length,Collectors.joining(", "))));
        System.out.println(lst.stream().collect(Collectors.groupingBy(String::length,Collectors.counting())));


        //8 Partitioning Elements
        // Partitions the element into two groups  based on Predicate

        System.out.println(lst.stream().collect(Collectors.partitioningBy(x->x.length()>5)));


        //9 Mapping and collecting used if we want to do something before collecting


        System.out.println(lst.stream().collect(Collectors.mapping(x->x.toUpperCase(),Collectors.toList())));


        //Examples
        //Ex1 Collecting names by length

        List<String> names =  Arrays.asList("John","Peter","Fernando","john");

        System.out.println(names.stream().collect(Collectors.groupingBy(x->x.length())));

        //Example 2 Counting the number of occurrences

        String val  = "Java is Very good Language";
        System.out.println(Arrays.stream(val.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting())));

        //Example 3 :Partitioning Even and odd

        List<Integer> l2 = Arrays.asList(1,2,3,4,5);
        System.out.println(l2.stream().collect(Collectors.partitioningBy(x->x%2==0)));

        // Example 4 Summing values in Map
        Map<String,Integer> items = new HashMap<>();
        items.put("Apple",10);
        items.put("Banana", 20);
        items.put("Orange",30);

        System.out.println(items.values().stream().reduce(Integer::sum));

        //Example 5 Creating Map from Stream elements using to map

        List<String> fruits = Arrays.asList("Apple","Banana","Orange");
        System.out.println(fruits.stream().collect(Collectors.toMap(x->x.toUpperCase(),x->x.length())));

        //Example 6 using toMap to count the number of occurrences of each element

        List<String> fruits2 =  Arrays.asList("Apple","Banana","Orange","Apple");
        // here first we are taking the word for eg apple and keeping a flag x->1 means there is one apple whenever there is one more apple then (x,y)->x+y) is used to update the value of key
        System.out.println(fruits2.stream().collect(Collectors.toMap(x->x,x->1,(x,y)->x+y)));


    }
}
