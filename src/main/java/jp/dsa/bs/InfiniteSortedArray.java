package jp.dsa.bs;

public class InfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 9, 23, 56, 78};
        int target = 2;
        int index = findPos(arr, target);
        if (index != -1)
            System.out.println(target + " is at index: " + index);
        else
            System.out.println(target + " is not found.");
    }

    // Method takes an infinite size array and a key to be
    // searched and returns its position if found else -1.
    // We don't know size of arr[] and we can assume size to be
    // infinite in this function.
    // NOTE THAT THIS FUNCTION ASSUMES arr[] TO BE OF INFINITE SIZE
    // THEREFORE, THERE IS NO INDEX OUT OF BOUND CHECKING
    static int findPos(int[] arr, int target)
    {
        int l = 0, h = 1;
        int val = arr[0];

        // Find h to do binary search
        while (val < target)
        {
            l = h;     // store previous high
            //check that 2*h doesn't exceed array
            //length to prevent ArrayOutOfBoundException
            if (2 * h < arr.length - 1)
                h = 2 * h;
            else
                h = arr.length - 1;
            // update new val
            val = arr[h];
        }

        // at this point we have updated low
        // and high indices, thus use binary
        // search between them
        return binarySearchIterative(arr, target, l, h);
    }

    static int binarySearchIterative(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int middle = (start + end) / 2;
            if (target == arr[middle])
                return middle;
            if (target < arr[middle])
                end = middle - 1;
            else
                start = middle + 1;
        }
        return -1;
    }
}
