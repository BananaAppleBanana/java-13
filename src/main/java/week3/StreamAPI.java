package week3;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] arr = {1, 2, 3, 1, 2, 2, 2, 2};
        List<Integer> res1 = IntStream.range(0, arr.length)
                                    .mapToObj(idx -> arr[idx])
                                    .map(x -> x * 2)
                                    .collect(Collectors.toList());


        Map<Integer, Integer> freq = IntStream.range(0, arr.length)
                .mapToObj(idx -> arr[idx])
                .collect(
                        HashMap::new,
                        (map, ele) -> map.merge(ele, 1, Integer::sum),
                        (m1, m2) -> {}
                );
        System.out.println(freq);
        System.out.println(arr); //doesn't work , cannot get elements in array.
        System.out.println(Arrays.toString(arr));
        Arrays.stream(arr).forEach(System.out::println);

        list.stream().map(x -> x * 2).collect(Collectors.toList());
        Supplier<Iterator<Integer>> iteratorSupplier = () -> list.listIterator();

    }
}


/**
 *  Stream API flow / internal implementation
 *  list.stream().map(x -> x * 2).collect(Collectors.toList());
 *  1. ReferencePipeline(head) <-> ReferencePipeline(map) <-> terminal operation
 *  2. generate Sink LinkedList
 *        Sink(iterator) -> Sink(map) -> Sink(collect)
 *
 *        iterator list (a, b, c) {
 *          Sink(map).accept(a)
 *          ..accept(b)
 *          ..accept(c)
 *        }
 *
 */