package com.nk.array_string;

/**
 * Implement a method to perform basic string compression using that counts of repeated characters.
 * <p>
 * Input: aabcccccaaa
 * Output: a2b1c5a3
 * <p>
 * if the compressed string would not become smaller than the original string, method should return the original string.
 */
public class StringCompression {

    // Time: O(n), Space:(n)
    public static String compress(String input) {
        //create string builder to store output
        StringBuilder output = new StringBuilder();
        //initialize counter with 1, assume that character would exist least once
        int counter = 1;
        for (int i = 0; i < input.length(); i++) {
            // Get Current character
            char currentChar = input.charAt(i);

            // check if next character index is less than input length
            // else store current character and counter
            if ((i + 1) < input.length()) {
                // get next character
                char nextChar = input.charAt(i + 1);
                //if current and next character are same, increment the counter
                // else store current character and counter and initialize counter to 1 for next different character
                if (currentChar == nextChar) {
                    counter++;
                } else {
                    output.append(currentChar).append(counter);
                    counter = 1;
                }
            } else {
                output.append(currentChar).append(counter);
            }
        }
        //System.out.println("Compressed String is : " + output);
        //return output if smaller than original else return original
        return output.length() <= input.length() ? output.toString() : input;
    }

    public static void main(String[] args) {
        String[] inputs = {"aabcccccaaa", "aabcccccaa", "aabcccdca", "c", "aa", "aaABBBBccDDaa"};

        for (String input : inputs) {
            System.out.println(input + ": After compressed: " + compress(input));
        }
    }
}
