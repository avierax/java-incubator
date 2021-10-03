package avierax.ctci.chapter10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        var r = new Random(5);
        for (int i = 0; i < 10; i++) {
            list.add(r.nextInt(100));
        }
        var newList = mergeSort(list);
        System.out.println(newList);
    }

    private static List<Integer> mergeSort(List<Integer> list) {
        if (list.size() < 2)
            return list;
        int half = list.size() / 2;
        return merge(mergeSort(list.subList(0, half)), mergeSort(list.subList(half, list.size())));
    }

    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        var i1 = 0;
        var i2 = 0;
        List<Integer> result = new ArrayList<>();
        while (i1 < list1.size() && i2 < list2.size()) {
            if (list1.get(i1) < list2.get(i2))
                result.add(list1.get(i1++));
            else
                result.add(list2.get(i2++));
        }
        if (i1 < list1.size()) {
            result.addAll(list1.subList(i1, list1.size()));
        } else {
            result.addAll(list2.subList(i2, list2.size()));
        }
        return result;
    }
}
