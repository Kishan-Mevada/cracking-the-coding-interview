package com.nk.array_string;

/**
 * Write code to check if s2 is a rotation of s1 using only one call to is Substring
 * <p>
 * eg: "waterbottle" is a rotation of "erbottlewat"
 */
public class StringRotation {

    // Time: O(n), Space: O(1)
    public static boolean areRotation(String s1, String s2) {
        int length = s1.length();
        if (length != s2.length()) return false;
        boolean hasRotationFound = false;
        for (int i = 0; i < length && !hasRotationFound; i++) {
            //check if first character of s1 is same as ith character of s2
            if (s1.charAt(0) == s2.charAt(i)) {
                //compare left part of s1 with right part of s2
                // if i at last index then only one character is rotated
                // else compare right part of s1 with left part of s2
                boolean leftPartMatched = s1.substring(0, length - i).equals(s2.substring(i));
                if (i == length - 1) {
                    hasRotationFound = leftPartMatched;
                } else {
                    hasRotationFound = leftPartMatched &&
                            s1.substring(length - i).equals(s2.substring(0, i));
                }
            }
        }
        return hasRotationFound;
    }

    public static void main(String[] args) {
        String s1 = "waterbottle", s2 = "erbottlewat", s5 = "aterbottlew";
        String s3 = "abcd", s4 = "acbd";
        String s6 = "aab", s7 = "aba";
        System.out.println(s2 + " is rotation of " + s1 + " : " + areRotation(s1, s2));
        System.out.println(s5 + " is rotation of " + s1 + " : " + areRotation(s1, s5));
        System.out.println(s4 + " is rotation of " + s3 + " : " + areRotation(s3, s4));
        System.out.println(s7 + " is rotation of " + s6 + " : " + areRotation(s7, s6));
    }
}
