package jp.dsa.sort.prblm;

public class ThirdHighestValue {
    public static int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;

        for (int num : nums) {
            long n = num;
            if (n == first || n == second || n == third)
                continue;

            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n > second) {
                third = second;
                second = n;
            } else if (n > third) {
                third = n;
            }
        }

        return (third == Long.MIN_VALUE) ? (int) first : (int) third;
    }

    public static void main(String[] args) {
        int[] nums = {1,-2147483648,2};
        System.out.println("Third Max: " + thirdMax(nums));
    }
}
