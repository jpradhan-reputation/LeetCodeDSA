package jp.dsa.bs;

public class CountNegativeNumbers {

    public static void main(String[] args) {
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));
    }
    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] arr : grid) {
            int index = findFirstNegativeIndex(arr);
            count += (arr.length - index);
        }
        return count;
    }

    public static int findFirstNegativeIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < 0)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }
}