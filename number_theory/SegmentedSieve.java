package number_theory;

import java.io.*;
import java.util.*;

public class SegmentedSieve {

    public static List<Integer> simpleSieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
    public static void segmentedSieve(long L, long R) {
        int limit = (int) Math.sqrt(R) + 1;
        List<Integer> basePrimes = simpleSieve(limit);

        int rangeSize = (int) (R - L + 1);
        boolean[] isPrime = new boolean[rangeSize];
        Arrays.fill(isPrime, true);
        int count = 0;
        for (int prime : basePrimes) {
            long start = Math.max((long) prime * prime, ((L + prime - 1) / prime) * prime);
            
            for (long j = start; j <= R; j += prime) {
                isPrime[(int) (j - L)] = false;
            }
        }

        if (L == 1) {
            isPrime[0] = false;
        }

        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                count += 1;
            }
        }
        System.out.println(count);
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.print((L + i)+" ");
            }
        }


    }

   
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = reader.readLine().split(" ");
        long L = Long.parseLong(parts[0]);
        long R = Long.parseLong(parts[1]);


        segmentedSieve(L, R);
    }
}
