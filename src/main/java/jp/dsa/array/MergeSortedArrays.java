package jp.dsa.array;

import java.util.Arrays;

public class MergeSortedArrays {
    public static int[] mergeSortedArray(int[] arr1, int m, int[] arr2, int n) {
        int indexToInsert = m + n - 1;
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0; ) {
            if (i >= 0 && (j < 0 || arr1[i] >= arr2[j])) {
                arr1[indexToInsert] = arr1[i];
                i--;
            } else {
                arr1[indexToInsert] = arr2[j];
                j--;
            }
            indexToInsert--;
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 5, 7, 9, 0, 0, 0};
        int[] arr2 = new int[]{2, 4, 6};

        System.out.println("Merged sorted array:: " +
                Arrays.toString(mergeSortedArray(arr1, 5, arr2, 3)));
    }
}