package jp.dsa.bs;

public class CeilingOfNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int num = 18;
        int index = findCeilingOfNumber(arr, num);
        if (index != -1 && index < arr.length)
            System.out.println("Ceiling of " + num + " is: " + arr[index]);
        else
            System.out.println(num + " is not found or the largest in the list");
    }

    static int findCeilingOfNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (target == arr[middle])
                return middle;

            if (target < arr[middle])
                end = middle - 1;
            else
                start = middle + 1;
        }
        return start;
    }
}
