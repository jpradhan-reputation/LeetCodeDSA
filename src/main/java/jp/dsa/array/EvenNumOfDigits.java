package jp.dsa.array;

public class EvenNumOfDigits {
    public static void main(String[] args) {
        int[] arr = { 1, 23, 453, 784, 85, 9 };
        System.out.println(evenNumOfDigits(arr));
    }

    static int evenNumOfDigits(int[] arr) {
        int count = 0;
        for (int num: arr) {
            if (hasEvenNoOfDigit(num))
                count++;
        }
        return count;
    }

    static boolean hasEvenNoOfDigit(int num) {
        /*int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }*/
        return ((int)(Math.log10(num)) + 1) % 2 == 0;
    }
}
