package jp.dsa.array;

import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] arr = {1, 0, 3};
        System.out.println("After sorting by Parity:: " + Arrays.toString(sortArrayByParity(arr)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }

            while (left < right && nums[right] % 2 != 0) {
                right--;
            }

            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}
