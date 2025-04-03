package jp.dsa.array;

import java.util.Scanner;

/**
 * Q. Given an unsorted array arr[] and two numbers x and y
 * <p>
 *     Find the minimum distance between x and y in arr[]
 * </p>
 * <p>
 *     The array might contain duplicates
 * </p>
 * <p>
 *     Assume that x and y are different and present in the array
 * </p>
 */
public class MinDistBetnTwoNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, y, l, minDist;
        int[] arr;
        System.out.println("Enter number of elements: ");
        l = scanner.nextInt();
        arr = new int[l];
        System.out.println("Enter the elements in array: ");
        for (int i = 0; i < l; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Enter number value of x: ");
        x = scanner.nextInt();
        System.out.println("Enter number value of y: ");
        y = scanner.nextInt();
        minDist = minimumDistance(arr, x, y);
        System.out.println("Minimum distance between "+ x +" and " + y + " is: " + minDist);
    }

    /*
    * Inefficient code with O(n^2)
    static int minimumDistance(int[] arr, int x, int y) {
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if ((x == arr[i] && y == arr[j]) || (x == arr[j] && y == arr[i]) && minDist > Math.abs(i - j)) {
                    minDist = Math.abs(i - j);
                }
            }
        }
        return minDist;
    }
    */

    // Efficient code with O(n)
    static int minimumDistance(int[] arr, int x, int y) {
        int minDist = Integer.MAX_VALUE;

        // store first occurrence
        int i = 0, prev = 0;
        for (; i < arr.length; i++) {
            if (x == arr[i] || y == arr[i]) {
                prev = i;
                break;
            }
        }

        // check for other occurrences and update minDist
        // update the prev value if needed when arr[prev] != arr[i]
        for (; i < arr.length; i++) {
            if (x == arr[i] || y == arr[i]) {
                if (arr[prev] != arr[i] && (i - prev) < minDist) {
                    minDist = i - prev;
                }
                prev = i;
            }
        }
        return minDist;
    }
}
