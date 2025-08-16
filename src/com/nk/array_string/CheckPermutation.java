package com.nk.array_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class CheckPermutation {

    /**
     * 1. Validate the both strings input
     * 2. Convert both strings into char array
     * 3. Sort the both char arrays
     * 4. compare element of both char arrays
     * <p>
     * Time: O (n log n), Space: (1)
     */
    public static boolean arePermutation_Sort(String s1, String s2) {
        // validate the input
        if (isNotValid(s1, s2)) {
            return false;
        }
        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();
        Arrays.sort(s1CharArray);
        Arrays.sort(s2CharArray);

       /* Iterative way
       for (int i = 0; i < s1.length(); i++) {
            if (s1CharArray[i] != s2CharArray[i]) {
                return false;
            }
        }*/

        return IntStream.range(0, s1.length())
                .noneMatch(i -> s1CharArray[i] != s2CharArray[i]);

    }

    /**
     * 1. Validate the both strings input
     * 2. Put string1 character into map
     * 3. check string2 character in map
     * <p>
     * Time: O(n), Space: O(n)
     */
    public static boolean arePermutation_Map(String s1, String s2) {
        if (isNotValid(s1, s2)) {
            return false;
        }
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), true);
        }

        /* Iterative
        for (int i = 0; i < s2.length(); i++) {
            if (map.get(s2.charAt(i)) == null) {
                return false;
            }
        }*/

        return IntStream.range(0,s2.length())
                .noneMatch(i -> map.get(s2.charAt(i)) == null);

    }

    /**
     * 1. Valid the both strings input
     * 2. Create count array of 256 length
     * 3. Increment the character index of string1 and decrement the character index of string2
     * 4. check if any index has a value other than 0
     * <p>
     * Time: O(n), Space: O(n)
     */
    public static boolean arePermutation_Count(String s1, String s2) {
        if (isNotValid(s1, s2)) {
            return false;
        }

        final int NO_OF_CHARS = 256;

        int[] count = new int[NO_OF_CHARS];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int i = 0; i < NO_OF_CHARS; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNotValid(String s1, String s2) {
        return s1 == null || s2 == null || s1.isBlank() || s2.isBlank() || s1.length() != s2.length();
    }

    public static void main(String[] args) {
        String s1 = "acb";
        String s2 = "bac";
        String s3 = "adbc";
        String s4 = "";
        String s5 = "adc";

        System.out.println("=====Solution 1: Convert and Sort Array and compare====");
        System.out.println("s2 is permutation of s1: " + arePermutation_Sort(s1, s2));
        System.out.println("s3 is permutation of s1: " + arePermutation_Sort(s1, s3));
        System.out.println("s4 is permutation of s1: " + arePermutation_Sort(s1, s4));
        System.out.println("s5 is permutation of s1: " + arePermutation_Sort(s1, s5));

        System.out.println("\n=====Solution 2: Convert S1 to map and check s2 character in map ====");
        System.out.println("s2 is permutation of s1: " + arePermutation_Map(s1, s2));
        System.out.println("s3 is permutation of s1: " + arePermutation_Map(s1, s3));
        System.out.println("s4 is permutation of s1: " + arePermutation_Map(s1, s4));
        System.out.println("s5 is permutation of s1: " + arePermutation_Map(s1, s5));

        System.out.println("\n=====Solution 3: Increment / Decrement count index for both string char ====");
        System.out.println("s2 is permutation of s1: " + arePermutation_Count(s1, s2));
        System.out.println("s3 is permutation of s1: " + arePermutation_Count(s1, s3));
        System.out.println("s4 is permutation of s1: " + arePermutation_Count(s1, s4));
        System.out.println("s5 is permutation of s1: " + arePermutation_Count(s1, s5));
    }
}
