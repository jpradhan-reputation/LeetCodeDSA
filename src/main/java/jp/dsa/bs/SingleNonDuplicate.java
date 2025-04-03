package jp.dsa.bs;

public class SingleNonDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 4, 4, 8, 8};
        int nonDuplicateNum = singleNonDuplicate(nums);
        System.out.println("Single Non-Duplicate Num in Sorted Array is: "+ nonDuplicateNum);
    }

    /**
     * In this method we will search for a Single Non-Duplicate Num in the given Sorted Array.
     * NOTE: As per the ask, every number should appear at least 2 times. So the adjacent numbers must be the same
     * except one position i.e. first appearance must be in the even index and the adjacent must be in the odd index.
     * Wherever this pattern is broken, we can see that the number appears on that side of the array.
     *
     * @param nums
     * @return uniqueNum
     */
    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // for comparison check if mid is even or odd
            if (mid % 2 == 1)
                mid--;

            // if adjacent numbers are equal, unique num is on the right side, else on the left
            if (nums[mid] == nums[mid + 1])
                start = mid + 2;
            else
                end = mid;
        }
        // when start == end, that's the unique number
        return nums[start];
    }
}
