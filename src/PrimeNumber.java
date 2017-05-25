/**
 * Created by abhinavdas on 2/27/17.
 */

public class PrimeNumber {
    public static int countPrimes(int n) {
        int count = 0, counter = 2;
        while (count != n)
        {
            if (isPrime(counter)) count++;
            counter++;
        }
        return counter - 1;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String [] args)
    {
        System.out.println(countPrimes(10));
    }

}
