package jp.dsa.array;

import java.util.Arrays;

public class SpecialArray {

    public static void main(String[] args) {
        int[] nums = {0,4,3,0,4}; //[0, 0, 3, 4, 4]
        System.out.println(specialArray(nums)); // Example usage
    }

    public static int specialArray(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];

        // Count the number of elements >= i
        for (int num : nums) {
            if (num >= n) {
                count[n]++; // Anything greater than n is counted in the 'n' bucket
            } else {
                count[num]++;
            }
        }

        // Calculate how many elements are >= i by accumulating from the back
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += count[i];
            if (total == i) {
                return i; // If the number of elements >= i equals i, return i
            }
        }

        return -1; // No special number found
    }
}