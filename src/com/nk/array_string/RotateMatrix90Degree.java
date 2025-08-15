package com.nk.array_string;

import java.util.Arrays;

/**
 * Given an image represented by N*N matrix, where each pixel in the image is 4 byte
 * write a method to rotate the image by 90 degrees.
 * Examples:
 * input: [[1,2,3],[4,5,6],[7,8,9]]
 * output: [[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * input: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * output: [[15,13,2,5],[14,3,4,1],[12,6,8,1],[16,7,10,11]]
 */
public class RotateMatrix90Degree {

    // Time: O(n), Space: O(n) for output matrix
    public static void rotate90Degree(int[][] matrix) {
        int length = matrix.length;
        int[][] output = new int[length][length];

        int oRow, oCol = 0;
        for (int row = 0; row < length; row++) {
            oRow = row;
            for (int col = length - 1; col >= 0; col--) {
                output[oRow][oCol++] = matrix[col][row];
            }
            oCol = 0;
        }

        System.out.println(Arrays.deepToString(output));
    }

    //Time: O(n2), Space: O(1)
    public static void rotate90Degree_InPlace(int[][] matrix) {
        int length = matrix.length;

        //transpose the matrix
        for (int row = 0; row < length; row++) {
            for (int col = row + 1; col < length; col++) {
                int temp = matrix[col][row];
                matrix[col][row] = matrix[row][col];
                matrix[row][col] = temp;
            }
        }

        // reverse the matrix
        for(int i = 0; i < length; i++) {
            int start = 0, end = length - 1;
            while(start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

        rotate90Degree_InPlace(matrix1);
        rotate90Degree_InPlace(matrix2);
    }
}
