package jp.dsa.bs;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 9, 23, 56, 78};
        int target = 9;
        int index = binarySearchIterative(arr, target);
        // int index = binarySearchRecursive(arr, 0, arr.length - 1, target);
        if (index != -1)
            System.out.println(target + " is at index: " + index);
        else
            System.out.println(target + " is not found.");
    }

    // best time: O(log n)
    // worst space: O(log n)
    static int binarySearchRecursive(int[] arr, int start, int end, int target) {
        int middle = (start + end) / 2;
        if (start <= end) {
            if (target == arr[middle])
                return middle;

            if (target < arr[middle])
                return binarySearchRecursive(arr, start, middle - 1, target);
            else
                return binarySearchRecursive(arr, middle + 1, end, target);
        }
        return -1;
    }

    // best time: O(log n)
    // best space: O(1)
    static int binarySearchIterative(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (target == arr[middle])
                return middle;
            if (target < arr[middle])
                end = middle - 1;
            else
                start = middle + 1;
        }
        return -1;
    }
}
