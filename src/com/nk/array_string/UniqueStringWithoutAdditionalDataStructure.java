package com.nk.array_string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1.1: Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structure.?
 * <p>
 * null or empty string could be considered unique or not, here I am considering not unique
 */
public class UniqueStringWithoutAdditionalDataStructure {

    // Time: O(N), Space: O(26)
    // This will fail if string has non-alphabetic character
    public static boolean isUnique(String input) {

        if (input == null || input.isBlank()) {
            return false;
        }

        boolean[] uniqueChars = new boolean[26];
        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            int codePoint = input.codePointAt(i) - 65;

            if (codePoint < 0) {
                return false;
            }

            if (!uniqueChars[codePoint]) {
                uniqueChars[codePoint] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    // Time: O(n log n), Space: O(1)
    public static boolean isUnique1(String input) {
        if (input == null || input.isBlank()) {
            return false;
        }

        Set<Character> uniqueSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (!uniqueSet.add(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Time: O(n log n) for sort, Space: O(1)
    public static boolean isUnique2(String input) {
        if (input == null || input.isBlank()) {
            return false;
        }
        char[] chars = input.toUpperCase().toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; i++) {
            if(chars[i] == chars[i+1]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s1 = "string";
        String s2 = "Spaces";
        String s3 = null;
        String s4 = "12345Abc";

        System.out.println(s1 + ": Is All Unique characters: " + isUnique2(s1));
        System.out.println(s2 + ": Is All Unique characters: " + isUnique2(s2));
        System.out.println(s3 + ": Is All Unique characters: " + isUnique2(s3));
        System.out.println(s4 + ": Is All Unique characters: " + isUnique2(s4));
    }

}
