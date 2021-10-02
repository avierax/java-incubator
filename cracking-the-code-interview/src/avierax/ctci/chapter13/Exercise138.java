package avierax.ctci.chapter13;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Using lambda expressions, write a function List<Integer> that returns a random subset of arbitrary size.
 */
public class Exercise138 {

    public static List<Integer> getRandomSubset(List<Integer> list) {
        Random random = new Random();
        return list.stream().filter(t -> random.nextBoolean()).toList();
    }

    public static void main(String[] args) {
            var list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
            getRandomSubset(list).forEach(System.out::println);
    }
}