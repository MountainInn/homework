package com.mountaininn.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstHomeworkTest {

    @Test
    void turnString() {
        FirstHomework.turnString("I love Java");
    }

    @Test
    void getDistinctNumbers() {
        int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
        FirstHomework.getDistinctNumbers(ints);
    }

    @Test
    void findSecondMaxElement() {
        int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
        Integer secondMax = FirstHomework.findSecondMaxElement(arr);
        assertEquals(47, secondMax);
    }

    @Test
    void lengthOfLastWord() {
        assertEquals(5, FirstHomework.lengthOfLastWord("Hello world"));
        assertEquals(4, FirstHomework.lengthOfLastWord("    fly me    to the moon    "));
    }

    @Test
    void isPalindrome() {
        assertFalse(FirstHomework.isPalindrome("abc"));
        assertFalse(FirstHomework.isPalindrome("112233"));

        assertTrue(FirstHomework.isPalindrome("aba"));
        assertTrue(FirstHomework.isPalindrome("112211"));
        assertTrue(FirstHomework.isPalindrome("racecar"));
    }
}