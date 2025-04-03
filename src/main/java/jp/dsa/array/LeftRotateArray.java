package jp.dsa.array;

import java.util.Arrays;

public class LeftRotateArray {
    public static int[] leftRotate(int[] arr, int s) {
        int l = arr.length;
        s = s % l;
        int i, j, k, temp;
        int gcdVal = gcd(s, l);
        for (i = 0; i < gcdVal; i++) {
            temp = arr[i];
            j = i;
            while (true) {
                k = j + s;
                if (k >= l)
                    k = k - l;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
        return arr;
    }

    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int steps = 3;
        arr = leftRotate(arr, steps);
        System.out.println(Arrays.toString(arr));
    }
}
