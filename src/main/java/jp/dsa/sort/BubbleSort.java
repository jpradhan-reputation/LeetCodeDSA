package jp.dsa.sort;

import java.util.Arrays;

public class BubbleSort {
    // Bubble Sort
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)

    // Iterate through the array and compare the adjacent elements
    // Move the largest to the end step by step
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) { // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            // break if no element are swapped
            if (!swapped) {
                System.out.println("No element swapped in " + (i + 1) + " iteration");
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 9, 1, 27, 19, 13, 29, 35};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
