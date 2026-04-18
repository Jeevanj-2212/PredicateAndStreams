package streamsExample;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamsEx {
    public static void main(String[] args) {

        // Using Parallel Streams Helps to reduce the time of execution of the program
        //Parallel stream allows multiple thread to process the parts of stream simultaneously and workload is distributed around multiple threads

        //Paralle stream can be used to cpu intensive tasks and  large datasets and independent on streams
        long startTime = System.currentTimeMillis();
        List<Integer> numbers = Stream.iterate(1,x->x+1).limit(20000).toList();
        List<Long> fact = numbers.stream().map(ParallelStreamsEx::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - startTime));

        long startTime2 = System.currentTimeMillis();

        List<Long> factorialN = numbers.parallelStream().map(ParallelStreamsEx::factorial).toList();
        long endTime2 = System.currentTimeMillis();
        System.out.println("Total time taken2: " + (endTime2 - startTime2));
    }

    public static long factorial(int n){
        long result = 1;
        for(int i=2;i<=n;i++){
            result *= i;
        }
        return result;
    }
}
