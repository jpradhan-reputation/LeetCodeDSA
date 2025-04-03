package jp.dsa.bs;

import java.util.Arrays;

public class RowColMatrixBS {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {11, 22, 33, 44},
                {12, 24, 35, 45},
                {15, 27, 39, 50},
        };
        int target = 27;
        System.out.println("Target is at: "+ Arrays.toString(search(matrix, target)));
    }

    static int[] search(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return new int[] {row, col};
            if (matrix[row][col] < target)
                row++;
            else
                col--;
        }
        return new int[] {-1, -1};
    }
}
