package jp.dsa.array;

import java.util.Arrays;

public class PrimeNumbersInRange {
    public static void main(String[] args) {
        int range = 100;

        boolean[] primes = primeNumbers(range);
        System.out.println("Prime numbers within the range: " + range +" are: ");
        for (int i = 2; i < primes.length; i++) {
            if(primes[i])
                System.out.print(i + " ");
        }
    }

    static boolean[] primeNumbers(int range) {
        boolean[] primes = new boolean[range + 1];
        for (int i = 0; i <= range; i++)
            primes[i] = true;
        for (int i = 2; i * i <= range; i++)
            if (primes[i])
                for (int j = i * i; j <= range; j += i)
                    primes[j] = false;
        return primes;
    }
}
