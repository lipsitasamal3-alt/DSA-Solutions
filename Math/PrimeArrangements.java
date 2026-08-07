/*
---------------------------------------------------------
Problem: Prime Arrangements

Platform: LeetCode

Difficulty: Easy

Approach:
Math + Prime Counting

Algorithm:
1. Count the number of prime numbers from 1 to n.
2. Compute the number of non-prime numbers:
      nonPrimes = n - primes
3. Calculate:
      primes! % MOD
4. Calculate:
      nonPrimes! % MOD
5. Multiply the two factorials under modulo 1,000,000,007.
6. Return the result.

Helper Function:
1. If the number is less than 2, it is not prime.
2. Check divisibility from 2 to √x.
3. If any divisor exists, return false.
4. Otherwise, return true.

Time Complexity:
O(n√n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/prime-arrangements/
---------------------------------------------------------
*/

class Solution {

    public int numPrimeArrangements(int n) {

        final int MOD = 1_000_000_007;

        int primes = 0;

        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                primes++;
            }
        }

        int nonPrimes = n - primes;

        long answer = 1;

        for (int i = 1; i <= primes; i++) {
            answer = (answer * i) % MOD;
        }

        for (int i = 1; i <= nonPrimes; i++) {
            answer = (answer * i) % MOD;
        }

        return (int) answer;
    }

    private boolean isPrime(int x) {

        if (x < 2) {
            return false;
        }

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}