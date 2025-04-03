package jp.dsa.array;

import java.util.Scanner;

/**
 * Q. You are given a list of n-1 numbers ranging from 1 - n
 * <p>
 * One of the integers is missing from the list
 * <p>
 * There are no duplicates in the list
 * <p>
 * There are no order of the list
 * */
public class FindMissingNumber {

    public static void main(String[] args) {
        int range;
        int[] arr;
        int missingNum;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the range: ");
        range = scanner.nextInt();
        arr = new int[range-1];
        System.out.println("Enter the numbers: ");
        for (int i=0; i < range-1; i++) {
            arr[i] = scanner.nextInt();
        }
        missingNum = findMissingNum(arr, range);
        System.out.println("The missing number is: " + missingNum);
    }

    /*
     * range = 6
     * xorOfArr = 1 ^ 2 ^ 3 ^ 4 ^ 5;
     * xorOfRange = 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6;
     * missingNum = xorOfArr ^ xorOfRange;
     * 0 ^ 6 = 6
     */
    static int findMissingNum(int[] arr, int range) {
        int xorOfArr = arr[0];
        int xorOfRange = 1;
        for (int i = 1; i < arr.length; i++) {
            xorOfArr = xorOfArr ^ arr[i];
        }
        for (int i = 2; i <= range; i++) {
            xorOfRange = xorOfRange ^ i;
        }
        return xorOfArr ^ xorOfRange;
    }
}
