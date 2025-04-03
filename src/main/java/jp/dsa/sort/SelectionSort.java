package jp.dsa.sort;

import java.util.Arrays;

public class SelectionSort {
    // Selection Sort
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)

    // Consider ith index has the min element
    // Iterate through the rest of the array to find min element
    // Swap the ith element with the min index element
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }
            BubbleSort.swap(arr, i, min_index);
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 9, 1, 27, 19, 13, 2, 5};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
