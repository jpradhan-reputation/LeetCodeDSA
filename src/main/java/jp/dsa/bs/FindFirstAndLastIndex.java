package jp.dsa.bs;

public class FindFirstAndLastIndex {
    public static void main(String[] args) {
        int[] arr = {1, 7, 7, 7, 7, 9, 56, 78};
        int target = 9;
        int[] indexes = searchRange(arr, target);
        if (indexes.length != 0)
            System.out.println("Start Index: " + indexes[0] + " and Last Index:" + indexes[1]);
        else
            System.out.println(target + " is not found.");
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = searchIndex(nums, target, true);
        int end = searchIndex(nums, target, false);
        return new int[]{start, end};
    }

    public static int searchIndex(int[] nums, int target, boolean isSearchStartIndex) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (target < nums[middle])
                end = middle - 1;
            else if (target > nums[middle])
                start = middle + 1;
            else {
                index = middle;
                if (isSearchStartIndex)
                    end = middle - 1;
                else
                    start = middle + 1;
            }
        }
        return index;
    }
}
