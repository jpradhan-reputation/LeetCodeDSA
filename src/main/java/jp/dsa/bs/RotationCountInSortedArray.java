package jp.dsa.bs;

public class RotationCountInSortedArray {
    public static void main(String[] args) {
        //int[] arr = {3, 4, 5, 6, 0, 1, 2}; // 6 (3)
        //int[] arr = {6, 0, 1, 2, 3, 4, 5}; // 6 (0)
        //int[] arr = {1, 2, 3, 4, 5, 6, 0}; // 6 (5)
        //int[] arr = {0, 1, 2, 3, 4, 5, 6}; // 6 (6)
        int[] arr = {2, 3, 4, 5, 6, 0, 1}; // 6 (4)

        int pivotIndex = searchPeakOfRotatedArray(arr);
        System.out.println("Pivot Index: "+ pivotIndex);
        System.out.println("Array is Rotated " + ((pivotIndex + 1) % arr.length)  +" times");
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
}
