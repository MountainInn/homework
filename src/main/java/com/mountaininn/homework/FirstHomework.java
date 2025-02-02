package com.mountaininn.homework;

import java.io.Console;
import java.io.IOError;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class FirstHomework {

    // Перевернуть строку и вывести на консоль
    //  String string = "I love Java";
    public static void turnString(String string) {
        String reversedString = new StringBuilder(string).reverse().toString();
        System.out.printf("\n%s -> %s%n", string, reversedString);
    }

    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] ints) {
        var distinctNumbers = Arrays.stream(ints)
                .distinct()
                .toArray();

        System.out.printf("Distinct numbers: %s", Arrays.toString(distinctNumbers));
    }

    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    public static Integer findSecondMaxElement(int[] arr) {
        int skipAmount = arr.length - 2;
        var result =
                Arrays.stream(arr)
                        .sorted()
                        .skip(skipAmount)
                        .limit(1)
                        .toArray();

        return result[0];
    }

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4
    public static Integer lengthOfLastWord(String string) {
        String[] words = string.split("\\s+");

        int lastIndex = words.length - 1;

        return words[lastIndex].length();
    }

    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true
    public static boolean isPalindrome(String string) {
        for (int i = 0; i < (string.length() - 1) / 2; i++) {
            int l = string.length() - 1 - i;

            if (string.charAt(i) != string.charAt(l))
                return false;
        }
        return true;
    }
}
