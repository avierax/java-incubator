package avierax.ctci.chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = new int[13];
        var r = new Random(8);
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(100);
        }
        System.out.println(Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        mergeSort(numbers);
        System.out.println(Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    private static void mergeSort(int[] input) {
        int[] buffer = Arrays.copyOf(input, input.length);
        doMergeSort(input, 0, input.length, buffer);
    }

    /**
     *
     * @param input
     * @param left
     * @param right exclusive
     */
    private static void doMergeSort(int[] input, int left, int right, int[] buffer){
        // if the input is empty or has a single element do nothing
        int length = right - left;
        if(length>1){
            int middle = (right + left) / 2;
            doMergeSort(input, left, middle, buffer);
            doMergeSort(input, middle, right, buffer);
            doMerge(input, left, middle, right, buffer);
        }
    }

    private static void doMerge(int[] input, int p1left, int middle, int p2right, int[] buffer) {
        int i1 = p1left;
        int i2 = middle;
        int current = p1left;//buffer pos
        while(i1 < middle && i2 < p2right) {
            if(input[i1] < input[i2]){
                buffer[current++] = input[i1++];
            } else {
                buffer[current++] = input[i2++];
            }
        }

        int i;
        int cstop;
        if(i1 < middle){
            i = i1;
            cstop = middle;
        } else {
            i = i2;
            cstop = p2right;
        }
        System.arraycopy(input, i, buffer, current, cstop-i);
        System.arraycopy(buffer, p1left, input, p1left, p2right - p1left );
    }
}
