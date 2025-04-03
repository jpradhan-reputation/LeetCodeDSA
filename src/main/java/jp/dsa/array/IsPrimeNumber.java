package jp.dsa.array;

public class IsPrimeNumber {
    public static void main(String[] args) {
        int num = 10;
        boolean isPrime = isPrime(num);
        if (isPrime)
            System.out.println("Prime number " + num + " is Prime");
        else
            System.out.println("Prime number " + num + " is not Prime");
    }

    static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 3; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
