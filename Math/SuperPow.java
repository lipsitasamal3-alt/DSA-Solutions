/*
---------------------------------------------------------
Problem: Super Pow

Platform: LeetCode

Difficulty: Medium

Approach:
Math + Modular Exponentiation

Algorithm:
1. Reduce the base `a` modulo 1337.
2. Initialize the result as 1.
3. Traverse each digit in the exponent array:
   - Raise the current result to the power of 10 modulo 1337.
   - Compute a^(current digit) modulo 1337.
   - Multiply the two values modulo 1337.
4. Use fast modular exponentiation to efficiently compute powers.
5. Return the final result.

Time Complexity:
O(n × log 10)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/super-pow/
---------------------------------------------------------
*/

class Solution {

    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {

        long result = 1;
        a %= MOD;

        for (int digit : b) {

            long powerOfTen = modPow(result, 10);
            long powerOfDigit = modPow(a, digit);

            result = (powerOfTen * powerOfDigit) % MOD;
        }

        return (int) result;
    }

    private long modPow(long base, int exponent) {

        long result = 1;
        base %= MOD;

        while (exponent > 0) {

            if ((exponent & 1) == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exponent >>= 1;
        }

        return result;
    }
}