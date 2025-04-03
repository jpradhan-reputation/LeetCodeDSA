package jp.dsa.sort;

import java.util.Arrays;

public class InsertionSort {
    // Insertion Sort
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)

    // Consider left array from index i is sorted
    // Iterate through the left array to find correct index to insert element
    // Keep swapping the left array until the correct index
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > val) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = val;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 9, 1, 27, 19, 13, 2, 5};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
