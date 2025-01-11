package com.mountaininn.homework;

import java.util.Comparator;
import java.util.random.RandomGenerator;

public class SortingAlgorithms {

    public static <E> void quickSort(MyArrayList<E> myArrayList, int low, int high, Comparator<E> comparator) {
        if (low < high) {
            int p = partition(myArrayList, low, high, comparator);
            quickSort(myArrayList, low, p, comparator);
            quickSort(myArrayList, p + 1, high, comparator);
        }
    }

    private static <E> int partition(MyArrayList<E> list, int low, int high, Comparator<E> comparator) {
        int randomIndex = RandomGenerator.getDefault().nextInt(low, high);
        int i = low;
        int j = high;
        E pivot = list.get(randomIndex);
        E lesser, greater;
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

    public static <E extends Comparable<E>> void quickSort(MyArrayList<E> myArrayList, int low, int high) {
        if (low < high) {
            int p = partition(myArrayList, low, high);
            quickSort(myArrayList, low, p);
            quickSort(myArrayList, p + 1, high);
        }
    }

    private static <E extends Comparable<E>> int partition(MyArrayList<E> list, int low, int high) {
        int randomIndex = RandomGenerator.getDefault().nextInt(low, high);
        int i = low;
        int j = high;
        E pivot = list.get(randomIndex);
        E lesser, greater;
        while (true) {
            while (i <= high && list.get(i).compareTo(pivot) < 0) {
                i++;
            }
            while (j >= low && list.get(j).compareTo(pivot) > 0) {
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
