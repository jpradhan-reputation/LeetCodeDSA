package jp.dsa.sort;

import java.util.Arrays;

public class CyclicSort {
    // Cyclic Sort
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    // Use this sorting algorithm to sort continuous array in a given range [0...n]
    // Iterate through the array and swap element with it's indexed element
    // If the element is its correct index, move the cursor
    private static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i) {
                BubbleSort.swap(arr, i, arr[i]);
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 9, 3, 4, 6, 0, 1, 2, 8, 5};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        cyclicSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
