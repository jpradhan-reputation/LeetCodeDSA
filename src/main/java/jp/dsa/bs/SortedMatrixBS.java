package jp.dsa.bs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortedMatrixBS {
    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        String str = "Java";
        char[] charArr = str.toCharArray();
    }

    static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        return new int[] {-1, -1};
    }

    static int[] binarySearchIterative(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while (cStart <= cEnd) {
            int middle = cStart + (cEnd - cStart) / 2;
            if (target == matrix[row][middle])
                return new int[] {row, middle};
            if (target < matrix[row][middle])
                cEnd = middle - 1;
            else
                cStart = middle + 1;
        }
        return new int[] {-1, -1};
    }
}
