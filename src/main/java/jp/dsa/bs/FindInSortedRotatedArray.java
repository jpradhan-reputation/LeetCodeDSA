package jp.dsa.bs;

public class FindInSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 0, 1, 2}; // 6 (3)
        // int[] arr = {6, 0, 1, 2, 3, 4, 5}; // 6 (0)
        // int[] arr = {1, 2, 3, 4, 5, 6, 0}; // 6 (5)
        // int[] arr = {0, 1, 2, 3, 4, 5, 6}; // 6 (6)
        // int[] arr = {2, 3, 4, 5, 6, 0, 1}; // 6 (4)

        int target = 9;
        int peakIndex = searchPeakOfRotatedArray(arr);
        System.out.println("Peak Index: "+ peakIndex);
        int index = binarySearchIterative(arr, target, 0, peakIndex);
        if (index == -1)
            index = binarySearchIterative(arr, target, peakIndex + 1, arr.length - 1);
        if (index != -1)
            System.out.println(target + " is at index: " + index);
        else
            System.out.println(target + " is not found.");
    }

    static int searchPeakOfRotatedArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int middle = start + (end - start) / 2;

            if (middle < end && arr[middle] > arr[middle + 1])
                return middle;
            else if (middle > start && arr[middle] < arr[middle - 1])
                return middle - 1;

            if (arr[middle] < arr[start])
                end = middle - 1;
            else
                start = middle + 1;
        }
        return start;
    }

    static int binarySearchIterative(int[] arr, int target, int start, int end) {
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
