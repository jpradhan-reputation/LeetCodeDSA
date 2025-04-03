package jp.dsa.bs;

public class PeakOfMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 7, 8, 9, 3}; // 5 (1)
        // {1, 2, 5, 6, 7, 8, 9, 3}; -> 9 (6)
        // {1, 2, 5, 6, 5, 4, 3, 2}; -> 6 (3)
        // {1, 10, 8, 7, 5, 3, 2, 1}; -> 10 (1)
        System.out.println("Peak of Mountain Array is at index: " + searchPeakOfMountainArray(arr));
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
}

