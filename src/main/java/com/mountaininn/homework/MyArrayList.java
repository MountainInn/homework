package com.mountaininn.homework;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Личная реализация класса ArrayList<T>.
 * @author MountainInn (Зиятдинов Евгений)
 * @param <T> Тип элементов массива
 */
public class MyArrayList<T> {
    private Object[] array;
    private int size;

    /**
     * @return Поле length подлежащего массива
     */
    public int capacity() {
        return array.length;
    }

    /**
     * @return Количество елементов в MyArrayList
     */
    public int size() {
        return size;
    }

    /**
     * @param length Начальная длина массива
     */
    public MyArrayList(int length) {
        array = new Object[length];
    }

    public MyArrayList(T[] array){
        this.array = array;
    }

    /**
     * Добавляет элемент в конец массива, предварительно проверяя, достаточно ли в массиве места.
     * Если недостаточно, то создается новый массив увеличенной длины, с копированием элементов из старого массива.
     * @param element Объект для добавления в конец массива
     */
    public void add(T element) {
        maybeGrowTo(size);
        array[size] = element;
        size++;
    }

    /**
     * Добавляет элемент в массив по указанному индексу, сдвигая элементы вправо, чтобы освободить место.
     * Расширяет подлежащий массив, если index или size превосходят capacity.
     * @param index - индекс, по которому добавляется новый элемент
     * @param element - элемент для добавления
     */
    public void add(int index, T element) {
        int preferredLength = Math.max(index, size);
        maybeGrowTo(preferredLength);

        int shiftLength = (capacity() - 1 - index);
        System.arraycopy(array, index, array, index + 1, shiftLength);

        array[index] = element;
        size++;
    }

    /**
     * Метод для получения элемента по индексу.
     * @param index Индекс элемента, который хотим получить.
     * @return Объект по заданному индексу, либо null, если индекс за пределами массива.
     */
    public T get(int index) {
        if (isOutOfBounds(index)) {
            return null;
        }
        return (T) array[index];
    }

    /**
     * Вставляет элемент по указанному индексу с заменой предыдущего значения.
     * @param index Индекс по которому вставляем элемент
     * @param element Элемент для вставки
     */
    public void set(int index, T element) {
        maybeGrowTo(index);
        array[index] = element;
    }

    /**
     * Проверяет нужно ли расширить массив и, если да - расширяет его.
     * @param preferredCapacity Необходимая длина массива.
     *                          Если превосходит текущую capacity, то массив расширяется.
     */
    private void maybeGrowTo(int preferredCapacity) {
        if (isOutOfBounds(preferredCapacity)) {
            grow(preferredCapacity);
        }
    }

    /**
     * Проверяет, входит ли указанный индекс в capacity массива.
     * @param index индекс, который мы проверяем
     * @return true - если индекс >= capacity, в другом случае - false
     */
    private boolean isOutOfBounds(int index) {
        return (index >= capacity());
    }

    /**
     * Умножает длину массива на 1.5, до тех пор пока requiredCapacity не войдет в эту длину.
     * Создает новый массив увеличенной длины, с копированием элементов из старого массива.
     * @param requiredCapacity Длина, которую мы хотим получить от массива
     */
    private void grow(int requiredCapacity) {
        int newCapacity = capacity();
        do {
            newCapacity = (int) (newCapacity * 1.5);
        }
        while (newCapacity < requiredCapacity);

        array = Arrays.copyOf(array, newCapacity);
    }

    /**
     * Удаляет элемент по указанному индексу.
     * Сдвигает элементы влево, чтобы не оставить пустой ячейки.
     * Если индекс за пределами массива, то ничего не делает.
     * @param index Индекс для удаления элемента.
     */
    public void remove(int index) {
        if (isOutOfBounds(index)) {
            return;
        }

        int shiftLength = (capacity() - 1 - index);
        System.arraycopy(array, index + 1, array, index, shiftLength);

        size--;
        array[size] = null;
    }

    /**
     * Заполняет все ячейки массива null'ами.
     * Поле size становится 0.
     * Длина массива не меняется.
     */
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    /**
     * Сортирует массив, используя comparator.
     * @param comparator Компаратор элементов массива.
     */
    public void sort(Comparator<T> comparator) {
        Arrays.sort((T[]) array, comparator);
    }

    /**
     * @return Копия подлежащего массива.
     */
    public T[] toArray() {
        return (T[]) array.clone();
    }
}

