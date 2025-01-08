package com.mountaininn.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    MyArrayList<Integer> arrayList;

    @BeforeEach
    void setUp() {
        arrayList = new MyArrayList<>(10);
    }

    @Test
    void capacity() {
        int a = arrayList.capacity();

        assertEquals(10, a);

        for (int i = 0; i < 11; i++) {
            arrayList.add(1);
        }

        a = arrayList.capacity();

        assertEquals(15, a);
    }

    @Test
    void size() {
        int a = arrayList.size();

        assertEquals(0, a);

        arrayList.add(1);
        arrayList.add(1);

        a = arrayList.size();

        assertEquals(2, a);
    }

    @Test
    void add() {
        Integer[] example = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 1; i <= 10; i++) {
            arrayList.add(i);
        }

        assertArrayEquals(example, arrayList.toArray());
    }

    @Test
    void testAdd() {
        ArrayList<Integer> example = new ArrayList<>(15);

        for (int i = 1; i <= 10; i++) {
            if (i != 5 && i != 10) {
                arrayList.add(i);
            }
            example.add(i);
        }
        assertEquals(10, arrayList.capacity());

        arrayList.add(4, 5);
        arrayList.add(9, 10);

        for (int i = 0; i < 5; i++) {
            example.add(i, i);
            arrayList.add(i, i);
        }

        assertArrayEquals(example.toArray(), arrayList.toArray());
    }

    @Test
    void get() {
        arrayList.add(3, 3);

        assertEquals(3, arrayList.get(3));
    }

    @Test
    void set() {
        arrayList.add(3, 3);
        assertEquals(3, arrayList.get(3));

        arrayList.set(3, 4);
        assertEquals(4, arrayList.get(3));
    }

    @Test
    void remove() {
        Integer[] example = new Integer[]{1, 2, 3, 4, 5, 6, 7, 9, 10, null};

        for (int i = 1; i <= 10; i++) {
            arrayList.add(i);
        }

        arrayList.remove(7);

        assertArrayEquals(example, arrayList.toArray());
    }

    @Test
    void clear() {
        for (int i = 1; i <= 10; i++) {
            arrayList.add(i);
        }

        assertEquals(10, arrayList.size());

        arrayList.clear();

        assertEquals(0, arrayList.size());

        for (int i = 0; i < 10; i++) {
            assertNull(arrayList.get(i));
        }
    }

    @Test
    void sort() {
        Integer[] example = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 10; i > 0; i--) {
            arrayList.add(i);
        }

        arrayList.sort(new MyIntegerComparator());

        assertArrayEquals(example, arrayList.toArray());
    }
}