package com.nk.array_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * <p>
 * Input: Tact Coa
 * Output: True (permutations: 'taco cat', 'atco cta', etc.)
 */
public class PalindromePermutation {

    /**
     * 1. Check if input is valid
     * 2. Create map to store count of each character
     * 3. Iterate input and get one by one character (convert to lower)
     * 4. Put character into map and compute count
     * 5. if more than one odd found then it's not permutation of palindrome else it is.
     * <p>
     * Time: O(n), Space: O(n) for map
     */
    public static boolean isPalindromePermutation_Map(String input) {
        if (input == null || input.isBlank()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = Character.toLowerCase(input.charAt(i));
            if (c != ' ') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }


        long oddCount = map.values().stream().filter(count -> count % 2 == 1).count();

        return oddCount <= 1;
    }

    /**
     * 1. Check if input is valid
     * 2. Create count array of 26 length
     * 3. Iterate input and get one by one character (convert to lower)
     * 4. increment the character index  (to get correct index char - 'a')
     * 5. if more than one odd found then it's not permutation of palindrome else it is.
     * <p>
     * Time: O(n), Space: O(26) for map
     */
    public static boolean isPalindromePermutation_CountArray(String input) {
        if (input == null || input.isBlank()) return false;

        final int[] NO_OF_CHARS = new int[26];
        for (int i = 0; i < input.length(); i++) {
            char c = Character.toLowerCase(input.charAt(i));
            if (c != ' ') {
                NO_OF_CHARS[c - 'a']++;
            }
        }

        long count = Arrays.stream(NO_OF_CHARS).filter(charCount -> charCount % 2 == 1).count();

        return count <= 1;
    }

    /**
     * Bit Vector approach
     * <p>
     * Time: O(n), Space: (1)
     */
    public static boolean isPalindromePermutation_BitVector(String input) {
        if (input == null || input.isBlank()) return false;

        int bitVector = 0, mask;
        for (int i = 0; i < input.length(); i++) {
            int x = Character.toLowerCase(input.charAt(i)) - 'a';

            mask = 1 << x;

            bitVector = bitVector ^ mask;
        }

        return (bitVector & (bitVector - 1)) == 0;
    }

    public static void main(String[] args) {
        String[] inputs = {"abab", "aabaa", "abcab", "abcdab", "ababa", "acacacb"};

        System.out.println("======Map Solution======");
        Arrays.stream(inputs)
                .forEach(input -> {
                    String output = """
                            %s is Palindrome Permutation: Map: %b, CounterArray: %b, BitVector: %b
                            """;
                    System.out.printf((output) + "%n", input,
                            isPalindromePermutation_Map(input),
                            isPalindromePermutation_CountArray(input),
                            isPalindromePermutation_BitVector(input));

                });


    }

}
