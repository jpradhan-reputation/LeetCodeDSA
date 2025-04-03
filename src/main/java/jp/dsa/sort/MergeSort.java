package jp.dsa.sort;

import java.util.Arrays;


public class MergeSort {

    // Merge Sort
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)

    // Merge Sort follows the divide-and-conquer approach to sort a given array of elements.
    // Divide:  Divide the list or array recursively into two halves until it can no more be divided.
    // Conquer:  Each subarray is sorted individually using the merge sort algorithm.
    // Merge:  The sorted subarrays are merged back together in sorted order.
    // The process continues until all elements from both subarrays have been merged.
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int arl1 = middle - left + 1;
        int arl2 = right - middle;

        int[] arrL = new int[arl1];
        int[] arrR = new int[arl2];
        // Copy data to temp arrays
        for (int i = 0; i < arl1; ++i)
            arrL[i] = arr[left + i];
        for (int j = 0; j < arl2; ++j)
            arrR[j] = arr[middle + 1 + j];


        // Merge the temp arrays
        // Initial indices of first and second arrays
        int i = 0, j = 0;
        // Initial index of merged arrays
        int k = left;
        while (i < arl1 && j < arl2) {
            if (arrL[i] <= arrR[j]) {
                arr[k] = arrL[i];
                i++;
            }
            else {
                arr[k] = arrR[j];
                j++;
            }
            k++;
        }

        while (i < arl1) {
            arr[k] = arrL[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < arl2) {
            arr[k] = arrR[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 9, 3, 4, 6, 0, 1, 2, 8, 5};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
