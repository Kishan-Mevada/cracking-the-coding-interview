package com.nk.array_string;

import java.util.Arrays;

/**
 * There are three types of edits that can be performed on strings:
 * insert a character
 * remove a character
 * replace a character.
 * <p>
 * Given two strings, write a function to check if they are one (or zero) edit away.
 */
public class OneAway {

    /**
     * 1. Validate the input parameters
     * 2. if difference between both string is greater than 1 character then it always more than 1 edit away
     * 3. Initialize the char counter array of size 26
     * 4. Get  1 by 1 character from input1 and do decrement, from input2 do increment
     * 5. Count how many indexes have more than 0 character
     * 6. if count is 0 or 1 then its one edit away or more than one.
     * <p>
     * Time: O(n), Space: O(26)
     */
    public static boolean isZeroOrOneEditAway_CounterArray(String s, String s1) {
        if (s == null || s.isBlank() || s1 == null || s1.isBlank() || Math.abs(s.length() - s1.length()) > 1)
            return false;

        if(s.length() < s1.length()) {
            return isZeroOrOneEditAway_CounterArray(s1, s);
        }

        int[] charsCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c1 = Character.toLowerCase(s.charAt(i));

            charsCount[c1 - 'a']++;

            if (i < s1.length()) {
                char c2 = Character.toLowerCase(s1.charAt(i));
                charsCount[c2 - 'a']--;
            }
        }

        long countNonZero = Arrays.stream(charsCount).filter(count -> count > 0).count();

        return countNonZero <= 1;
    }

    /**
     * 1. Validate the input parameters
     * 2. check if s1 length is greater than s, then swap input and check
     * 3. if character at same index of both string are different:
     *      if length is same then remaining character should match  else
     *      remaining longer string must be equal to the shorter string
     * 4. check the case where one extra character at the end of the longer string
     * <p>
     * Time: O(n), Space: O(1)
     */
    public static boolean isZeroOrOneEditAway(String s, String s1) {
        if (s == null || s.isBlank() || s1 == null || s1.isBlank() || Math.abs(s.length() - s1.length()) > 1)
            return false;

       int sLength = s.length(), s1Length = s1.length();

       if(sLength < s1Length) {
           return isZeroOrOneEditAway(s1,s);
       }

       for(int i = 0; i < s1Length; i++) {
           if(s.charAt(i) != s1.charAt(i)) {
               if(sLength == s1Length) {
                   return s.substring(i+1).equals(s1.substring(i+1));
               }
               return s.substring(i+1).equals(s1.substring(i));
           }
       }

       return sLength == s1Length + 1;
    }


    public static void main(String[] args) {
        String s1 = "pale", s2 = "ple", s3 = "pales", s4 = "bale", s5 = "bake", s6 = "pl";

        System.out.println("==== Effective Solution ====");
        System.out.println("Is " + s1 + " and " + s2 + " One Edits Away: " + isZeroOrOneEditAway(s1, s2));
        System.out.println("Is " + s3 + " and " + s1 + " One Edits Away: " + isZeroOrOneEditAway(s3, s1));
        System.out.println("Is " + s1 + " and " + s4 + " One Edits Away: " + isZeroOrOneEditAway(s1, s4));
        System.out.println("Is " + s1 + " and " + s5 + " One Edits Away: " + isZeroOrOneEditAway(s1, s5));
        System.out.println("Is " + s1 + " and " + s6 + " One Edits Away: " + isZeroOrOneEditAway(s1, s6));

        System.out.println("-".repeat(30));

        System.out.println("==== Counter Array Solution ====");
        System.out.println("Is " + s1 + " and " + s2 + " One Edits Away: " + isZeroOrOneEditAway_CounterArray(s1, s2));
        System.out.println("Is " + s3 + " and " + s1 + " One Edits Away: " + isZeroOrOneEditAway_CounterArray(s3, s1));
        System.out.println("Is " + s1 + " and " + s4 + " One Edits Away: " + isZeroOrOneEditAway_CounterArray(s1, s4));
        System.out.println("Is " + s1 + " and " + s5 + " One Edits Away: " + isZeroOrOneEditAway_CounterArray(s1, s5));
        System.out.println("Is " + s1 + " and " + s6 + " One Edits Away: " + isZeroOrOneEditAway_CounterArray(s1, s6));

    }
}
