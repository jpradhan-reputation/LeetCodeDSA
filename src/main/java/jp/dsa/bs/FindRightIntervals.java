package jp.dsa.bs;

import java.util.*;

public class FindRightIntervals {
/*    public static int[] findRightInterval(int[][] intervals) {
        int[] rightIntervals = new int[intervals.length];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < intervals.length; i++) {
            int index = ceilOfNum(intervals, intervals[i][1]);
            if (intervals[index][0] >= intervals[i][1]) {
                rightIntervals[i] = index;
            } else {
                rightIntervals[i] = -1;
            }
        }
        return rightIntervals;
    }

    public static int ceilOfNum(int[][] intervals, int num) {
        int start = 0;
        int end = intervals.length - 1;
        int mid;

        while (start < end) {
            mid = start + (end - start) / 2;
            if (intervals[mid][0] == num)
                return mid;
            else if (intervals[mid][0] < num)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }*/

    public static void main(String[] args) {
        int[][] intervals = {{4,5},{2,3},{1,2}};

        System.out.println("Right intervals:: "+ Arrays.toString(findRightInterval(intervals)));
    }

    public static int[] findRightInterval(int[][] intervals) {
        int[] rightIntervals = new int[intervals.length];
        TreeMap<Integer, Integer> indexMap = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            indexMap.put(interval[0], i);
        }

        for (int i = 0; i < intervals.length; i++) {
            Integer ceilVal = indexMap.ceilingKey(intervals[i][1]);
            if (ceilVal != null)
                rightIntervals[i] = indexMap.get(ceilVal);
            else
                rightIntervals[i] = -1;
        }
        return rightIntervals;
    }
}
