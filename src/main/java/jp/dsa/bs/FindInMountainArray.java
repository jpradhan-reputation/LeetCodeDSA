package jp.dsa.bs;

public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 5, 4, 3, 2};
        // {1, 2, 5, 6, 7, 8, 9, 3}; -> 2 (1)
        // {1, 2, 5, 6, 5, 4, 3, 2}; -> 4 (5)
        // {1, 2, 5, 6, 5, 4, 3, 2}; -> 3 (6)
        // {1, 10, 8, 7, 5, 3, 2, 1}; -> 10 (1)

        int target = 3; // 2 (1)
        int peakIndex = searchPeakOfMountainArray(arr);
        int index = orderAgnosticBinarySearch(arr, target, 0, peakIndex);
        if (index == -1)
            index = orderAgnosticBinarySearch(arr, target, peakIndex, arr.length - 1);
        if (index != -1)
            System.out.println(target + " is at index: " + index);
        else
            System.out.println(target + " is not found.");
    }

    static int searchPeakOfMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] > arr[middle + 1])
                end = middle;
            else
                start = middle + 1;
        }
        return start;
    }

    static int orderAgnosticBinarySearch(int[] arr, int target, int start, int end) {
        // Check the order of the array
        boolean ascending = arr[start] < arr[end];

        // Perform binary search based on the order
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (ascending) {
                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        // If element is not found, return -1
        return -1;
    }
}
