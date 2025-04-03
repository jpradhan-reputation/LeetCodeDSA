package jp.dsa.array;

import java.util.Arrays;

public class AddToArrayForm {
    public static void main(String[] args) {
        int[] arr = {9, 9, 9, 9, 9};
        int num = 99999;
        System.out.println("Array form: "+ Arrays.toString(addToArrayForm(arr, num)));
    }

    public static int[] addToArrayForm(int[] arr, int num) {
        int[] result = new int[arr.length + 1];
        int carry = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int sum = arr[i] + (num % 10) + carry;
            if (sum >= 10) {
                result[i + 1] = sum % 10;
                carry = sum / 10;
            } else {
                result[i + 1] = sum;
                carry = 0;
            }
            num /= 10;
        }
        if (carry != 0) {
            result[0] = carry;
            return result;
        } else {
            return Arrays.copyOfRange(result, 1, arr.length + 1);
        }
    }
}

