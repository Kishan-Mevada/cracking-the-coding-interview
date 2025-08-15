package com.nk.array_string;

import java.util.Arrays;

/**
 * Write an algorithm such that if an element in an M*N matrix is 0, its entire row and column are set to 0
 * <p>
 * Examples:
 * <p>
 * input: [[1,1,1],[1,0,1],[1,1,1]]
 * output: [[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * input:  [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
public class ZeroMatrix {

    // Time: O(M*N), Space: O(1)
    //In this solution, we are setting Integer.MIN_VALUE to eligible row and col to set as 0
    public static void zeroMatrix(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (matrix[row][col] == 0) {
                    int i = row, j = col;
                    // Case1: decrement the row
                    while (--i >= 0 && matrix[i][col] != 0) {
                        matrix[i][col] = Integer.MIN_VALUE;
                    }
                    // Case2: decrement the column
                    while (--j >= 0 && matrix[row][j] != 0) {
                        matrix[row][j] = Integer.MIN_VALUE;
                    }

                    // reset i and j
                    i = row;
                    j = col;
                    // Case3: increment the row
                    while (++i < rowLength && matrix[i][col] != 0) {
                        matrix[i][col] = Integer.MIN_VALUE;
                    }
                    // Case4: increment the column
                    while (++j < colLength && matrix[row][j] != 0) {
                        matrix[row][j] = Integer.MIN_VALUE;
                    }
                }
            }
        }

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (matrix[row][col] == Integer.MIN_VALUE) {
                    matrix[row][col] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    // Time: O(M * N), Space: O(1)
    // Solution without marking eligible row and column with arbitrary value
    public static void zeroMatrix1(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        boolean zeroOnFirstRow = false, zeroOnFirstCol = false;

        for (int row = 0; row < rowLength; row++) {
            if (matrix[row][0] == 0) {
                zeroOnFirstCol = true;
                break;
            }
        }

        for (int col = 0; col < colLength; col++) {
            if (matrix[0][col] == 0) {
                zeroOnFirstRow = true;
                break;
            }
        }

        for (int row = 1; row < rowLength; row++) {
            for (int col = 1; col < colLength; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < rowLength; row++) {
            for (int col = 1; col < colLength; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (zeroOnFirstRow) {
            for (int col = 0; col < colLength; col++) {
                matrix[0][col] = 0;
            }
        }

        if (zeroOnFirstCol) {
            for (int row = 0; row < rowLength; row++) {
                matrix[row][0] = 0;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        System.out.println("==== Solution 1 ====\n");
        zeroMatrix(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        zeroMatrix(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});

        System.out.println("\n==== Solution 2 ====");
        zeroMatrix1(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        zeroMatrix1(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }
}
