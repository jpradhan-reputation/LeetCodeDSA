package jp.dsa.bs;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        // [4,4,4,5,6,6,7,8,9,0,1,2,4,4]
        boolean isExist = search(nums, 0);
        System.out.println("Does the target exists in the array:: " + isExist);
    }

    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the target is found, return true.
            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates: If nums[left], nums[mid], and nums[right] are equal,
            // we can't determine the sorted part, so we shrink the range.
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // If the left half is sorted.
            else if (nums[left] <= nums[mid]) {
                // Check if the target is in the left half.
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search in the left half.
                } else {
                    left = mid + 1; // Search in the right half.
                }
            }
            // If the right half is sorted.
            else {
                // Check if the target is in the right half.
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Search in the right half.
                } else {
                    right = mid - 1; // Search in the left half.
                }
            }
        }
        return false; // Target not found.
    }
}
