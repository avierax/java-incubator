package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static <T> List<T> randomSubset(List<T> list) {
        Random random = new Random();
        return list.stream().filter(t -> random.nextBoolean()).toList();
    }

    public static void main(String[] args) {
            var list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
            randomSubset(list).forEach(System.out::println);
    }
}