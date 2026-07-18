/*
---------------------------------------------------------
Problem: Count Good Numbers

Platform: LeetCode

Difficulty: Medium

Approach:
Math (Modular Exponentiation)

Algorithm:
1. Compute the number of even indices:
   - (n + 1) / 2
2. Compute the number of odd indices:
   - n / 2
3. Calculate:
   - 5^(evenIndices) modulo (10^9 + 7)
   - 4^(oddIndices) modulo (10^9 + 7)
4. Multiply both values and take modulo.
5. Return the final result.

Time Complexity:
O(log n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/count-good-numbers/
---------------------------------------------------------
*/

class Solution {

    public int countGoodNumbers(long n) {

        long MOD = 1_000_000_007L;

        long evenIndices = (n + 1) / 2;
        long oddIndices = n / 2;

        long totalEvenChoices = power(5, evenIndices, MOD);
        long totalOddChoices = power(4, oddIndices, MOD);

        return (int) ((totalEvenChoices * totalOddChoices) % MOD);
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