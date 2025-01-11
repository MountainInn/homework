package com.mountaininn.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Личная реализация класса ArrayList<E>.
 *
 * @param <E> Тип элементов массива
 * @author MountainInn (Зиятдинов Евгений)
 */
public class MyArrayList<E> {
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

    public MyArrayList(E[] array) {
        this.array = array;
        this.size = array.length;
    }

    /**
     * Добавляет элемент в конец массива, предварительно проверяя, достаточно ли в массиве места.
     * Если недостаточно, то создается новый массив увеличенной длины, с копированием элементов из старого массива.
     *
     * @param element Объект для добавления в конец массива
     */
    public void add(E element) {
        maybeGrowTo(size);
        array[size] = element;
        size++;
    }

    /**
     * Добавляет элемент в массив по указанному индексу, сдвигая элементы вправо, чтобы освободить место.
     * Расширяет подлежащий массив, если index указывает на последний элемент.
     *
     * @param index   - индекс, по которому добавляется новый элемент
     * @param element - элемент для добавления
     * @throws IndexOutOfBoundsException если index меньше 0 или больше чем длина подлежащего массива
     */
    public void add(int index, E element) {
        if (index < 0 || isOutOfBounds(index))
            throw new IndexOutOfBoundsException();

        maybeGrowTo(index + 1);

        int shiftLength = (capacity() - 1 - index);
        System.arraycopy(array, index, array, index + 1, shiftLength);

        array[index] = element;
        size++;
    }

    /**
     * Удаляет элемент по указанному индексу и возвращает его.
     * Сдвигает элементы влево, чтобы не оставить пустой ячейки.
     *
     * @param index Индекс для удаления элемента.
     * @throws IndexOutOfBoundsException
     */
    public E remove(int index) {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        E result = (E) array[index];

        int shiftLength = (capacity() - 1 - index);
        System.arraycopy(array, index + 1, array, index, shiftLength);

        size--;
        array[size] = null;

        return result;
    }

    /**
     * Метод для получения элемента по индексу.
     *
     * @param index Индекс элемента, который хотим получить.
     * @return Объект по заданному индексу, либо null, если индекс за пределами массива.
     * @throws IndexOutOfBoundsException
     */
    public E get(int index) {
        if (index < 0 || isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    /**
     * Вставляет элемент по указанному индексу с заменой предыдущего значения.
     *
     * @param index   Индекс по которому вставляем элемент
     * @param element Элемент для вставки
     */
    public void set(int index, E element) {
        if (index < 0 || isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = element;
    }


    /**
     * Проверяет что индекс входит в диапазон от 0 до длины подлежащего массива.
     *
     * @param index индекс, который мы проверяем.
     * @return true - если входит в диапазон, если нет - false.
     */
    private boolean isOutOfBounds(int index) {
        return (index < 0 || index >= capacity());
    }

    /**
     * Проверяет нужно ли расширить массив и, если да - расширяет его.
     *
     * @param requiredCapacity Необходимая длина массива.
     *                         Если превосходит текущую capacity, то массив расширяется.
     */
    private void maybeGrowTo(int requiredCapacity) {
        if (requiredCapacity >= capacity()) {
            grow(requiredCapacity);
        }
    }

    /**
     * Умножает длину массива на 1.5, до тех пор пока requiredCapacity не войдет в эту длину.
     * Создает новый массив увеличенной длины, с копированием элементов из старого массива.
     *
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
     *
     * @param comparator Компаратор элементов массива.
     */
    public void sort(Comparator<E> comparator) {
        Arrays.sort((E[]) array, comparator);
    }

    /**
     * @return Копия подлежащего массива.
     */
    public E[] toArray() {
        return (E[]) array.clone();
    }

    @Override
    public String toString() {
        return Arrays
                .stream(array)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}

