package com.nk.array_string;

/**
 * Write method to replace all spaces in a string with '%20'.
 * <p>
 * input: "Mr John Smith    "
 * Output: "Mr%20John%20Smith"
 */
public class URLify {

    /**
     *  Note: In this solution we assume that we are going to get input length same as required for output.
     *  like "Mr John Smith    " (4 extra space at the end)
     *  <p>
     *  Time: O(N), Space: (1)
     */
    public static String doUrlify(String input) {
        char[] chars = input.toCharArray();
        int fIndex = chars.length - 1; // fill the chars array index

        for (int i = fIndex; i >= 0; i--) {
            if (chars[i] == ' ' && fIndex != chars.length - 1) {
                chars[fIndex--] = '0';
                chars[fIndex--] = '2';
                chars[fIndex--] = '%';
            } else if (chars[i] != ' ') {
                chars[fIndex--] = chars[i];
            }
        }

        return String.valueOf(chars);
    }

    /**
     *  We will use StringBuilder to build new string where space replace with %20
     *  <p>
     *  Time: O(N), Space: O(N)
     */
    public static String doUrlify_SpringBuilder(String input) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input.trim().length(); i++) {
            if(input.charAt(i) == ' '){
                sb.append("%20");
            }
            else {
                sb.append(input.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "Mr John Smith    ";
        System.out.println("Urlify (Solution1): " + doUrlify(input));


        System.out.println("Urlify (Solution2): " + doUrlify_SpringBuilder(input));

    }
}
