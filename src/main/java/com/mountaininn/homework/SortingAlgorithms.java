package com.mountaininn.homework;

import java.util.Comparator;
import java.util.random.RandomGenerator;

public class SortingAlgorithms {

    public static <T> void quickSort(MyArrayList<T> myArrayList, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int p = partition(myArrayList, low, high, comparator);
            quickSort(myArrayList, low, p, comparator);
            quickSort(myArrayList, p + 1, high, comparator);
        }
    }

    private static <T> int partition(MyArrayList<T> list, int low, int high, Comparator<T> comparator) {
        int randomIndex = RandomGenerator.getDefault().nextInt(low, high);
        int i = low;
        int j = high;
        T pivot = list.get(randomIndex);
        T lesser, greater;
        while (true) {
            while (i <= high && comparator.compare(list.get(i), pivot) < 0) {
                i++;
            }
            while (j >= low && comparator.compare(list.get(j), pivot) > 0) {
                j--;
            }
            if (i >= j)
                return j;

            greater = list.get(i);
            lesser = list.get(j);

            list.set(j, greater);
            list.set(i, lesser);
        }
    }
}
