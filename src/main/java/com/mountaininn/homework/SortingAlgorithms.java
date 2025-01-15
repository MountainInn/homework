package com.mountaininn.homework;

import java.util.Comparator;
import java.util.random.RandomGenerator;

public class SortingAlgorithms {

    /**
     * Входная точка для Comparator версии quicksort, без явного указания параметров low и high.
     * @param list Список который нужно отсортировать.
     * @param comparator Компаратор, используемый для сортировки.
     * @param <E> Дженерик тип элементов массива.
     */
    public static <E> void quickSort(MyArrayList<E> list, Comparator<E> comparator) {
        quickSort(list, 0, list.size()-1, comparator);
    }
    /**
     * Входная точка для Comparator версии quicksort.
     * @param list Список который нужно отсортировать.
     * @param low Начальный индекс диапазона для сортировки.
     * @param high Конечный индекс диапазона для сортировки.
     * @param comparator Компаратор, используемый для сортировки.
     * @param <E> Дженерик тип элементов массива.
     */
    public static <E> void quickSort(MyArrayList<E> list, int low, int high, Comparator<E> comparator) {
        if (low < high) {
            int p = partition(list, low, high, comparator);
            quickSort(list, low, p, comparator);
            quickSort(list, p + 1, high, comparator);
        }
    }
    /**
     * Версия quicksort, использующая Comparator.
     * @param list Список который нужно отсортировать.
     * @param low Начальный индекс диапазона для сортировки.
     * @param high Конечный индекс диапазона для сортировки.
     * @param comparator Компаратор, используемый для сортировки.
     * @return Возвращает индекс, делящий массив на две части.
     * @param <E> Дженерик тип элементов массива.
     */
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

    /**
     * Входная точка для Comparable версии quicksort, без явного указания параметров low и high.
     * @param myArrayList Список который нужно отсортировать.
     * @param <E> Дженерик тип элементов массива. Должен реализовывать Comparable<E>.
     */
    public static <E extends Comparable<E>> void quickSort(MyArrayList<E> myArrayList) {
        quickSort(myArrayList, 0, myArrayList.size()-1);
    }

    /**
     * Входная точка для Comparable версии quicksort.
     * @param list Список который нужно отсортировать.
     * @param low Начальный индекс диапазона для сортировки.
     * @param high Конечный индекс диапазона для сортировки.
     * @param <E> Дженерик тип элементов массива. Должен реализовывать Comparable<E>.
     */
    public static <E extends Comparable<E>> void quickSort(MyArrayList<E> list, int low, int high) {
        if (low < high) {
            int p = partition(list, low, high);
            quickSort(list, low, p);
            quickSort(list, p + 1, high);
        }
    }

    /**
     * Версия quicksort, использующая Comparable.
     * @param list Список который нужно отсортировать.
     * @param low Начальный индекс диапазона для сортировки.
     * @param high Конечный индекс диапазона для сортировки.
     * @return Возвращает индекс, делящий массив на две части.
     * @param <E> Дженерик тип элементов массива. Должен реализовывать Comparable<E>.
     */
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
