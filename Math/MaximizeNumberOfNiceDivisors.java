/*
---------------------------------------------------------
Problem: Maximize Number of Nice Divisors

Platform: LeetCode

Difficulty: Hard

Approach:
Greedy + Fast Modular Exponentiation

Algorithm:
1. If primeFactors ≤ 3, return primeFactors.
2. To maximize the product, split the number into as many 3s as possible.
3. Handle the remaining cases:
   - If primeFactors % 3 == 0:
     Answer = 3^(primeFactors / 3)
   - If primeFactors % 3 == 1:
     Replace one 3 + 1 with 2 + 2.
     Answer = 3^((primeFactors / 3) - 1) × 4
   - If primeFactors % 3 == 2:
     Answer = 3^(primeFactors / 3) × 2
4. Use Binary Exponentiation to compute powers efficiently under modulo 1e9+7.
5. Return the result.

Time Complexity:
O(log primeFactors)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/maximize-number-of-nice-divisors/
---------------------------------------------------------
*/

class Solution {

    public int maxNiceDivisors(int primeFactors) {

        if (primeFactors <= 3) {
            return primeFactors;
        }

        long MOD = 1_000_000_007;
        long result;

        if (primeFactors % 3 == 0) {
            result = power(3, primeFactors / 3, MOD);
        } else if (primeFactors % 3 == 1) {
            result = (power(3, (primeFactors / 3) - 1, MOD) * 4) % MOD;
        } else {
            result = (power(3, primeFactors / 3, MOD) * 2) % MOD;
        }

        return (int) result;
    }

    private long power(long base, long exp, long mod) {

        long result = 1;
        base %= mod;

        while (exp > 0) {

            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }

            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }
}