package jp.dsa.array;

import java.util.Arrays;

class DuplicateZeros {
    public static int[] duplicateZeros(int[] arr) {
        int zeroCount = 0;

        // Count the number of zeros in the array
        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
            }
        }

        int n = arr.length;
        int finalLength = n + zeroCount;

        // Traverse the array from the end and insert elements at their new positions
        for (int i = n - 1, j = finalLength - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                if (j < n) {
                    arr[j] = 0;
                }
                j--;
            }
            if (j < n) {
                arr[j] = arr[i];
            }
            j--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        System.out.println("After Duplicate Zeros:: " + Arrays.toString(duplicateZeros(arr)));
    }
}